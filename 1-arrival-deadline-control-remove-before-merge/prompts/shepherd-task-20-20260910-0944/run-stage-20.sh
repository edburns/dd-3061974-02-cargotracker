#!/usr/bin/env bash

set -Eeuo pipefail

repo='edburns/dd-3061974-02-cargotracker'
parent_issue=1
log_directory='/Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944'
body_directory="$log_directory/issue-bodies"
ledger_path="$log_directory/creation-ledger.json"
result_path="$log_directory/stage-20-result.json"
baseline_path="$log_directory/pre-creation-children.json"
verifier='/Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh'

subsections=(
    '4.1 — Issue 1: Add the application-layer deadline change operation'
    '4.2 — Issue 2: Expose deadline changes through the booking facade'
    '4.3 — Issue 3: Implement the deadline editor backing model'
    '4.4 — Issue 4: Implement the PrimeFaces deadline dialog'
    '4.5 — Issue 5: Integrate deadline editing into the Administration dashboard'
)
titles=(
    '4.1: Add the application-layer deadline change operation'
    '4.2: Expose deadline changes through the booking facade'
    '4.3: Implement the deadline editor backing model'
    '4.4: Implement the PrimeFaces deadline dialog'
    '4.5: Integrate deadline editing into the Administration dashboard'
)
body_files=(
    "$body_directory/01-4.1-body.md"
    "$body_directory/02-4.2-body.md"
    "$body_directory/03-4.3-body.md"
    "$body_directory/04-4.4-body.md"
    "$body_directory/05-4.5-body.md"
)

atomic_copy() {
    local source="$1"
    local destination="$2"
    local temporary
    temporary="$(mktemp "$(dirname "$destination")/.stage20.XXXXXX")"
    cp "$source" "$temporary"
    mv "$temporary" "$destination"
}

write_result() {
    local status="$1"
    local operation_error="$2"
    local temporary
    temporary="$(mktemp "$log_directory/.stage20-result.XXXXXX")"
    jq -n \
        --arg status "$status" \
        --arg operationError "$operation_error" \
        '{
            schemaVersion: 1,
            status: $status,
            ledgerFile: "creation-ledger.json",
            operationError: (if $operationError == "" then null else $operationError end)
        }' >"$temporary"
    mv "$temporary" "$result_path"
}

update_ledger() {
    local filter="$1"
    shift
    local temporary
    temporary="$(mktemp "$log_directory/.creation-ledger.XXXXXX")"
    jq "$@" "$filter" "$ledger_path" >"$temporary"
    mv "$temporary" "$ledger_path"
}

fail_stage() {
    trap - ERR
    local operation="$1"
    local message="$2"
    local operation_error="$operation: $message"
    local children_output normalized_children temporary

    if children_output="$(gh api "repos/$repo/issues/$parent_issue/sub_issues" --paginate --slurp 2>&1)"; then
        if normalized_children="$(printf '%s' "$children_output" | jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end' 2>&1)"; then
            temporary="$(mktemp "$log_directory/.creation-ledger.XXXXXX")"
            jq --argjson children "$normalized_children" '
                map(.id as $id | .linked = ([ $children[].id ] | index($id) != null))
            ' "$ledger_path" >"$temporary" && mv "$temporary" "$ledger_path"
        else
            operation_error="$operation_error; child reconciliation parse failed: $normalized_children"
        fi
    else
        operation_error="$operation_error; child reconciliation query failed: $children_output"
    fi

    write_result failed "$operation_error"
    printf 'STAGE 20 FAILED: %s\n' "$operation_error" >&2
    jq -r '.[] | "#\(.number) | \(.title) | \(.url) | \(.bodyFile) | body_verified=\(.body_verified) | linked=\(.linked)"' "$ledger_path" >&2
    jq -r --arg repo "$repo" '.[] | "gh issue delete \(.number) --repo \"\($repo)\" --yes"' "$ledger_path" >&2
    if [[ "$(jq 'length' "$ledger_path")" -eq 0 ]]; then
        printf 'No issues were created; no cleanup is required.\n' >&2
    else
        printf 'No automatic rollback was performed. Delete every issue in the ledger before invoking stage 20 again.\n' >&2
    fi
    exit 1
}

unexpected_failure() {
    local line="$1"
    local command="$2"
    fail_stage 'unexpected local operation' "line $line failed: $command"
}

trap 'unexpected_failure "$LINENO" "$BASH_COMMAND"' ERR

children_output="$(gh api "repos/$repo/issues/$parent_issue/sub_issues" --paginate --slurp 2>&1)" ||
    fail_stage 'pre-creation baseline query' "$children_output"
normalized_children="$(printf '%s' "$children_output" | jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end' 2>&1)" ||
    fail_stage 'pre-creation baseline normalization' "$normalized_children"
printf '%s\n' "$normalized_children" >"$baseline_path.tmp"
atomic_copy "$baseline_path.tmp" "$baseline_path"
rm "$baseline_path.tmp"

printf '[]\n' >"$ledger_path.tmp"
atomic_copy "$ledger_path.tmp" "$ledger_path"
rm "$ledger_path.tmp"
write_result in_progress ''

printf 'Creating child issues without an issue type (repository owner is a user).\n'

for index in "${!titles[@]}"; do
    title="${titles[$index]}"
    subsection="${subsections[$index]}"
    body_file="${body_files[$index]}"
    relative_body_file="issue-bodies/$(basename "$body_file")"

    created="$(gh api "repos/$repo/issues" \
        -X POST \
        -f title="$title" \
        -F "body=@$body_file" \
        --jq '{id,number,node_id,html_url,title}' 2>&1)" ||
        fail_stage "create '$title'" "$created"

    if ! jq -e 'type == "object" and (.id | type == "number") and (.number | type == "number") and (.html_url | type == "string")' <<<"$created" >/dev/null; then
        fail_stage "parse create response for '$title'" "$created"
    fi

    id="$(jq -r '.id' <<<"$created")"
    number="$(jq -r '.number' <<<"$created")"
    url="$(jq -r '.html_url' <<<"$created")"
    actual_title="$(jq -r '.title' <<<"$created")"

    update_ledger '. + [{
        implementationSubsection: $subsection,
        bodyFile: $bodyFile,
        id: $id,
        number: $number,
        title: $title,
        url: $url,
        body_verified: false,
        linked: false
    }]' \
        --arg subsection "$subsection" \
        --arg bodyFile "$relative_body_file" \
        --argjson id "$id" \
        --argjson number "$number" \
        --arg title "$actual_title" \
        --arg url "$url"

    issue_json="$("$verifier" \
        "$repo" \
        "$number" \
        "$body_file" \
        6 \
        5 \
        "$log_directory/issue-$number-body-verification-failure.json" 2>&1)" ||
        fail_stage "verify initial body for issue #$number" "$issue_json"

    update_ledger 'map(if .number == $number then .body_verified = true else . end)' --argjson number "$number"

    linked=false
    link_error=''
    for attempt in 1 2 3; do
        if link_output="$(printf '{"sub_issue_id": %s}' "$id" | gh api "repos/$repo/issues/$parent_issue/sub_issues" -X POST --input - 2>&1)"; then
            linked=true
            break
        fi
        link_error="attempt $attempt: $link_output"
    done
    [[ "$linked" == true ]] || fail_stage "link issue #$number to parent #$parent_issue" "$link_error"

    update_ledger 'map(if .number == $number then .linked = true else . end)' --argjson number "$number"
    printf 'Created, verified, and linked #%s: %s\n' "$number" "$actual_title"
done

children_output="$(gh api "repos/$repo/issues/$parent_issue/sub_issues" --paginate --slurp 2>&1)" ||
    fail_stage 'final child query' "$children_output"
final_children="$(printf '%s' "$children_output" | jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end' 2>&1)" ||
    fail_stage 'final child normalization' "$final_children"

baseline_count="$(jq 'length' "$baseline_path")"
ledger_count="$(jq 'length' "$ledger_path")"
final_count="$(jq 'length' <<<"$final_children")"
expected_final_count=$((baseline_count + ledger_count))
[[ "$final_count" -eq "$expected_final_count" ]] ||
    fail_stage 'final child count' "expected $expected_final_count children, observed $final_count"

new_child_ids="$(jq -c --argjson baseline "$(cat "$baseline_path")" '
    [ .[] | .id as $id | select(([ $baseline[].id ] | index($id)) == null) | .id ]
' <<<"$final_children")"
ledger_ids="$(jq -c '[.[].id]' "$ledger_path")"
[[ "$new_child_ids" == "$ledger_ids" ]] ||
    fail_stage 'final child order' "expected $ledger_ids, observed $new_child_ids"

duplicate_count="$(jq '[group_by(.id)[] | select(length != 1)] | length' <<<"$final_children")"
[[ "$duplicate_count" -eq 0 ]] ||
    fail_stage 'final child uniqueness' "found $duplicate_count duplicate linked child IDs"

while IFS=$'\t' read -r number body_file; do
    absolute_body_file="$log_directory/$body_file"
    issue_json="$("$verifier" \
        "$repo" \
        "$number" \
        "$absolute_body_file" \
        6 \
        5 \
        "$log_directory/issue-$number-final-body-verification-failure.json" 2>&1)" ||
        fail_stage "verify final body for issue #$number" "$issue_json"

    if ! jq -e '.state == "open" and (.assignees | type == "array" and length == 0)' <<<"$issue_json" >/dev/null; then
        fail_stage "verify final state for issue #$number" 'issue must be open and unassigned'
    fi
done < <(jq -r '.[] | [.number, .bodyFile] | @tsv' "$ledger_path")

write_result complete ''
printf 'STAGE 20 COMPLETE\n'
jq '.' "$ledger_path"
