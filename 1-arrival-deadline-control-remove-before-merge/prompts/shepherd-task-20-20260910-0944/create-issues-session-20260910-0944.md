# Copilot CLI Session

> [!NOTE]
> - **Session ID:** `5f189576-82f0-46fc-b0a0-88a0dc7bbc21`  
> - **Started:** 9/10/2026, 9:44:20 AM  
> - **Duration:** 2m 51s  
> - **Exported:** 9/10/2026, 9:47:12 AM  

---

<sub>3s</sub>

### User

Invoke skill `shepherd-task-20-create-issues-from-plan` with these inputs:

- CAMPAIGN_ID: c9e71f6c-ab48-4663-8125-5b796a989029
- LESSON_PROPAGATION: off
- REPO: edburns/dd-3061974-02-cargotracker
- BASE_BRANCH: experiment/shepherd-control
- PARENT_ISSUE: 1
- PLAN_DIRECTORY: 1-arrival-deadline-control-remove-before-merge
- PLAN_FILE_NAME: add-change-arrival-deadline-feature-ignorance-reduction-plan.md
- QUESTIONS_SECTION: ## Phase 3 — Ignorance reduction: questions to answer before writing code
- IMPLEMENTATION_SECTION: ## Phase 4 — Implementation (five serial issues)
- EXPECTED_TASK_COUNT: 5
- BASE_REMOTE: origin
- LOG_DIRECTORY: /Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944
- DRAFT_VALIDATOR: /Users/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh
- ISSUE_BODY_VERIFIER: /Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh

Fixture pagination response contract (mandatory):

- `gh api ... --paginate --slurp` returns a JSON array of page payloads, so a
  one-page response has the shape `[[{...}]]`, not `[{...}]`.
- Before indexing child issue fields such as `.id`, normalize the response to
  one flat issue array exactly once.
- In Bash, use:
  `jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end'`.
- In PowerShell, capture the `gh` output and `$LASTEXITCODE` first, then pass
  the complete JSON through the same `jq` normalization before
  `ConvertFrom-Json`.
- Use the normalized flat array for the pre-creation baseline, final child
  count/order checks, and failure reconciliation. Do not apply `add` a second
  time to an already-flat array.

---

<sub>6s</sub>

### `skill`

**shepherd-task-20-create-issues-from-plan**

<details>
<summary>Arguments</summary>

```json
{
  "skill": "shepherd-task-20-create-issues-from-plan"
}
```

</details>

```
Skill "shepherd-task-20-create-issues-from-plan" loaded successfully. Follow the instructions in the skill context.
```


---

<sub>10s</sub>

### Copilot

I’m validating the campaign inputs, plan structure, repository state, and drafting conventions before any GitHub mutation.

---

<sub>19s</sub>

### `bash`

**Validate local campaign inputs**

$ test -d '/Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944' && test -w '/Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944' && mkdir -p '/Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies' && test -x '/Users/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh' && test -x '/Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh' && git remote get-url origin && git show-ref --verify --quiet refs/heads/experiment/shepherd-control && git symbolic-ref refs/remotes/origin/HEAD && git show 'experiment/shepherd-control:1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md' > /tmp/c9e71f6c-plan.md && git show 'experiment/shepherd-control:1-arrival-deadline-control-remove-before-merge/shepherd-campaign.json' && git cat-file -e 'experiment/shepherd-control:1-arrival-deadline-control-remove-before-merge/campaign-lessons.md' && printf '\nLOCAL_VALIDATION_OK\n'

<details>
<summary>20 lines</summary>

```
git@github.com:edburns/dd-3061974-02-cargotracker.git
refs/remotes/origin/master
{
  "schemaVersion": 1,
  "campaignId": "c9e71f6c-ab48-4663-8125-5b796a989029",
  "campaignIssueNumber": 1,
  "campaignShortname": "arrival-deadline-control",
  "repository": "edburns/dd-3061974-02-cargotracker",
  "baseBranch": "experiment/shepherd-control",
  "lessonPropagation": "off",
  "campaignMetadataDirectory": "1-arrival-deadline-control-remove-before-merge",
  "lessonsFile": "campaign-lessons.md",
  "createdBy": {
    "shepherdTaskVersion": "1.0.2",
    "stageOutcomeProtocolVersion": 1
  },
  "createdAt": "2026-09-10T16:44:14Z"
}

LOCAL_VALIDATION_OK
<shellId: 1 completed with exit code 0>
```

</details>


---

<sub>19s</sub>

### `bash`

**Validate repository and parent**

$ export IDEA_HOME="/Applications/IntelliJ IDEA CE.app/Contents/MacOS" APPCAT_HOME=/Users/edburns/.appcat JAVA_HOME="/Library/Java/JavaVirtualMachines/microsoft-25.jdk/Contents/Home" ANT_HOME=${HOME}/Downloads/apache-ant-1.10.13 M2_HOME=${HOME}/Downloads/apache-maven-3.9.8; export PATH=${APPCAT_HOME}:${M2_HOME}/bin:${ANT_HOME}/bin:${JAVA_HOME}/bin:${IDEA_HOME}:${PATH}; gh api 'repos/edburns/dd-3061974-02-cargotracker' --jq '{default_branch,owner}' && gh api 'repos/edburns/dd-3061974-02-cargotracker/issues/1' --jq '{number,state,repository_url,title}' && gh api 'repos/edburns/dd-3061974-02-cargotracker/issues/1/sub_issues' --paginate --slurp | jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end'

```
{"default_branch":"master","owner":{"avatar_url":"https://avatars.githubusercontent.com/u/75821?v=4","events_url":"https://api.github.com/users/edburns/events{/privacy}","followers_url":"https://api.github.com/users/edburns/followers","following_url":"https://api.github.com/users/edburns/following{/other_user}","gists_url":"https://api.github.com/users/edburns/gists{/gist_id}","gravatar_id":"","html_url":"https://github.com/edburns","id":75821,"login":"edburns","node_id":"MDQ6VXNlcjc1ODIx","organizations_url":"https://api.github.com/users/edburns/orgs","received_events_url":"https://api.github.com/users/edburns/received_events","repos_url":"https://api.github.com/users/edburns/repos","site_admin":true,"starred_url":"https://api.github.com/users/edburns/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/edburns/subscriptions","type":"User","url":"https://api.github.com/users/edburns","user_view_type":"public"}}
{"number":1,"repository_url":"https://api.github.com/repos/edburns/dd-3061974-02-cargotracker","state":"open","title":"[Campaign][off] Cargo Tracker arrival-deadline control"}
[]
<shellId: 0 completed with exit code 0>
```


---

<sub>19s</sub>

### `view`

**view the file at /Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/01-1682-java-tool-ergonomics.md.**

/Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/01-1682-java-tool-ergonomics.md

<details>
<summary>15 lines</summary>

```
# Example 01: 1682-java-tool-ergonomics-prompts-remove-before-merge

Read `copilot-sdk/1682-java-tool-ergonomics-prompts-remove-before-merge/dd-3018003-ignorance-reduction-for-implementation-plan.md` (the plan) to get the context.

✅✅Pay very close attention to each **Resolution:** to the questions in `Phase 3 — Ignorance reduction: questions to answer before writing code`.

In this session, we are creating issues of type **Task** as children of Epic https://github.com/github/copilot-sdk/issues/1682 . These issues correspond to the sub-sections in `## Phase 4 — Implementation (the build order)`.

I want you to use `gh` to create issues as sub-issues of 1682.

- I will dispatch these issues by assigning them to an agent. Leave them unassigned for now.

- The description you put in the issues you create is the specification for the work the agent assigned to the issue must do. Therefore, you need to be very specific and targeted when writing the description.

- Set the type to **Task**.

- Each issue will be worked on and resolved in serial. You can assume:
  - All issues will operate in this topic branch of `upstream`: `edburns/1682-java-tool-ergonomics`.

  - The assignee agent has access to the topic branch and, most importantly, to the prompts in the directory `1682-java-tool-ergonomics-prompts-remove-before-merge`, which includes the plan. Therefore, you can instruct the agent to access the plan by reference, you don't need to reference it by value directly in the issue.

- The sub-sections of `## Phase 4 — Implementation (the build order)` have essential details for each corresponding **Task**.

- Instruct the agent to read the entire plan before working.

- Instruct the agent to carefully re-read the relevant sections of the of the plan. ❌❌You can't just say, "read the relevant sections of the plan". ✅✅In the description of the issue, list exactly what sections of the plan apply to this particular issue.
- Though the sub-sections of `## Phase 4 — Implementation (the build order)` have essential details for each corresponding **Task**, I want you to carefully consider if there additional gating tests you can add so that as the agent proceeds from one task to the next, the likelihood of rework is reduced.
```

</details>


---

<sub>19s</sub>

### `view`

**view the file at /Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/02-1810-java-tool-as-lambda.md.**

/Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/02-1810-java-tool-as-lambda.md

<details>
<summary>12 lines</summary>

```
# Example 02: 1810-java-tool-ergonomics-tool-as-lambda-remove-before-merge

Carefully read the plan `copilot-sdk/1810-java-tool-ergonomics-tool-as-lambda-remove-before-merge/1810-ignorance-reduction-for-implementation-plan.md`.

We have completed Phases 1 - 3. We are now on Phase 4.

For each sub item in Phase 4, file a child issue of Feature #1810.

Use `gh` to look at Epic #1682 and its child issues for the standard of verbosity and concreteness for issue descriptions.

The issue should be assignable to a coding agent and there must be sufficient detail in the description for the agent to proceed to completion.

Pull out the specific relevant content from Phase 3 as it applies to this current issue in Phase 4.

Tell the agent to take `edburns/1810-java-tool-ergonomics-tool-as-lambda` as the base branch. When I assign the issue to the coding agent, I will set this as the base branch.

Tell the agent to read `1810-java-tool-ergonomics-tool-as-lambda-remove-before-merge/1810-ignorance-reduction-for-implementation-plan.md`, which is present on the branch, for context.

Tell the agent which sub-item within Phase 4 they are solving.

Tell the agent that each issue will be assigned, resolved and merged to the base branch in the order in which they appear in the plan.

No work is to start until I assign each issue to the coding agent, in turn.
```

</details>


---

<sub>19s</sub>

### `view`

**view the file at /Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/03-dd-3017826-java-real-estate-demo.md.**

/Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/03-dd-3017826-java-real-estate-demo.md

<details>
<summary>14 lines</summary>

```
# Example 03: dd-3017826-java-real-estate-demo-remove-before-merge

Read `dd-3017826-java-real-estate-demo-remove-before-merge\dd-3017826-java-real-estate-demo-ignorance-reduction-plan.md` (the plan) to get the context.

✅✅Pay very close attention to each **Resolution:** to the questions in `Phase 2 — Ignorance reduction: questions to answer before writing code`.

In this session, we are creating sub-issues as children of https://github.com/edburns/Build26-BRK206-your-agent-anywhere-multiclient-multidevice-with-github-copilot-sdk/issues/2 . These issues correspond to the sub-sections in `## Phase 3 — Implementation (build order)`.

I want you to use `gh` to create issues as sub-issues of #2.

- I will dispatch these issues by assigning them to an agent. Leave them unassigned for now.

- The description you put in the issues you create is the specification for the work the agent assigned to the issue must do. Therefore, you need to be very specific and targeted when writing the description.

- Each issue will be worked on and resolved in serial. You can assume:
  - All issues will operate in this topic branch of `origin`: `edburns/2-build-out-demo`.

  - The assignee agent has access to the topic branch and, most importantly, to the prompts in the directory `dd-3017826-java-real-estate-demo-remove-before-merge`, which includes the plan. Therefore, you can instruct the agent to access the plan by reference, you don't need to reference it by value directly in the issue.

- The sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue.

- Instruct the agent to read the entire plan before working.

- Instruct the agent to carefully re-read the relevant sections of the of the plan. ❌❌You can't just say, "read the relevant sections of the plan". ✅✅In the description of the issue, list exactly what sections of the plan apply to this particular issue.
- Though the sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue, I want you to carefully consider if there additional gating tests you can add so that as the agent proceeds from one task to the next, the likelihood of rework is reduced.
```

</details>


---

<sub>19s</sub>

### `view`

**view the file at /Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/04-28-python-agent-demo.md.**

/Users/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/04-28-python-agent-demo.md

<details>
<summary>16 lines</summary>

```
# Example 04: 28-python-agent-demo-remove-before-merge

Read `28-python-agent-demo-remove-before-merge/28-python-agent-demo-ignorance-reduction-plan.md` (the plan) to get the context.

✅✅Pay very close attention to each **Resolution:** to the questions in `Phase 2 — Ignorance reduction: questions to answer before writing code`. These pertain to the implementation tasks in Phase 3. ✅✅✅ Make sure to put into the description explicit instructions on how to access the relevant spike research.

In this session, we are creating sub-issues as children of https://github.com/edburns/Build26-BRK206-your-agent-anywhere-multiclient-multidevice-with-github-copilot-sdk/issues/28 . These issues correspond to the sub-sections in `## Phase 3 — Implementation (build order)`.

I want you to use `gh` to create issues as sub-issues of #28

- I will dispatch these issues by assigning them to an agent. Leave them unassigned for now.

- The description you put in the issues you create is the specification for the work the agent assigned to the issue must do. Therefore, you need to be very specific and targeted when writing the description.

- Again, ✅✅For each **Resolution:** to the questions in `Phase 2 — Ignorance reduction: questions to answer before writing code`, include the relevant Resolution values in the issue description. These pertain to the implementation tasks in Phase 3. ✅✅✅ Make sure to put into the description explicit instructions on how to access the relevant spike research for that task.

- For tasks dealing with the UI, make sure to refer to the relevant screengrabs, but only ones within `28-python-agent-demo-remove-before-merge/`.

- Each issue will be worked on and resolved in serial. You can assume:
  - All issues will operate in this topic branch of `origin`: `edburns/28-python-agent-demo`.

  - The assignee agent has access to the topic branch and, most importantly, to the prompts in the directory `28-python-agent-demo-remove-before-merge/`, which includes the plan. Therefore, you can instruct the agent to access the plan by reference, you don't need to reference it by value directly in the issue.

- The sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue.

- Instruct the agent to read the entire plan before working.

- Instruct the agent to carefully re-read the relevant sections of the of the plan. ❌❌You can't just say, "read the relevant sections of the plan". ✅✅In the description of the issue, list exactly what sections of the plan apply to this particular issue.
- Though the sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue, I want you to carefully consider if there additional gating tests you can add so that as the agent proceeds from one task to the next, the likelihood of rework is reduced.
```

</details>


---

<sub>19s</sub>

### `view`

**view the file at /Users/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh.**

/Users/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh

<details>
<summary>66 lines</summary>

```
#!/usr/bin/env bash
# shepherd-task-version: 1.0.2

set -euo pipefail

[[ $# -eq 3 ]] || {
    echo "Usage: $0 <body-directory> <expected-count> <off|campaign>" >&2
    exit 1
}

body_directory="$1"
expected_count="$2"
lesson_propagation="$3"

[[ -d "$body_directory" ]] || {
    echo "Stage-20 body directory does not exist: $body_directory" >&2
    exit 1
}
[[ "$expected_count" =~ ^[1-9][0-9]*$ ]] || {
    echo "Expected count must be a positive integer." >&2
    exit 1
}
[[ "$lesson_propagation" == "off" || "$lesson_propagation" == "campaign" ]] || {
    echo "Lesson propagation must be off or campaign." >&2
    exit 1
}

body_files=()
while IFS= read -r -d '' body_file; do
    body_files+=("$body_file")
done < <(
    find "$body_directory" -maxdepth 1 -type f -name '*-body.md' \
        ! -name '*-observed-body.md' -print0
)
[[ ${#body_files[@]} -eq $expected_count ]] || {
    echo "Expected $expected_count persisted stage-20 body files; found ${#body_files[@]}." >&2
    exit 1
}

required_headings=(
    '## Campaign context and required reading'
    '## Branch and execution order'
    '## Implement'
    '## Completion gates'
    '## Out of scope'
)

for body_file in "${body_files[@]}"; do
    [[ -s "$body_file" && "$(awk 'END { print NR }' "$body_file")" -gt 1 ]] || {
        echo "Persisted issue body must contain physical Markdown lines: $body_file" >&2
        exit 1
    }
    first_nonblank="$(awk 'NF { print; exit }' "$body_file")"
    [[ "$first_nonblank" =~ ^##[[:space:]]+[^[:space:]] ]] || {
        echo "Persisted issue body must begin with a level-two heading: $body_file" >&2
        exit 1
    }
    for heading in "${required_headings[@]}"; do
        grep -Fqx -- "$heading" "$body_file" || {
            echo "Persisted issue body is missing the physical heading '$heading': $body_file" >&2
            exit 1
        }
    done
    if [[ "$lesson_propagation" == "campaign" ]]; then
        grep -Fqx -- '## Campaign lessons (REQUIRED)' "$body_file" || {
            echo "Treatment issue body is missing its campaign-lessons heading: $body_file" >&2
            exit 1
        }
    elif grep -Fqx -- '## Campaign lessons (REQUIRED)' "$body_file"; then
        echo "Control issue body unexpectedly contains a campaign-lessons heading: $body_file" >&2
        exit 1
    fi
done
```

</details>


---

<sub>19s</sub>

### `view`

**view the file at /Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh.**

/Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh

<details>
<summary>131 lines</summary>

```
#!/usr/bin/env bash
# shepherd-task-version: 1.0.2
set -euo pipefail

fail() {
    printf 'verify-github-issue-body: %s\n' "$*" >&2
    exit 1
}

[[ $# -ge 3 && $# -le 6 ]] ||
    fail "usage: $0 OWNER/REPO ISSUE_NUMBER EXPECTED_BODY_PATH [MAX_ATTEMPTS] [DELAY_SECONDS] [DIAGNOSTIC_PATH]"

repository="$1"
issue_number="$2"
expected_body_path="$3"
max_attempts="${4:-6}"
delay_seconds="${5:-5}"
diagnostic_path="${6:-}"
gh_command="${GH_COMMAND:-gh}"

[[ "$repository" =~ ^[A-Za-z0-9_.-]+/[A-Za-z0-9_.-]+$ ]] ||
    fail "invalid repository: $repository"
[[ "$issue_number" =~ ^[1-9][0-9]*$ ]] ||
    fail "invalid issue number: $issue_number"
[[ "$max_attempts" =~ ^[1-9][0-9]*$ ]] ||
    fail "MAX_ATTEMPTS must be a positive integer"
[[ "$delay_seconds" =~ ^[0-9]+$ ]] ||
    fail "DELAY_SECONDS must be a non-negative integer"
[[ -f "$expected_body_path" ]] ||
    fail "expected issue body file not found: $expected_body_path"

temp_directory="$(mktemp -d)"
trap 'rm -rf "$temp_directory"' EXIT
response_path="$temp_directory/response.json"
actual_path="$temp_directory/actual.txt"
actual_normalized="$temp_directory/actual-normalized.txt"
expected_normalized="$temp_directory/expected-normalized.txt"

normalize_file() {
    jq -Rsj 'gsub("\r\n|\r"; "\n")' "$1" >"$2"
}

equivalent_files() {
    local actual="$1"
    local expected="$2"
    local candidate="$temp_directory/candidate.txt"

    cmp -s -- "$actual" "$expected" && return 0
    cp "$actual" "$candidate"
    printf '\n' >>"$candidate"
    cmp -s -- "$candidate" "$expected" && return 0
    cp "$expected" "$candidate"
    printf '\n' >>"$candidate"
    cmp -s -- "$actual" "$candidate"
}

sha256_file() {
    if command -v sha256sum >/dev/null 2>&1; then
        sha256sum "$1" | awk '{print $1}'
    else
        shasum -a 256 "$1" | awk '{print $1}'
    fi
}

write_diagnostic() {
    local reason="$1"
    local attempts="$2"
    [[ -n "$diagnostic_path" ]] || return 0

    mkdir -p "$(dirname "$diagnostic_path")"
    local expected_length actual_length expected_hash actual_hash first_offset
    expected_length="$(wc -c <"$expected_normalized" | tr -d ' ')"
    actual_length="$(wc -c <"$actual_normalized" | tr -d ' ')"
    expected_hash="$(sha256_file "$expected_normalized")"
    actual_hash="$(sha256_file "$actual_normalized")"
    first_offset="$( (cmp -l -- "$actual_normalized" "$expected_normalized" 2>/dev/null || true) | awk 'NR == 1 { print $1 - 1 }')"
    [[ -n "$first_offset" ]] || first_offset="null"

    jq -n \
        --arg repository "$repository" \
        --argjson issueNumber "$issue_number" \
        --arg endpoint "repos/$repository/issues/$issue_number" \
        --argjson attempts "$attempts" \
        --arg observedAt "$(date -u +%Y-%m-%dT%H:%M:%SZ)" \
        --arg reason "$reason" \
        --argjson expectedLength "$expected_length" \
        --argjson actualLength "$actual_length" \
        --arg expectedSha256 "$expected_hash" \
        --arg actualSha256 "$actual_hash" \
        --argjson firstDifferenceOffset "$first_offset" \
        '{
            schemaVersion: 1,
            repository: $repository,
            issueNumber: $issueNumber,
            endpoint: $endpoint,
            attempts: $attempts,
            observedAt: $observedAt,
            reason: $reason,
            expectedLength: $expectedLength,
            actualLength: $actualLength,
            expectedSha256: $expectedSha256,
            actualSha256: $actualSha256,
            firstDifferenceOffset: $firstDifferenceOffset
        }' >"$diagnostic_path"
}

normalize_file "$expected_body_path" "$expected_normalized"
last_reason=""

for ((attempt = 1; attempt <= max_attempts; attempt++)); do
    set +e
    "$gh_command" api "repos/$repository/issues/$issue_number" >"$response_path" 2>"$temp_directory/error.txt"
    exit_code=$?
    set -e

    if [[ $exit_code -ne 0 ]]; then
        last_reason="GitHub REST request failed with exit code $exit_code."
        error_message="$(cat "$temp_directory/error.txt")"
        authentication_error_pattern='HTTP[[:space:]]+(401|403)|[Aa]uthentication|[Nn]ot[[:space:]]authorized|[Rr]esource[[:space:]]not[[:space:]]accessible'
        if [[ "$error_message" =~ $authentication_error_pattern ]]; then
            : >"$actual_normalized"
            write_diagnostic "$last_reason" "$attempt"
            fail "unable to fetch issue #$issue_number from $repository: $error_message"
        fi
    elif ! jq -e 'type == "object" and has("body")' "$response_path" >/dev/null 2>&1; then
        last_reason="GitHub REST response was invalid JSON."
    else
        jq -j '.body // ""' "$response_path" >"$actual_path"
        normalize_file "$actual_path" "$actual_normalized"
        if equivalent_files "$actual_normalized" "$expected_normalized"; then
            cat "$response_path"
            exit 0
        fi
        last_reason="GitHub issue body differs from the persisted draft."
    fi

    if [[ $attempt -lt $max_attempts ]]; then
        printf 'verify-github-issue-body: %s Retrying issue #%s body verification (%s/%s).\n' \
            "$last_reason" "$issue_number" "$attempt" "$max_attempts" >&2
        ((delay_seconds > 0)) && sleep "$delay_seconds"
    fi
done

[[ -f "$actual_normalized" ]] || : >"$actual_normalized"
write_diagnostic "$last_reason" "$max_attempts"
diagnostic_suffix=""
[[ -z "$diagnostic_path" ]] || diagnostic_suffix=" Diagnostic: $diagnostic_path"
fail "issue #$issue_number body verification failed after $max_attempts attempts. $last_reason$diagnostic_suffix"
```

</details>


---

<sub>23s</sub>

### Copilot

The invocation is valid: the base branch exists and is non-default, parent #1 is open, the campaign manifest matches, there are no existing children, and this user-owned repository will use untyped issues. I’m now extracting every resolved constraint and the five ordered task specifications.

---

<sub>25s</sub>

### `view`

**view the file at /Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md.**

/Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md

<details>
<summary>679 lines</summary>

````
# Implementation plan: Change Arrival Deadline Date (`eclipse-ee4j/cargotracker#64`)

Human DRI: Ed Burns
Starting commit: `9b9f311b2a3a2854bdac947593950d9edb6bca7d` (`Make the system ready for implementation`)
Working directory: repository root of the current campaign worktree
Runtime baseline: Java 17, Java EE 7 (`javax.*`), Open Liberty 26.0.0.8, PrimeFaces 8.0
Baseline run instructions: `README.md`
Baseline preparation: fixed source branch and immutable SHA validated by the campaign fixture
Historical issue: `eclipse-ee4j/cargotracker#64`

Related directories and files:

- `src/main/java/org/eclipse/cargotracker/application/`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/`
- `src/main/webapp/admin/dialogs/`
- `src/main/webapp/admin/tables/listNotRouted.xhtml`
- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`

---

## Goal

Add an Administration dashboard operation that lets a shipping administrator
change the arrival deadline of a cargo listed in the **Not Routed Cargo** table.
The operation must preserve Cargo Tracker's layered architecture:

1. The application service owns the domain mutation.
2. The booking facade shields the web layer from domain types.
3. A JSF backing bean loads and submits the editable date.
4. A PrimeFaces dynamic dialog presents the editor.
5. The existing Not Routed Cargo table opens the dialog and refreshes after a
   successful update.

### User-visible acceptance behavior

Using the stable sample cargo `DEF789`:

1. Start the application with Java 17:

   ```bash
   ./mvnw clean package -Popenliberty liberty:run
   ```

2. Open `http://localhost:8080/cargo-tracker/`.
3. Select **Administration**.
4. Find `DEF789` in the **Not Routed Cargo** table.
5. The Deadline cell displays its date together with an edit icon.
6. Hovering over the deadline displays:
   `Click to change cargo arrival deadline date.`
7. Selecting the deadline opens a modal dialog titled **Change Deadline**.
8. The dialog displays the cargo's origin and destination as read-only
   context.
9. The date editor is initialized to the cargo's current arrival deadline.
10. Selecting a different date and pressing **Update** closes the dialog and
    refreshes the Administration view.
11. The new date is shown in the Not Routed Cargo table.
12. Reloading the page continues to show the new date for the lifetime of the
    running in-memory sample application.
13. Pressing **Cancel** closes the dialog without changing the deadline.

### Domain acceptance behavior

Changing the deadline must:

- locate the cargo by `TrackingId`;
- preserve its existing origin;
- preserve its existing destination;
- replace only the arrival deadline in its `RouteSpecification`;
- apply the specification through `Cargo.specifyNewRoute(...)`;
- preserve the currently assigned itinerary rather than silently discarding
  it;
- allow the domain model to recalculate routing status and delivery-derived
  values against the new route specification;
- persist the changed cargo through `CargoRepository.store(...)`.

### Hard scope constraints

- Begin from commit `9b9f311b2a3a2854bdac947593950d9edb6bca7d`.
- Preserve Java EE 7 and the `javax.*` namespace.
- Preserve the Java 7 source/target level used by this historical codebase.
- Run the application on JDK 17 using the existing Open Liberty profile.
- Do not migrate the application to Jakarta EE 8+, Jakarta EE 9+, Spring, or a
  different UI framework.
- Do not replace the in-memory Derby configuration or the Open Liberty runtime.
- Do not redesign unrelated cargo booking, routing, destination editing,
  messaging, batch, REST, or persistence behavior.
- Do not copy commits or files from feature-bearing branches. This plan is the
  implementation specification.
- Implement the five build issues below in order. Each issue must be complete
  and gated before the next issue begins.

---

## Completed phases

### Phase 1 ✅ — Establish a runnable feature-absent baseline

- Commit `9b9f311b2a3a2854bdac947593950d9edb6bca7d` is based on the historical
  feature-absent commit and contains only the compatibility work needed to run
  the sample on JDK 17 and Open Liberty.
- `./mvnw clean package -Popenliberty liberty:run` starts the application.
- The home page and Administration flows return HTTP 200.
- JSF view metadata is placed at `UIViewRoot` scope for MyFaces compatibility.
- The internal routing REST client works without a Jersey/MOXy classloading
  conflict.
- The scheduled batch job has the local authorization it needs.

### Phase 2 ✅ — Verify the before and after user experience

- Before implementation, `DEF789` appears in the Not Routed Cargo table with a
  plain-text deadline and no edit operation.
- The neighboring Destination column demonstrates the existing PrimeFaces
  dynamic-dialog interaction pattern.
- The desired after behavior has been manually exercised: open the deadline
  editor, choose a new date, update, refresh the table, and observe the
  persisted value.
- The historical architectural boundaries and affected files have been
  identified.

---

## Phase 3 — Ignorance reduction: questions to answer before writing code

Resolve these questions before production implementation begins. The
recommendations intentionally define the desired design closely enough that an
implementing agent should not need to invent a different architecture.

### 3.1 — Which cargos expose the edit operation?

**Question:** Should deadline editing be exposed for all cargos or only for
cargos displayed in the Not Routed Cargo table?

The requested feature originates in the Administration dashboard's Not Routed
Cargo table. Other tables represent routed, misrouted, claimed, or otherwise
progressed cargo. Adding the affordance to every table would expand the feature
and require additional business rules about changing deadlines after handling
has begun.

| Option | UI scope | Trade-off |
|--------|----------|-----------|
| A | Not Routed Cargo table only | Matches the requested feature and the established destination-edit affordance. |
| B | Every Administration cargo table | Broader capability, but introduces lifecycle and authorization questions outside the request. |
| C | Cargo details page only | Avoids table complexity but does not meet the requested dashboard interaction. |

The application-service operation itself does not need to encode a UI-table
restriction. It should accept a tracking ID and apply the domain mutation to
the located cargo. The presentation layer determines where the operation is
offered.

**Recommendation:** Option A. Add the edit affordance only to
`src/main/webapp/admin/tables/listNotRouted.xhtml`. Keep the application
operation generally usable for a valid cargo.

**Resolution:**

Select Option A. Expose the edit affordance only in
`src/main/webapp/admin/tables/listNotRouted.xhtml`. The application and facade
operations remain generally callable for any cargo that can be found by
tracking ID; they do not encode knowledge of dashboard table membership.

### 3.2 — What is the exact domain mutation?

**Question:** Should the feature mutate the existing `RouteSpecification`, add
a setter to `Cargo`, or replace the specification using the existing domain
operation?

`RouteSpecification` is a value object describing origin, destination, and
arrival deadline. The existing `changeDestination(...)` implementation already
establishes the correct pattern: create a replacement specification, call
`Cargo.specifyNewRoute(...)`, and store the aggregate.

Proposed application-service shape:

```java
void changeDeadline(TrackingId trackingId, Date deadline);
```

Proposed implementation:

```java
Cargo cargo = cargoRepository.find(trackingId);
RouteSpecification specification = new RouteSpecification(
        cargo.getOrigin(),
        cargo.getRouteSpecification().getDestination(),
        deadline);

cargo.specifyNewRoute(specification);
cargoRepository.store(cargo);
```

Calling `specifyNewRoute(...)` is significant. It lets the aggregate recalculate
delivery and routing status relative to the new specification. Direct field
mutation or a persistence-only update would bypass that behavior.

**Recommendation:** Replace the `RouteSpecification` through
`Cargo.specifyNewRoute(...)`. Preserve origin, destination, and itinerary.
Persist using the existing repository. Do not add a deadline setter to the
domain model.

**Resolution:**

Use the same aggregate-update pattern as `changeDestination(...)`. Add
`BookingService.changeDeadline(TrackingId, Date)` and implement it by loading
the cargo, constructing a new `RouteSpecification` from the existing origin,
existing destination, and supplied deadline, calling
`cargo.specifyNewRoute(...)`, and storing the cargo through
`cargoRepository.store(...)`. Do not add mutable deadline setters to the domain
objects.

### 3.3 — What should happen to an existing itinerary and delivery state?

**Question:** When a routed cargo's deadline changes, should its itinerary be
cleared, retained, or recomputed?

Although the UI initially exposes the feature only for unrouted cargo, the
application operation should have deterministic domain behavior if invoked for
a routed cargo. The existing `changeDestination(...)` behavior preserves the
assigned itinerary and lets `Cargo.specifyNewRoute(...)` recalculate whether
that itinerary still satisfies the new specification.

The core application test should deliberately invoke the operation after:

1. booking a cargo;
2. requesting route candidates;
3. assigning an itinerary;
4. changing its destination;
5. changing its deadline.

This sequence verifies that the feature uses the aggregate correctly rather
than assuming the cargo always has an empty itinerary.

**Recommendation:** Preserve the itinerary. Let the domain model recompute
routing and delivery-derived state. Assert all unaffected fields explicitly in
`BookingServiceTest`.

**Resolution:**

Retain the existing itinerary. Do not clear, replace, or reroute it as part of
the deadline change. `Cargo.specifyNewRoute(...)` recalculates the delivery
snapshot and routing status against the replacement specification. In the
established sequential application test, the assigned itinerary remains
unchanged and the cargo remains `MISROUTED` after the deadline changes.

### 3.4 — What type crosses the facade boundary?

**Question:** Should the booking facade accept a `Date`, a formatted string, or
a newly introduced request DTO?

The existing facade already uses `java.util.Date` for
`bookNewCargo(...)`. Introducing another representation for this one operation
would create unnecessary conversion code and depart from the historical
application style.

Proposed facade shape:

```java
void changeDeadline(String trackingId, Date arrivalDeadline);
```

The implementation converts only the identifier:

```java
bookingService.changeDeadline(
        new TrackingId(trackingId),
        arrivalDeadline);
```

**Recommendation:** Use `String` for the tracking ID and `java.util.Date` for
the deadline. Do not expose `TrackingId`, `Cargo`, or `RouteSpecification` to
the JSF layer and do not introduce a new DTO solely for this command.

**Resolution:**

Add `void changeDeadline(String trackingId, Date arrivalDeadline)` to
`BookingServiceFacade`. `DefaultBookingServiceFacade` converts the string to
`new TrackingId(trackingId)` and passes the same `Date` to
`BookingService.changeDeadline(...)`. No new command DTO or formatted-string
service parameter is introduced.

### 3.5 — How is the DTO's formatted deadline converted for editing?

**Question:** `CargoRoute` exposes its deadline as formatted strings, while
`p:datePicker` binds naturally to `java.util.Date`. How should the backing bean
initialize the editor?

At the starting commit:

- `CargoRoute.getArrivalDeadline()` returns
  `MM/dd/yyyy hh:mm a z`.
- `CargoRoute.getArrivalDeadlineDate()` returns only the date component.
- The table displays `getArrivalDeadlineDate()`.

Options:

| Option | Approach | Trade-off |
|--------|----------|-----------|
| A | Parse `cargo.getArrivalDeadlineDate()` with `MM/dd/yyyy` | Small, localized change; preserves the existing DTO contract. |
| B | Add a `Date` property to `CargoRoute` | Cleaner typing, but broadens a DTO used throughout the application. |
| C | Reload the domain object in the backing bean | Violates the facade boundary. |

The formatter/parser must be created per operation or per view bean; do not add
a shared mutable `SimpleDateFormat`.

**Recommendation:** Option A. Load `CargoRoute` through
`BookingServiceFacade.loadCargoForRouting(trackingId)` and parse
`cargo.getArrivalDeadlineDate()` using `new SimpleDateFormat("MM/dd/yyyy")`.
Surface an explicit failure if the existing DTO value cannot be parsed; do not
silently submit a null date.

**Resolution:**

Use Option A and keep date conversion inside the view-scoped editor bean. The
existing implementation loads the `CargoRoute`, creates
`new SimpleDateFormat("MM/dd/yyyy")`, and parses the leading date portion of
`cargo.getArrivalDeadline()`. Because that value begins with `MM/dd/yyyy`,
`SimpleDateFormat.parse(...)` obtains the same date that
`getArrivalDeadlineDate()` displays. A per-load formatter is used, so no shared
mutable formatter is added.

### 3.6 — Which JSF bean scopes and interaction pattern should be used?

**Question:** Should deadline editing introduce a new navigation page, use an
inline editor, or mirror the existing Change Destination dynamic-dialog
pattern?

The baseline already contains:

- `ChangeDestination`, a CDI `@Named` and JSF `@ViewScoped` editor bean;
- `ChangeDestinationDialog`, a session-scoped JSF managed bean that opens and
  closes a PrimeFaces dynamic dialog;
- `changeDestination.xhtml`, a dialog view;
- a `dialogReturn` Ajax listener that refreshes `tableNotRouted`.

Using the same pattern minimizes changes and provides a consistent user
experience.

Proposed bean names:

```text
changeArrivalDeadlineDate
changeArrivalDeadlineDateDialog
```

**Recommendation:** Add a serializable CDI `@Named @ViewScoped`
`ChangeArrivalDeadlineDate` editor and a serializable
`@ManagedBean(name = "changeArrivalDeadlineDateDialog") @SessionScoped`
launcher. Mirror the existing destination-dialog lifecycle rather than
introducing a new navigation or inline-edit framework.

**Resolution:**

Mirror the existing Change Destination interaction. Implement
`ChangeArrivalDeadlineDate` as a serializable CDI `@Named @ViewScoped` bean and
`ChangeArrivalDeadlineDateDialog` as a serializable
`@ManagedBean(name = "changeArrivalDeadlineDateDialog") @SessionScoped` bean.
Use a PrimeFaces dynamic dialog rather than navigation to a full page or inline
cell editing.

### 3.7 — What is the dynamic-dialog contract?

**Question:** What path, request parameters, dimensions, and close result should
the PrimeFaces dialog use?

The launcher needs one parameter, `trackingId`, supplied as a
`Map<String, List<String>>`. The dialog metadata binds the parameter and invokes
the editor bean's `load()` action.

Proposed launcher contract:

```java
PrimeFaces.current().dialog().openDynamic(
        "/admin/dialogs/changeArrivalDeadlineDate.xhtml",
        options,
        params);
```

Required options:

| Option | Value |
|--------|-------|
| `modal` | `true` |
| `draggable` | `true` |
| `resizable` | `false` |
| `contentWidth` | `410` |
| `contentHeight` | `280` |

Required completion behavior:

- successful update: `closeDynamic("DONE")`;
- cancel: `closeDynamic("")`;
- caller listens for `dialogReturn` and updates `tableNotRouted`.

Because Open Liberty uses MyFaces, `<f:metadata>` must be a direct child of the
view root, before `<h:head>` and `<h:body>`. It must not be nested inside
`<h:body>`.

**Recommendation:** Use the contract above and preserve the metadata placement
required by the prepared baseline.

**Resolution:**

Open `/admin/dialogs/changeArrivalDeadlineDate.xhtml` with a single
`trackingId` request parameter and these options: modal and draggable are
`true`, resizable is `false`, content width is `410`, and content height is
`280`. Successful submission closes with `"DONE"`; cancellation closes with
the empty string. The caller handles `dialogReturn` and updates
`tableNotRouted`. Place the dialog's `<f:metadata>` directly under the root
`<html>` element, before `<h:head>` and `<h:body>`, so the known MyFaces
`UIViewRoot` requirement is satisfied.

### 3.8 — What date validation is required?

**Question:** Must the new deadline be non-null, in the future, after the
current date, or after itinerary completion?

The requested feature is an administrative correction to an existing arrival
deadline. No new domain policy about future dates is part of the request.
Inventing such a rule could reject dates accepted by existing cargo booking or
`RouteSpecification` behavior.

The UI must nevertheless prevent a null submission because the operation
requires a concrete replacement deadline.

**Recommendation:** Require a date value in the JSF form and display a normal
Faces validation message when it is absent. Do not add a new minimum-date,
future-date, or itinerary-date business rule. Continue to rely on the existing
domain model for its established invariants.

**Resolution:**

Require a non-null date selection, but add no new chronological business rule.
In particular, do not require the replacement deadline to be after today,
after the old deadline, or after every itinerary leg. Pass the selected
`java.util.Date` to the existing domain construction path and let the current
`RouteSpecification` invariants apply.

### 3.9 — How will the feature be tested on the prepared historical baseline?

**Question:** Which automated and runtime tests are mandatory, given that the
historical JUnit/Arquillian suite is configured for a remote Payara 4
container, while the prepared production baseline runs on JDK 17/Open Liberty?

The starting POM deliberately leaves `skipTests=true`. The Open Liberty profile
builds and compiles all test sources but does not provide a Liberty Arquillian
adapter. Modernizing the entire integration-test runtime is outside this
feature's scope.

The feature still needs layered evidence:

1. Extend `BookingServiceTest` with the domain/application assertions that
   specify the deadline mutation.
2. Ensure all test sources compile as part of
   `./mvnw clean package -Popenliberty`.
3. Add focused JUnit tests for facade and backing-bean delegation where they
   can run without a container, using hand-written fakes rather than adding a
   mocking framework.
4. Perform mandatory end-to-end verification against the running Open Liberty
   application.
5. Preserve the existing Payara Arquillian test path; do not delete, disable,
   or rewrite it to manufacture a passing result.

**Spike needed:** Before Issue 1 implementation, run the starting commit's
standard Open Liberty package command and record whether tests are compiled but
skipped. Confirm the new `BookingServiceTest` method can be added without
expanding the runtime modernization scope.

**Recommendation:** Treat the JDK 17/Open Liberty build plus HTTP/UI acceptance
as the mandatory executable gate. Keep the historical Arquillian test as a
precise application-layer specification and run it only when its documented
Payara environment is available.

**Resolution:**

Extend the existing sequential Arquillian `BookingServiceTest` with
`testChangeDeadline()` after `testChangeDestination()`. The test changes the
deadline by one month, reloads the cargo through JPA, and asserts the complete
set of preserved and recalculated domain state described above. The prepared
Open Liberty build compiles this test but retains the historical default
`skipTests=true`; executing that Arquillian suite still requires its documented
remote Payara environment. Therefore the mandatory executable gates are the
JDK 17 Open Liberty package/start command, direct HTTP checks, and the complete
`DEF789` browser acceptance flow. No Arquillian-runtime modernization or new
mocking dependency is part of this feature.

---

## Phase 4 — Implementation (five serial issues)

Implement these issues in order. Each issue should be a separate commit. Do not
start an issue until the previous issue's gating criteria are satisfied.

### 4.1 — Issue 1: Add the application-layer deadline change operation

**What to build**

Add the core use case to the application layer. This issue must contain no JSF
or PrimeFaces changes.

**Files to modify**

- `src/main/java/org/eclipse/cargotracker/application/BookingService.java`
- `src/main/java/org/eclipse/cargotracker/application/internal/DefaultBookingService.java`
- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`

**Required API**

```java
void changeDeadline(TrackingId trackingId, Date deadline);
```

**Required implementation behavior**

1. Load the cargo using `cargoRepository.find(trackingId)`.
2. Obtain the current destination from
   `cargo.getRouteSpecification().getDestination()`.
3. Construct a replacement `RouteSpecification` from:
   - `cargo.getOrigin()`;
   - the current destination;
   - the new deadline.
4. Apply it using `cargo.specifyNewRoute(routeSpecification)`.
5. Persist using `cargoRepository.store(cargo)`.
6. Log the tracking ID and new deadline at `Level.INFO`, following the style of
   `changeDestination(...)`.

Do not:

- add a setter to `Cargo` or `RouteSpecification`;
- modify the origin or destination;
- clear or replace the itinerary directly;
- update persistence entities behind the aggregate's back.

**Tests to write first**

Append a sequential `testChangeDeadline()` case to `BookingServiceTest` after
`testChangeDestination()`. Build a new deadline one month after the test's
original `deadline`, invoke the service, reload the cargo with
`Cargo.findByTrackingId`, and assert:

- origin remains Chicago;
- destination remains Helsinki;
- stored deadline is the same calendar day as the requested new deadline;
- assigned itinerary remains unchanged;
- transport status remains `NOT_RECEIVED`;
- last known location remains `Location.UNKNOWN`;
- current voyage remains `Voyage.NONE`;
- cargo is not marked misdirected;
- estimated time of arrival is `Delivery.ETA_UNKOWN`;
- next expected activity is `Delivery.NO_ACTIVITY`;
- cargo is not unloaded at destination;
- routing status reflects the domain model's recalculation and remains
  `MISROUTED` for the established test sequence.

**Gating criteria**

- The test source compiles.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.
- No web, facade, REST, Liberty, or persistence configuration files change in
  this issue.

### 4.2 — Issue 2: Expose deadline changes through the booking facade

**What to build**

Expose the use case to presentation clients without leaking domain identifier
types into the web layer.

**Files to modify**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/BookingServiceFacade.java`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacade.java`

**Optional focused test file**

- `src/test/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacadeTest.java`

**Required API**

```java
void changeDeadline(String trackingId, Date arrivalDeadline);
```

**Required implementation**

```java
bookingService.changeDeadline(
        new TrackingId(trackingId),
        arrivalDeadline);
```

The facade must not:

- load and mutate `Cargo` itself;
- call `CargoRepository.store(...)`;
- parse a formatted date;
- introduce JSF or PrimeFaces types.

**Tests**

Where a container-free test is added, use a hand-written `BookingService` fake
or spy and prove that:

- the same `Date` object/value reaches the application service;
- the tracking-ID string is converted to an equivalent `TrackingId`;
- the facade delegates exactly once;
- no repository work is duplicated in the facade.

Do not add Mockito or another dependency solely for this test.

**Gating criteria**

- Existing facade consumers still compile.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.
- The application-layer test added in Issue 1 remains unchanged and compiling.

### 4.3 — Issue 3: Implement the deadline editor backing model

**What to build**

Add the view-scoped backing bean that loads a cargo's current deadline and
submits a replacement deadline through the booking facade. Do not add the
dialog launcher or XHTML in this issue.

**File to create**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDate.java`

**Required bean shape**

```java
@Named
@ViewScoped
public class ChangeArrivalDeadlineDate implements Serializable {
    private static final long serialVersionUID = 1L;

    private String trackingId;
    private CargoRoute cargo;
    private Date arrivalDeadlineDate;

    @Inject
    private BookingServiceFacade bookingServiceFacade;
}
```

Required properties and methods:

- `getTrackingId()` / `setTrackingId(String)`
- `getCargo()`
- `getArrivalDeadlineDate()` / `setArrivalDeadlineDate(Date)`
- `load()`
- `changeArrivalDeadline()`

**Load behavior**

1. Call `bookingServiceFacade.loadCargoForRouting(trackingId)`.
2. Store the returned `CargoRoute`.
3. Parse `cargo.getArrivalDeadlineDate()` using `MM/dd/yyyy`.
4. Store the resulting `Date` in `arrivalDeadlineDate`.
5. Do not query a repository or domain object directly.
6. Do not ignore a parsing failure or merely print its stack trace. Surface a
   clear application/view error consistent with existing JSF behavior.

**Submit behavior**

1. Refuse a null date through JSF validation or explicit bean validation.
2. Call
   `bookingServiceFacade.changeDeadline(trackingId, arrivalDeadlineDate)`.
3. Close the dynamic dialog with:

   ```java
   PrimeFaces.current().dialog().closeDynamic("DONE");
   ```

4. Do not close the dialog if the facade call fails.

**Tests to write**

Add a container-free JUnit test if practical, using a hand-written fake facade,
that proves:

- `load()` requests the correct tracking ID;
- `load()` converts an `MM/dd/yyyy` DTO date into the editable `Date`;
- `changeArrivalDeadline()` delegates the selected date and tracking ID;
- a malformed DTO deadline is surfaced rather than converted to null;
- a null selected date is rejected.

Do not add a mocking framework solely for these tests.

**Gating criteria**

- The bean is serializable and uses the established CDI/JSF annotations.
- The bean references only facade DTOs, not domain model classes.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.

### 4.4 — Issue 4: Implement the PrimeFaces deadline dialog

**What to build**

Add the session-scoped dialog launcher and the dynamic dialog view. The dialog
must work when addressed directly with a `trackingId` query parameter, but it
is not yet linked from the dashboard in this issue.

**Files to create**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDateDialog.java`
- `src/main/webapp/admin/dialogs/changeArrivalDeadlineDate.xhtml`

**Launcher requirements**

Use:

```java
@ManagedBean(name = "changeArrivalDeadlineDateDialog")
@SessionScoped
```

Implement:

- `showDialog(String trackingId)`
- `handleReturn(SelectEvent event)`
- `cancel()`

`showDialog(...)` must:

- set the options documented in Question 3.7;
- pass `trackingId` as a dynamic-dialog request parameter;
- open `/admin/dialogs/changeArrivalDeadlineDate.xhtml`.

`cancel()` must close the dialog without invoking the facade.

**XHTML requirements**

The page title must be:

```xhtml
<title>Change Deadline</title>
```

Place metadata directly beneath the root `<html>` element and before
`<h:head>`:

```xhtml
<f:metadata>
    <f:viewParam name="trackingId"
                 value="#{changeArrivalDeadlineDate.trackingId}"/>
    <f:viewAction action="#{changeArrivalDeadlineDate.load}"/>
</f:metadata>
```

The form must display:

- `Origin:` and `changeArrivalDeadlineDate.cargo.originName`;
- `Destination:` and
  `changeArrivalDeadlineDate.cargo.finalDestinationName`;
- `Deadline:` and a `p:datePicker` bound to
  `changeArrivalDeadlineDate.arrivalDeadlineDate`;
- **Cancel**, invoking
  `changeArrivalDeadlineDateDialog.cancel()`;
- **Update**, invoking
  `changeArrivalDeadlineDate.changeArrivalDeadline()`.

The date picker must require a value. The Update action must reload or refresh
the calling Administration view after a successful dialog close, following the
existing destination-dialog behavior.

**Runtime tests**

With the application running, request:

```text
http://localhost:8080/cargo-tracker/admin/dialogs/changeArrivalDeadlineDate.xhtml?trackingId=DEF789
```

Verify:

- HTTP 200;
- title is **Change Deadline**;
- origin and destination render;
- the existing deadline is selected;
- no `TagException`, `Parent UIComponent`, `FacesException`, or server error is
  present;
- Cancel does not change the persisted deadline;
- Update changes the deadline.

**Gating criteria**

- `./mvnw clean package -Popenliberty liberty:run` succeeds on JDK 17.
- Direct dialog loading and both actions work.
- Destination editing continues to work.
- Stop Liberty cleanly before completing the issue.

### 4.5 — Issue 5: Integrate deadline editing into the Administration dashboard

**What to build**

Replace the plain deadline text in the Not Routed Cargo table with the
PrimeFaces command-link affordance that opens the completed dialog and refreshes
the table after return.

**File to modify**

- `src/main/webapp/admin/tables/listNotRouted.xhtml`

**Required UI shape**

Within the existing Deadline column, add a `p:commandLink` that:

- calls
  `changeArrivalDeadlineDateDialog.showDialog(cargoNotRouted.trackingId)`;
- retains the displayed
  `cargoNotRouted.arrivalDeadlineDate`;
- adds the existing Font Awesome edit icon style;
- uses a stable component ID such as `arrivalDeadlineToUpdate`;
- listens for `dialogReturn`;
- invokes
  `changeArrivalDeadlineDateDialog.handleReturn`;
- updates `tableNotRouted`;
- provides the tooltip:
  `Click to change cargo arrival deadline date.`

Follow the adjacent Destination column's established structure and styling. Do
not alter tracking-ID routing or destination editing.

**End-to-end acceptance test**

1. Start from a clean build on JDK 17:

   ```bash
   ./mvnw clean package -Popenliberty liberty:run
   ```

2. Confirm the home page returns HTTP 200.
3. Open Administration and locate `DEF789`.
4. Record the original deadline.
5. Confirm the deadline now has an edit icon and tooltip.
6. Open the deadline dialog.
7. Confirm origin and destination identify the same cargo.
8. Choose a visibly different date.
9. Press **Update**.
10. Confirm the dialog closes and the Not Routed Cargo table refreshes.
11. Confirm the table shows the selected date.
12. Reload the browser and confirm the selected date remains.
13. Reopen the dialog and confirm the editor initializes to the changed date.
14. Press **Cancel** and confirm no additional change occurs.
15. Verify the Destination edit dialog still opens.
16. Verify selecting `DEF789` for routing still loads without an error page.

**Log acceptance**

The final run must contain none of:

- `<f:metadata> Parent UIComponent`;
- `TagException`;
- `VerifyError`;
- `FacesException`;
- `CWWKZ0002E` or `CWWKZ0003E`;
- recurring batch authorization failures;
- new FFDC files attributable to this feature.

Transient JMS activation-order warnings are acceptable only if all message
endpoints subsequently activate, as established by the prepared baseline.

**Final regression and scope checks**

- `./mvnw clean package -Popenliberty` succeeds.
- The existing test sources and the new deadline test compile.
- No Java EE namespace migration occurred.
- No Open Liberty, Derby, Jackson, JSF metadata, batch authorization, or REST
  compatibility fix from the starting commit was reverted.
- The feature affects only the intended application, facade, web, dialog,
  table, and test surfaces.
- Stop Liberty cleanly.

---

## Phase 5 — Documentation and implementation handoff

- Update `README.md` only if user-facing Administration capabilities are
  enumerated there; add one concise sentence that administrators can change an
  unrouted cargo's arrival deadline.
- Record the exact JDK 17 run command in the final issue or pull-request
  description:

  ```bash
  ./mvnw clean package -Popenliberty liberty:run
  ```

- Include `DEF789` and the before/after deadline values in the acceptance
  evidence.
- State explicitly that data is in-memory and resets when the application is
  rebuilt/restarted.

---

## Cross-cutting concerns

| Concern | Required handling |
|---------|--------------------|
| Domain-driven design | Mutate the aggregate through `Cargo.specifyNewRoute(...)`; do not bypass it with persistence-level field updates. |
| Layering | Web bean → booking facade → booking service → cargo repository. |
| Date handling | Use `java.util.Date` at service/facade boundaries and `MM/dd/yyyy` for the date-only editor representation. |
| Time zones | Acceptance compares the calendar date displayed by the application; do not introduce a new timezone policy in this feature. |
| Error handling | Do not silently swallow parse, lookup, validation, or persistence failures. A failed update must not look successful. |
| JSF compatibility | Keep `<f:metadata>` at view-root scope for MyFaces. |
| Bean lifecycle | Editor is CDI `@ViewScoped`; dynamic-dialog launcher mirrors the existing session-scoped JSF managed bean. |
| Accessibility | Preserve visible labels; the date editor must have an associated label and validation feedback. |
| Backward compatibility | Existing destination editing, routing, tracking, REST, messaging, batch, and startup behavior must remain intact. |
| Test discipline | Add tests before production code where practical; every issue must preserve all prior gates. |
| Experiment integrity | Implement from this specification starting at `9b9f311b2a3a2854bdac947593950d9edb6bca7d`; do not cherry-pick or inspect feature-bearing commits. |
````

</details>


---

<sub>25s</sub>

### `bash`

**List campaign resources**

$ git ls-tree -r --name-only experiment/shepherd-control -- '1-arrival-deadline-control-remove-before-merge' | sed -n '1,240p'

```
1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md
1-arrival-deadline-control-remove-before-merge/campaign-lessons.md
1-arrival-deadline-control-remove-before-merge/shepherd-campaign.json
1-arrival-deadline-control-remove-before-merge/shepherd-test-experiment.json
<shellId: 4 completed with exit code 0>
```


---

<sub>25s</sub>

### `bash`

**Index plan headings and resolutions**

$ git show 'experiment/shepherd-control:1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md' | awk '/^#{1,6} / || /Resolution:/{print NR ":" $0}'

<details>
<summary>36 lines</summary>

```
1:# Implementation plan: Change Arrival Deadline Date (`eclipse-ee4j/cargotracker#64`)
22:## Goal
35:### User-visible acceptance behavior
62:### Domain acceptance behavior
77:### Hard scope constraints
95:## Completed phases
97:### Phase 1 ✅ — Establish a runnable feature-absent baseline
109:### Phase 2 ✅ — Verify the before and after user experience
123:## Phase 3 — Ignorance reduction: questions to answer before writing code
129:### 3.1 — Which cargos expose the edit operation?
155:**Resolution:**
162:### 3.2 — What is the exact domain mutation?
201:**Resolution:**
211:### 3.3 — What should happen to an existing itinerary and delivery state?
237:**Resolution:**
245:### 3.4 — What type crosses the facade boundary?
273:**Resolution:**
281:### 3.5 — How is the DTO's formatted deadline converted for editing?
311:**Resolution:**
321:### 3.6 — Which JSF bean scopes and interaction pattern should be used?
351:**Resolution:**
360:### 3.7 — What is the dynamic-dialog contract?
401:**Resolution:**
412:### 3.8 — What date validation is required?
430:**Resolution:**
438:### 3.9 — How will the feature be tested on the prepared historical baseline?
473:**Resolution:**
488:## Phase 4 — Implementation (five serial issues)
493:### 4.1 — Issue 1: Add the application-layer deadline change operation
561:### 4.2 — Issue 2: Expose deadline changes through the booking facade
616:### 4.3 — Issue 3: Implement the deadline editor backing model
695:### 4.4 — Issue 4: Implement the PrimeFaces deadline dialog
792:### 4.5 — Issue 5: Integrate deadline editing into the Administration dashboard
876:## Phase 5 — Documentation and implementation handoff
895:## Cross-cutting concerns
<shellId: 2 completed with exit code 0>
```

</details>


---

<sub>25s</sub>

### `bash`

**Inspect worktree and remotes**

$ git status --short --branch && git remote -v

<details>
<summary>9 lines</summary>

```
## experiment/shepherd-control...origin/experiment/shepherd-control
?? 1-arrival-deadline-control-remove-before-merge/.stage20-after.59563
?? 1-arrival-deadline-control-remove-before-merge/.stage20-before.59563
?? 1-arrival-deadline-control-remove-before-merge/prompts/
origin	git@github.com:edburns/dd-3061974-02-cargotracker.git (fetch)
origin	git@github.com:edburns/dd-3061974-02-cargotracker.git (push)
upstream	git@github.com:azure-javaee/cargotracker.git (fetch)
upstream	git@github.com:azure-javaee/cargotracker.git (push)
<shellId: 3 completed with exit code 0>
```

</details>


---

<sub>30s</sub>

### Copilot

All nine gating questions have substantive resolution blocks; none remain unresolved. The parsed decisions are: Not Routed UI only; aggregate replacement via `specifyNewRoute`; itinerary retained with `MISROUTED` recalculation; `String`/`Date` facade boundary; per-load `MM/dd/yyyy` parsing; view-scoped editor plus session-scoped launcher; fixed dynamic-dialog contract and root metadata; non-null-only date validation; and JDK 17/Open Liberty plus browser acceptance while Arquillian remains skipped by default. I’m persisting the five complete issue specifications before validation and creation.

---

<sub>1m 26s</sub>

### `apply_patch`

<details>
<summary>Arguments</summary>

````json
"*** Begin Patch\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/01-4.1-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, including `### Domain acceptance behavior` and `### Hard scope constraints`\n+- `### 3.2 — What is the exact domain mutation?`\n+- `### 3.3 — What should happen to an existing itinerary and delivery state?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.1 — Issue 1: Add the application-layer deadline change operation`\n+- `## Cross-cutting concerns`\n+\n+The binding resolutions are:\n+\n+- Add `BookingService.changeDeadline(TrackingId, Date)`. Load the cargo, construct a replacement `RouteSpecification` from its existing origin, existing destination, and supplied deadline, call `cargo.specifyNewRoute(...)`, and store it with `cargoRepository.store(...)`. Do not add a mutable deadline setter.\n+- Retain the existing itinerary. Do not clear, replace, or reroute it. Let `Cargo.specifyNewRoute(...)` recalculate delivery and routing state; in the established sequential test the cargo remains `MISROUTED`.\n+- Require a concrete deadline but add no new chronological rule: it need not be after today, the previous deadline, or all itinerary legs.\n+- Extend the sequential Arquillian test after `testChangeDestination()`. The prepared Open Liberty build compiles this test but retains historical `skipTests=true`; running Arquillian still requires its documented remote Payara environment.\n+\n+Research established that JDK 17 with the existing Open Liberty profile is the mandatory executable build baseline. Preserve Java EE 7, `javax.*`, Java 7 source/target compatibility, Derby, and the existing runtime. Implement from the plan rather than copying code or commits from feature-bearing branches.\n+\n+## Branch and execution order\n+\n+Base all work on `experiment/shepherd-control` from remote `origin`. This is implementation subsection `4.1`, the first of five serial issues. Tasks are assigned, completed, and merged in listed order. Do not start work until this issue is assigned; Issue 2 must not begin until this issue is complete, gated, and merged.\n+\n+## Implement\n+\n+Modify only:\n+\n+- `src/main/java/org/eclipse/cargotracker/application/BookingService.java`\n+- `src/main/java/org/eclipse/cargotracker/application/internal/DefaultBookingService.java`\n+- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`\n+\n+Add this API:\n+\n+```java\n+void changeDeadline(TrackingId trackingId, Date deadline);\n+```\n+\n+Implement it by:\n+\n+1. Loading with `cargoRepository.find(trackingId)`.\n+2. Reading the current destination from `cargo.getRouteSpecification().getDestination()`.\n+3. Creating a `RouteSpecification` with `cargo.getOrigin()`, that current destination, and the new deadline.\n+4. Applying it with `cargo.specifyNewRoute(routeSpecification)`.\n+5. Persisting with `cargoRepository.store(cargo)`.\n+6. Logging the tracking ID and new deadline at `Level.INFO` in the style of `changeDestination(...)`.\n+\n+Write the test first. Append sequential `testChangeDeadline()` after `testChangeDestination()`. Create a deadline one month after the test's original `deadline`, invoke the new operation, reload with `Cargo.findByTrackingId`, and assert:\n+\n+- origin is still Chicago and destination is still Helsinki;\n+- the stored deadline is the same calendar day as requested;\n+- the assigned itinerary is unchanged;\n+- transport status is `NOT_RECEIVED`;\n+- last known location is `Location.UNKNOWN`;\n+- current voyage is `Voyage.NONE`;\n+- the cargo is not misdirected;\n+- ETA is `Delivery.ETA_UNKOWN`;\n+- next expected activity is `Delivery.NO_ACTIVITY`;\n+- the cargo is not unloaded at destination;\n+- routing status remains `MISROUTED`.\n+\n+## Completion gates\n+\n+- The new test source compiles in the historical suite and preserves its sequential placement.\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17.\n+- Review the diff and confirm no web, facade, REST, Liberty, Derby, or persistence-configuration file changed.\n+- Confirm the implementation uses the aggregate operation and repository rather than direct persistent-field mutation.\n+- Confirm origin, destination, and itinerary preservation are discriminated by assertions, so an implementation that recreates or clears them fails.\n+\n+## Out of scope\n+\n+Do not add JSF, PrimeFaces, facade, dialog, table, REST, runtime, or persistence-configuration changes. Do not add setters to `Cargo` or `RouteSpecification`, clear or replace the itinerary, reroute the cargo, enforce a new date-order policy, modernize Arquillian/Payara, add a mocking dependency, migrate namespaces, or copy feature-bearing code.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/02-4.2-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, including `### Domain acceptance behavior` and `### Hard scope constraints`\n+- `### 3.2 — What is the exact domain mutation?`\n+- `### 3.4 — What type crosses the facade boundary?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.2 — Issue 2: Expose deadline changes through the booking facade`\n+- `## Cross-cutting concerns`\n+\n+The binding resolutions are:\n+\n+- The application service already owns the aggregate mutation from Issue 1: replacement `RouteSpecification`, `Cargo.specifyNewRoute(...)`, then repository storage.\n+- Add `void changeDeadline(String trackingId, Date arrivalDeadline)` to `BookingServiceFacade`. `DefaultBookingServiceFacade` converts only the identifier with `new TrackingId(trackingId)` and passes the same `Date` to the application service.\n+- Do not introduce a command DTO, formatted-string deadline parameter, domain type in the web-facing API, or facade-owned repository work.\n+- A deadline must be non-null at the presentation boundary, but this layer must not invent a future-date, old-deadline, or itinerary chronology rule.\n+\n+Research established that the prepared JDK 17/Open Liberty build compiles test sources while retaining historical `skipTests=true`. A focused container-free facade test is useful only if it can use hand-written test doubles without adding dependencies.\n+\n+## Branch and execution order\n+\n+Base all work on `experiment/shepherd-control` from remote `origin`, after Issue 1 has been merged. This is implementation subsection `4.2`, the second of five serial issues. Tasks are assigned, completed, and merged in listed order. Do not start until assigned and until Issue 1's gates have passed; Issue 3 must wait for this issue to be complete, gated, and merged.\n+\n+## Implement\n+\n+Modify:\n+\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/BookingServiceFacade.java`\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacade.java`\n+\n+Optionally add, if practical without container infrastructure:\n+\n+- `src/test/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacadeTest.java`\n+\n+Add:\n+\n+```java\n+void changeDeadline(String trackingId, Date arrivalDeadline);\n+```\n+\n+Delegate exactly as follows in behavior:\n+\n+```java\n+bookingService.changeDeadline(\n+        new TrackingId(trackingId),\n+        arrivalDeadline);\n+```\n+\n+The facade must remain a thin boundary. It must not load or mutate `Cargo`, store through `CargoRepository`, parse dates, or depend on JSF/PrimeFaces.\n+\n+If a focused test is practical, use a hand-written `BookingService` fake or spy and prove that the facade converts the string to an equivalent `TrackingId`, forwards the same `Date` object/value, and delegates exactly once without repository behavior.\n+\n+## Completion gates\n+\n+- Existing facade consumers and all test sources compile.\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17.\n+- The Issue 1 application-layer test remains unchanged and compiling.\n+- A focused test, if added, fails for duplicate delegation, altered dates, or a wrong tracking ID.\n+- Diff inspection confirms the facade introduces no domain mutation, formatted date parsing, repository access, UI dependency, or new test dependency.\n+\n+## Out of scope\n+\n+Do not add the backing bean, dialog launcher, XHTML, dashboard link, domain setters, repository work, formatted string parsing, a DTO, Mockito or another dependency, new date-policy validation, runtime modernization, namespace migration, or unrelated application-service changes.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/03-4.3-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, including `### User-visible acceptance behavior` and `### Hard scope constraints`\n+- `### 3.4 — What type crosses the facade boundary?`\n+- `### 3.5 — How is the DTO's formatted deadline converted for editing?`\n+- `### 3.6 — Which JSF bean scopes and interaction pattern should be used?`\n+- `### 3.7 — What is the dynamic-dialog contract?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.3 — Issue 3: Implement the deadline editor backing model`\n+- `## Cross-cutting concerns`\n+\n+The binding resolutions are:\n+\n+- The web layer uses `BookingServiceFacade` with `String` tracking IDs and `java.util.Date`; it does not access `TrackingId`, `Cargo`, `RouteSpecification`, or repositories.\n+- Load `CargoRoute` through `loadCargoForRouting(trackingId)`. Parse its date-only `getArrivalDeadlineDate()` value with a per-load `new SimpleDateFormat(\"MM/dd/yyyy\")`; do not add a shared mutable formatter or expand the DTO.\n+- Implement the editor as serializable CDI `@Named @ViewScoped`; the separate launcher in the next issue will be a session-scoped managed bean.\n+- Successful submission calls the facade and closes dynamically with `\"DONE\"`. Do not close after a failed facade call.\n+- Reject null selection but add no chronological business rule.\n+\n+Research established that the DTO's editable display contract is `MM/dd/yyyy`, that parsing must remain localized to the view bean, and that container-free tests should use hand-written fakes rather than a new mocking framework.\n+\n+## Branch and execution order\n+\n+Base all work on `experiment/shepherd-control` from remote `origin`, after Issues 1 and 2 have been merged. This is implementation subsection `4.3`, the third of five serial issues. Tasks are assigned, completed, and merged in listed order. Do not start until assigned and prior gates pass; Issue 4 must wait until this issue is complete, gated, and merged.\n+\n+## Implement\n+\n+Create:\n+\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDate.java`\n+\n+Use this shape:\n+\n+```java\n+@Named\n+@ViewScoped\n+public class ChangeArrivalDeadlineDate implements Serializable {\n+    private static final long serialVersionUID = 1L;\n+\n+    private String trackingId;\n+    private CargoRoute cargo;\n+    private Date arrivalDeadlineDate;\n+\n+    @Inject\n+    private BookingServiceFacade bookingServiceFacade;\n+}\n+```\n+\n+Provide `getTrackingId()`, `setTrackingId(String)`, `getCargo()`, `getArrivalDeadlineDate()`, `setArrivalDeadlineDate(Date)`, `load()`, and `changeArrivalDeadline()`.\n+\n+`load()` must request the cargo with `bookingServiceFacade.loadCargoForRouting(trackingId)`, store the returned `CargoRoute`, parse `cargo.getArrivalDeadlineDate()` with a per-load `SimpleDateFormat(\"MM/dd/yyyy\")`, and store the parsed `Date`. Surface malformed data as a clear application/view error consistent with existing JSF handling; do not swallow it, print-only, or turn it into null.\n+\n+`changeArrivalDeadline()` must reject a null selected date, call `bookingServiceFacade.changeDeadline(trackingId, arrivalDeadlineDate)`, and only after success call:\n+\n+```java\n+PrimeFaces.current().dialog().closeDynamic(\"DONE\");\n+```\n+\n+Add a container-free JUnit test if practical, using a hand-written facade fake. Cover the exact tracking ID load, correct `MM/dd/yyyy` conversion, submit delegation with the selected date and tracking ID, visible malformed-date failure, and null rejection.\n+\n+## Completion gates\n+\n+- The bean is serializable and uses the established CDI `@Named` plus JSF `@ViewScoped` annotations.\n+- It references facade interfaces/DTOs only, with no domain or repository imports.\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17.\n+- Tests or focused inspection discriminate malformed input from null and prove a failed facade call cannot produce success-shaped dialog closure.\n+- Parsing uses a fresh formatter and the exact date-only DTO property and pattern, preventing shared formatter races or accidental time parsing.\n+- All Issue 1 and Issue 2 gates remain intact.\n+\n+## Out of scope\n+\n+Do not create the dialog launcher or XHTML, edit dashboard tables, expand `CargoRoute`, access domain/repository types, add a shared formatter, silently recover from malformed dates, close on failure, add chronology restrictions, add a mocking dependency, modernize the runtime, or migrate Java EE namespaces.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/04-4.4-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, including `### User-visible acceptance behavior` and `### Hard scope constraints`\n+- `### Phase 1 ✅ — Establish a runnable feature-absent baseline`\n+- `### 3.5 — How is the DTO's formatted deadline converted for editing?`\n+- `### 3.6 — Which JSF bean scopes and interaction pattern should be used?`\n+- `### 3.7 — What is the dynamic-dialog contract?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.4 — Issue 4: Implement the PrimeFaces deadline dialog`\n+- `## Cross-cutting concerns`\n+\n+The binding resolutions are:\n+\n+- Mirror Change Destination: use the completed CDI `@Named @ViewScoped` editor and add a serializable `@ManagedBean(name = \"changeArrivalDeadlineDateDialog\") @SessionScoped` launcher.\n+- Open `/admin/dialogs/changeArrivalDeadlineDate.xhtml` with one `trackingId` request parameter. Options are modal `true`, draggable `true`, resizable `false`, content width `410`, and content height `280`.\n+- Success closes with `\"DONE\"`; cancellation closes with `\"\"`. The caller handles `dialogReturn` and updates `tableNotRouted`.\n+- Place `<f:metadata>` directly under root `<html>`, before `<h:head>` and `<h:body>`, to satisfy the prepared MyFaces `UIViewRoot` requirement.\n+- Require a non-null date without adding minimum/future/itinerary date restrictions.\n+\n+Research established that root-level metadata is required by this Open Liberty/MyFaces baseline, and the neighboring destination editor proves the PrimeFaces dynamic-dialog lifecycle. Reimplement the production behavior directly; do not copy research code.\n+\n+## Branch and execution order\n+\n+Base all work on `experiment/shepherd-control` from remote `origin`, after Issues 1 through 3 have been merged. This is implementation subsection `4.4`, the fourth of five serial issues. Tasks are assigned, completed, and merged in listed order. Do not start until assigned and prior gates pass; Issue 5 must wait until this issue is complete, runtime-gated, and merged.\n+\n+## Implement\n+\n+Create:\n+\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDateDialog.java`\n+- `src/main/webapp/admin/dialogs/changeArrivalDeadlineDate.xhtml`\n+\n+The serializable launcher must use:\n+\n+```java\n+@ManagedBean(name = \"changeArrivalDeadlineDateDialog\")\n+@SessionScoped\n+```\n+\n+Implement `showDialog(String trackingId)`, `handleReturn(SelectEvent event)`, and `cancel()`. `showDialog` must provide `trackingId` as a `Map<String, List<String>>` request parameter, set all fixed options, and open the exact dialog path. `cancel()` closes with an empty result and must not call the facade.\n+\n+The XHTML title is `Change Deadline`. Put this metadata directly below root `<html>` and before `<h:head>`:\n+\n+```xhtml\n+<f:metadata>\n+    <f:viewParam name=\"trackingId\"\n+                 value=\"#{changeArrivalDeadlineDate.trackingId}\"/>\n+    <f:viewAction action=\"#{changeArrivalDeadlineDate.load}\"/>\n+</f:metadata>\n+```\n+\n+Display labeled read-only origin and destination values from `changeArrivalDeadlineDate.cargo.originName` and `.finalDestinationName`. Bind a required, labeled `p:datePicker` to `changeArrivalDeadlineDate.arrivalDeadlineDate`, with validation feedback. Add Cancel calling `changeArrivalDeadlineDateDialog.cancel()` and Update calling `changeArrivalDeadlineDate.changeArrivalDeadline()`. Preserve the existing destination-dialog return/refresh pattern.\n+\n+Run the application with:\n+\n+```bash\n+./mvnw clean package -Popenliberty liberty:run\n+```\n+\n+Directly request `http://localhost:8080/cargo-tracker/admin/dialogs/changeArrivalDeadlineDate.xhtml?trackingId=DEF789`. Verify HTTP 200, title, origin, destination, selected current deadline, successful update, and cancellation without mutation.\n+\n+## Completion gates\n+\n+- The package/start command succeeds on JDK 17 and the direct dialog returns HTTP 200.\n+- Server output contains no `TagException`, `Parent UIComponent`, `FacesException`, or feature-attributable server error.\n+- Required validation prevents null submission with visible feedback.\n+- Update changes the deadline and closes only after success; Cancel leaves it unchanged.\n+- Destination editing still works.\n+- Metadata is physically at root scope before head/body, and all fixed dialog parameters/options are verified.\n+- Stop Liberty cleanly before completion.\n+\n+## Out of scope\n+\n+Do not integrate the dashboard deadline link yet, alter routing or destination editing, move metadata into the body, add navigation/full-page or inline editing, add chronological validation, change DTO/domain/repository contracts, modernize JSF/PrimeFaces/Java EE, change Liberty/Derby configuration, or add unrelated runtime fixes.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/05-4.5-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then carefully re-read these exact sections:\n+\n+- `## Goal`, including `### User-visible acceptance behavior`, `### Domain acceptance behavior`, and `### Hard scope constraints`\n+- `### Phase 2 ✅ — Verify the before and after user experience`\n+- `### 3.1 — Which cargos expose the edit operation?`\n+- `### 3.6 — Which JSF bean scopes and interaction pattern should be used?`\n+- `### 3.7 — What is the dynamic-dialog contract?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.5 — Issue 5: Integrate deadline editing into the Administration dashboard`\n+- `## Phase 5 — Documentation and implementation handoff`\n+- `## Cross-cutting concerns`\n+\n+The binding resolutions are:\n+\n+- Expose deadline editing only in `src/main/webapp/admin/tables/listNotRouted.xhtml`. Service/facade operations remain generally callable and do not encode table membership.\n+- Mirror the existing Change Destination dynamic-dialog interaction rather than adding navigation or inline editing.\n+- Success closes with `\"DONE\"`; cancellation closes with `\"\"`; the caller listens for `dialogReturn` and updates `tableNotRouted`.\n+- Require a non-null deadline but no future-date, old-deadline, or itinerary chronology policy.\n+- Mandatory final evidence is the JDK 17 Open Liberty package/start command, direct HTTP checks, and complete `DEF789` browser flow. Arquillian modernization is not part of this feature.\n+\n+Research established that the adjacent Destination column is the compatible PrimeFaces structure and styling, that the prepared baseline's compatibility fixes must remain, and that in-memory data persists only for the running application and resets on rebuild/restart.\n+\n+## Branch and execution order\n+\n+Base all work on `experiment/shepherd-control` from remote `origin`, after Issues 1 through 4 have been merged. This is implementation subsection `4.5`, the fifth and final serial issue. Tasks are assigned, completed, and merged in listed order. Do not start until assigned and all prior gates pass.\n+\n+## Implement\n+\n+Modify:\n+\n+- `src/main/webapp/admin/tables/listNotRouted.xhtml`\n+\n+In the existing Deadline column, replace plain deadline text with a `p:commandLink` that:\n+\n+- calls `changeArrivalDeadlineDateDialog.showDialog(cargoNotRouted.trackingId)`;\n+- still displays `cargoNotRouted.arrivalDeadlineDate`;\n+- uses the existing Font Awesome edit-icon style;\n+- has a stable ID such as `arrivalDeadlineToUpdate`;\n+- listens for `dialogReturn`;\n+- invokes `changeArrivalDeadlineDateDialog.handleReturn`;\n+- updates `tableNotRouted`;\n+- exposes the exact tooltip `Click to change cargo arrival deadline date.`\n+\n+Follow the adjacent Destination column's production structure and styling. Preserve tracking-ID routing and destination editing.\n+\n+Perform the complete `DEF789` browser acceptance flow from a clean:\n+\n+```bash\n+./mvnw clean package -Popenliberty liberty:run\n+```\n+\n+Confirm home HTTP 200; record the original deadline; verify the edit icon and tooltip; open the dialog; verify cargo origin/destination and current date; choose and record a visibly different date; Update; verify close, table refresh, and displayed date; reload and verify persistence; reopen and verify initialization to the changed date; Cancel and verify no further change; verify Destination editing still opens; and verify routing `DEF789` does not produce an error page.\n+\n+If `README.md` enumerates user-facing Administration capabilities, add one concise sentence about changing an unrouted cargo's arrival deadline. Otherwise leave it unchanged. Record the exact JDK 17 run command, `DEF789`, before/after dates, and the in-memory reset limitation in final acceptance evidence.\n+\n+## Completion gates\n+\n+- The final package succeeds and all existing/new test sources compile.\n+- The full Open Liberty browser flow passes and Liberty is stopped cleanly.\n+- Runtime logs contain none of `<f:metadata> Parent UIComponent`, `TagException`, `VerifyError`, `FacesException`, `CWWKZ0002E`, `CWWKZ0003E`, recurring batch authorization failures, or new feature-attributable FFDC files. Transient JMS activation-order warnings are acceptable only if all endpoints subsequently activate.\n+- Existing destination editing and `DEF789` routing still work.\n+- Reload persistence, changed-date reinitialization, and Cancel non-mutation are each demonstrated, preventing a table-only or dialog-only false positive.\n+- Diff review confirms no Java EE namespace migration and no regression to Liberty, Derby, Jackson, JSF metadata, batch authorization, REST compatibility, messaging, tracking, or routing behavior.\n+\n+## Out of scope\n+\n+Do not expose editing in other cargo tables or pages, alter destination/routing links, redesign the dialog, add new date rules, change application/facade/domain contracts, migrate frameworks/namespaces, replace Derby or Liberty, modernize Arquillian, fix unrelated warnings, or broaden README documentation beyond one sentence when applicable.\n*** End Patch\n"
````

</details>

```
Added 5 file(s): /Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/01-4.1-body.md, /Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/02-4.2-body.md, /Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/03-4.3-body.md, /Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/04-4.4-body.md, /Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/05-4.5-body.md
```


---

<sub>1m 38s</sub>

### Copilot

The five multiline drafts are persisted. I’m running the mandatory draft validator next; only after it passes will I initialize the ledger/status artifacts and perform the one-shot create, exact-body verify, and parent-link sequence.

---

<sub>1m 42s</sub>

### `bash`

**Validate persisted issue drafts**

$ '/Users/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh' '/Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies' 5 off && for f in /Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/*-body.md; do printf '%s: %s lines\n' "$(basename "$f")" "$(wc -l < "$f" | tr -d ' ')"; done

<details>
<summary>6 lines</summary>

```
01-4.1-body.md: 75 lines
02-4.2-body.md: 67 lines
03-4.3-body.md: 77 lines
04-4.4-body.md: 79 lines
05-4.5-body.md: 72 lines
<shellId: 5 completed with exit code 0>
```

</details>


---

<sub>1m 42s</sub>

### `rg`

**campaign-lessons|Candidate lessons|Validated lessons|spike[^\n]*\.(java|py|js|ts)|read[^\n]*spike**

"campaign-lessons|Candidate lessons|Validated lessons|spike[^\n]*\.(java|py|js|ts)|read[^\n]*spike" in *-body.md (1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies)

```
/Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/01-4.1-body.md:3:On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.
/Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/02-4.2-body.md:3:On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.
/Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/03-4.3-body.md:3:On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.
/Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/05-4.5-body.md:3:On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.
/Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/04-4.4-body.md:3:On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.
```


---

<sub>1m 42s</sub>

### `rg`

**^## (Campaign context and required reading|Branch and execution order|Implement|Completion gates|Out of scope)$**

"^## (Campaign context and required reading|Branch and execution order|Implement|Completion gates|Out of scope)$" in *-body.md (1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies)

```
/Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/01-4.1-body.md:5
/Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/02-4.2-body.md:5
/Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/03-4.3-body.md:5
/Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/05-4.5-body.md:5
/Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/issue-bodies/04-4.4-body.md:5
```


---

<sub>2m 15s</sub>

### `apply_patch`

<details>
<summary>Arguments</summary>

```json
"*** Begin Patch\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/run-stage-20.sh\n+#!/usr/bin/env bash\n+\n+set -Eeuo pipefail\n+\n+repo='edburns/dd-3061974-02-cargotracker'\n+parent_issue=1\n+log_directory='/Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944'\n+body_directory=\"$log_directory/issue-bodies\"\n+ledger_path=\"$log_directory/creation-ledger.json\"\n+result_path=\"$log_directory/stage-20-result.json\"\n+baseline_path=\"$log_directory/pre-creation-children.json\"\n+verifier='/Users/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh'\n+\n+subsections=(\n+    '4.1 — Issue 1: Add the application-layer deadline change operation'\n+    '4.2 — Issue 2: Expose deadline changes through the booking facade'\n+    '4.3 — Issue 3: Implement the deadline editor backing model'\n+    '4.4 — Issue 4: Implement the PrimeFaces deadline dialog'\n+    '4.5 — Issue 5: Integrate deadline editing into the Administration dashboard'\n+)\n+titles=(\n+    '4.1: Add the application-layer deadline change operation'\n+    '4.2: Expose deadline changes through the booking facade'\n+    '4.3: Implement the deadline editor backing model'\n+    '4.4: Implement the PrimeFaces deadline dialog'\n+    '4.5: Integrate deadline editing into the Administration dashboard'\n+)\n+body_files=(\n+    \"$body_directory/01-4.1-body.md\"\n+    \"$body_directory/02-4.2-body.md\"\n+    \"$body_directory/03-4.3-body.md\"\n+    \"$body_directory/04-4.4-body.md\"\n+    \"$body_directory/05-4.5-body.md\"\n+)\n+\n+atomic_copy() {\n+    local source=\"$1\"\n+    local destination=\"$2\"\n+    local temporary\n+    temporary=\"$(mktemp \"$(dirname \"$destination\")/.stage20.XXXXXX\")\"\n+    cp \"$source\" \"$temporary\"\n+    mv \"$temporary\" \"$destination\"\n+}\n+\n+write_result() {\n+    local status=\"$1\"\n+    local operation_error=\"$2\"\n+    local temporary\n+    temporary=\"$(mktemp \"$log_directory/.stage20-result.XXXXXX\")\"\n+    jq -n \\\n+        --arg status \"$status\" \\\n+        --arg operationError \"$operation_error\" \\\n+        '{\n+            schemaVersion: 1,\n+            status: $status,\n+            ledgerFile: \"creation-ledger.json\",\n+            operationError: (if $operationError == \"\" then null else $operationError end)\n+        }' >\"$temporary\"\n+    mv \"$temporary\" \"$result_path\"\n+}\n+\n+update_ledger() {\n+    local filter=\"$1\"\n+    shift\n+    local temporary\n+    temporary=\"$(mktemp \"$log_directory/.creation-ledger.XXXXXX\")\"\n+    jq \"$@\" \"$filter\" \"$ledger_path\" >\"$temporary\"\n+    mv \"$temporary\" \"$ledger_path\"\n+}\n+\n+fail_stage() {\n+    trap - ERR\n+    local operation=\"$1\"\n+    local message=\"$2\"\n+    local operation_error=\"$operation: $message\"\n+    local children_output normalized_children temporary\n+\n+    if children_output=\"$(gh api \"repos/$repo/issues/$parent_issue/sub_issues\" --paginate --slurp 2>&1)\"; then\n+        if normalized_children=\"$(printf '%s' \"$children_output\" | jq 'if length == 0 then [] elif all(.[]; type == \"array\") then add else . end' 2>&1)\"; then\n+            temporary=\"$(mktemp \"$log_directory/.creation-ledger.XXXXXX\")\"\n+            jq --argjson children \"$normalized_children\" '\n+                map(.linked = ([ $children[].id ] | index(.id) != null))\n+            ' \"$ledger_path\" >\"$temporary\" && mv \"$temporary\" \"$ledger_path\"\n+        else\n+            operation_error=\"$operation_error; child reconciliation parse failed: $normalized_children\"\n+        fi\n+    else\n+        operation_error=\"$operation_error; child reconciliation query failed: $children_output\"\n+    fi\n+\n+    write_result failed \"$operation_error\"\n+    printf 'STAGE 20 FAILED: %s\\n' \"$operation_error\" >&2\n+    jq -r '.[] | \"#\\(.number) | \\(.title) | \\(.url) | \\(.bodyFile) | body_verified=\\(.body_verified) | linked=\\(.linked)\"' \"$ledger_path\" >&2\n+    jq -r --arg repo \"$repo\" '.[] | \"gh issue delete \\(.number) --repo \\\"\\($repo)\\\" --yes\"' \"$ledger_path\" >&2\n+    if [[ \"$(jq 'length' \"$ledger_path\")\" -eq 0 ]]; then\n+        printf 'No issues were created; no cleanup is required.\\n' >&2\n+    else\n+        printf 'No automatic rollback was performed. Delete every issue in the ledger before invoking stage 20 again.\\n' >&2\n+    fi\n+    exit 1\n+}\n+\n+unexpected_failure() {\n+    local line=\"$1\"\n+    local command=\"$2\"\n+    fail_stage 'unexpected local operation' \"line $line failed: $command\"\n+}\n+\n+trap 'unexpected_failure \"$LINENO\" \"$BASH_COMMAND\"' ERR\n+\n+children_output=\"$(gh api \"repos/$repo/issues/$parent_issue/sub_issues\" --paginate --slurp 2>&1)\" ||\n+    fail_stage 'pre-creation baseline query' \"$children_output\"\n+normalized_children=\"$(printf '%s' \"$children_output\" | jq 'if length == 0 then [] elif all(.[]; type == \"array\") then add else . end' 2>&1)\" ||\n+    fail_stage 'pre-creation baseline normalization' \"$normalized_children\"\n+printf '%s\\n' \"$normalized_children\" >\"$baseline_path.tmp\"\n+atomic_copy \"$baseline_path.tmp\" \"$baseline_path\"\n+rm \"$baseline_path.tmp\"\n+\n+printf '[]\\n' >\"$ledger_path.tmp\"\n+atomic_copy \"$ledger_path.tmp\" \"$ledger_path\"\n+rm \"$ledger_path.tmp\"\n+write_result in_progress ''\n+\n+printf 'Creating child issues without an issue type (repository owner is a user).\\n'\n+\n+for index in \"${!titles[@]}\"; do\n+    title=\"${titles[$index]}\"\n+    subsection=\"${subsections[$index]}\"\n+    body_file=\"${body_files[$index]}\"\n+    relative_body_file=\"issue-bodies/$(basename \"$body_file\")\"\n+\n+    created=\"$(gh api \"repos/$repo/issues\" \\\n+        -X POST \\\n+        -f title=\"$title\" \\\n+        -F \"body=@$body_file\" \\\n+        --jq '{id,number,node_id,html_url,title}' 2>&1)\" ||\n+        fail_stage \"create '$title'\" \"$created\"\n+\n+    if ! jq -e 'type == \"object\" and (.id | type == \"number\") and (.number | type == \"number\") and (.html_url | type == \"string\")' <<<\"$created\" >/dev/null; then\n+        fail_stage \"parse create response for '$title'\" \"$created\"\n+    fi\n+\n+    id=\"$(jq -r '.id' <<<\"$created\")\"\n+    number=\"$(jq -r '.number' <<<\"$created\")\"\n+    url=\"$(jq -r '.html_url' <<<\"$created\")\"\n+    actual_title=\"$(jq -r '.title' <<<\"$created\")\"\n+\n+    update_ledger '. + [{\n+        implementationSubsection: $subsection,\n+        bodyFile: $bodyFile,\n+        id: $id,\n+        number: $number,\n+        title: $title,\n+        url: $url,\n+        body_verified: false,\n+        linked: false\n+    }]' \\\n+        --arg subsection \"$subsection\" \\\n+        --arg bodyFile \"$relative_body_file\" \\\n+        --argjson id \"$id\" \\\n+        --argjson number \"$number\" \\\n+        --arg title \"$actual_title\" \\\n+        --arg url \"$url\"\n+\n+    issue_json=\"$(\"$verifier\" \\\n+        \"$repo\" \\\n+        \"$number\" \\\n+        \"$body_file\" \\\n+        6 \\\n+        5 \\\n+        \"$log_directory/issue-$number-body-verification-failure.json\" 2>&1)\" ||\n+        fail_stage \"verify initial body for issue #$number\" \"$issue_json\"\n+\n+    update_ledger 'map(if .number == $number then .body_verified = true else . end)' --argjson number \"$number\"\n+\n+    linked=false\n+    link_error=''\n+    for attempt in 1 2 3; do\n+        if link_output=\"$(printf '{\"sub_issue_id\": %s}' \"$id\" | gh api \"repos/$repo/issues/$parent_issue/sub_issues\" -X POST --input - 2>&1)\"; then\n+            linked=true\n+            break\n+        fi\n+        link_error=\"attempt $attempt: $link_output\"\n+    done\n+    [[ \"$linked\" == true ]] || fail_stage \"link issue #$number to parent #$parent_issue\" \"$link_error\"\n+\n+    update_ledger 'map(if .number == $number then .linked = true else . end)' --argjson number \"$number\"\n+    printf 'Created, verified, and linked #%s: %s\\n' \"$number\" \"$actual_title\"\n+done\n+\n+children_output=\"$(gh api \"repos/$repo/issues/$parent_issue/sub_issues\" --paginate --slurp 2>&1)\" ||\n+    fail_stage 'final child query' \"$children_output\"\n+final_children=\"$(printf '%s' \"$children_output\" | jq 'if length == 0 then [] elif all(.[]; type == \"array\") then add else . end' 2>&1)\" ||\n+    fail_stage 'final child normalization' \"$final_children\"\n+\n+baseline_count=\"$(jq 'length' \"$baseline_path\")\"\n+ledger_count=\"$(jq 'length' \"$ledger_path\")\"\n+final_count=\"$(jq 'length' <<<\"$final_children\")\"\n+expected_final_count=$((baseline_count + ledger_count))\n+[[ \"$final_count\" -eq \"$expected_final_count\" ]] ||\n+    fail_stage 'final child count' \"expected $expected_final_count children, observed $final_count\"\n+\n+new_child_ids=\"$(jq -c --argjson baseline \"$(cat \"$baseline_path\")\" '\n+    [ .[] | select(([ $baseline[].id ] | index(.id)) == null) | .id ]\n+' <<<\"$final_children\")\"\n+ledger_ids=\"$(jq -c '[.[].id]' \"$ledger_path\")\"\n+[[ \"$new_child_ids\" == \"$ledger_ids\" ]] ||\n+    fail_stage 'final child order' \"expected $ledger_ids, observed $new_child_ids\"\n+\n+duplicate_count=\"$(jq '[group_by(.id)[] | select(length != 1)] | length' <<<\"$final_children\")\"\n+[[ \"$duplicate_count\" -eq 0 ]] ||\n+    fail_stage 'final child uniqueness' \"found $duplicate_count duplicate linked child IDs\"\n+\n+while IFS=$'\\t' read -r number body_file; do\n+    absolute_body_file=\"$log_directory/$body_file\"\n+    issue_json=\"$(\"$verifier\" \\\n+        \"$repo\" \\\n+        \"$number\" \\\n+        \"$absolute_body_file\" \\\n+        6 \\\n+        5 \\\n+        \"$log_directory/issue-$number-final-body-verification-failure.json\" 2>&1)\" ||\n+        fail_stage \"verify final body for issue #$number\" \"$issue_json\"\n+\n+    if ! jq -e '.state == \"open\" and (.assignees | type == \"array\" and length == 0)' <<<\"$issue_json\" >/dev/null; then\n+        fail_stage \"verify final state for issue #$number\" 'issue must be open and unassigned'\n+    fi\n+done < <(jq -r '.[] | [.number, .bodyFile] | @tsv' \"$ledger_path\")\n+\n+write_result complete ''\n+printf 'STAGE 20 COMPLETE\\n'\n+jq '.' \"$ledger_path\"\n*** End Patch\n"
```

</details>

```
Added 1 file(s): /Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/run-stage-20.sh
```


---

<sub>2m 22s</sub>

### `apply_patch`

<details>
<summary>Arguments</summary>

```json
"*** Begin Patch\n*** Update File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/run-stage-20.sh\n@@\n-            jq --argjson children \"$normalized_children\" '\n-                map(.linked = ([ $children[].id ] | index(.id) != null))\n+            jq --argjson children \"$normalized_children\" '\n+                map(.id as $id | .linked = ([ $children[].id ] | index($id) != null))\n@@\n-new_child_ids=\"$(jq -c --argjson baseline \"$(cat \"$baseline_path\")\" '\n-    [ .[] | select(([ $baseline[].id ] | index(.id)) == null) | .id ]\n+new_child_ids=\"$(jq -c --argjson baseline \"$(cat \"$baseline_path\")\" '\n+    [ .[] | .id as $id | select(([ $baseline[].id ] | index($id)) == null) | .id ]\n*** End Patch\n"
```

</details>

```
Modified 1 file(s): /Users/edburns/workareas/dd-3061974-02-cargotracker-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/run-stage-20.sh
```


---

<sub>2m 27s</sub>

### Copilot

Draft validation passed for all five specifications. The repository has no organization issue types, so creation will omit the type field; I’m now executing the serial create → exact REST body verification → sub-issue link workflow with durable ledger updates after each operation.

---

<sub>2m 44s</sub>

### `bash`

**Create and verify child issues**

$ export IDEA_HOME="/Applications/IntelliJ IDEA CE.app/Contents/MacOS" APPCAT_HOME=/Users/edburns/.appcat JAVA_HOME="/Library/Java/JavaVirtualMachines/microsoft-25.jdk/Contents/Home" ANT_HOME=${HOME}/Downloads/apache-ant-1.10.13 M2_HOME=${HOME}/Downloads/apache-maven-3.9.8; export PATH=${APPCAT_HOME}:${M2_HOME}/bin:${ANT_HOME}/bin:${JAVA_HOME}/bin:${IDEA_HOME}:${PATH}; bash -n '1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/run-stage-20.sh' && bash '1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260910-0944/run-stage-20.sh'

<details>
<summary>60 lines</summary>

```
Creating child issues without an issue type (repository owner is a user).
Created, verified, and linked #2: 4.1: Add the application-layer deadline change operation
Created, verified, and linked #3: 4.2: Expose deadline changes through the booking facade
Created, verified, and linked #4: 4.3: Implement the deadline editor backing model
Created, verified, and linked #5: 4.4: Implement the PrimeFaces deadline dialog
Created, verified, and linked #6: 4.5: Integrate deadline editing into the Administration dashboard
STAGE 20 COMPLETE
[
  {
    "implementationSubsection": "4.1 — Issue 1: Add the application-layer deadline change operation",
    "bodyFile": "issue-bodies/01-4.1-body.md",
    "id": 5414950517,
    "number": 2,
    "title": "4.1: Add the application-layer deadline change operation",
    "url": "https://github.com/edburns/dd-3061974-02-cargotracker/issues/2",
    "body_verified": true,
    "linked": true
  },
  {
    "implementationSubsection": "4.2 — Issue 2: Expose deadline changes through the booking facade",
    "bodyFile": "issue-bodies/02-4.2-body.md",
    "id": 5414950794,
    "number": 3,
    "title": "4.2: Expose deadline changes through the booking facade",
    "url": "https://github.com/edburns/dd-3061974-02-cargotracker/issues/3",
    "body_verified": true,
    "linked": true
  },
  {
    "implementationSubsection": "4.3 — Issue 3: Implement the deadline editor backing model",
    "bodyFile": "issue-bodies/03-4.3-body.md",
    "id": 5414951166,
    "number": 4,
    "title": "4.3: Implement the deadline editor backing model",
    "url": "https://github.com/edburns/dd-3061974-02-cargotracker/issues/4",
    "body_verified": true,
    "linked": true
  },
  {
    "implementationSubsection": "4.4 — Issue 4: Implement the PrimeFaces deadline dialog",
    "bodyFile": "issue-bodies/04-4.4-body.md",
    "id": 5414951454,
    "number": 5,
    "title": "4.4: Implement the PrimeFaces deadline dialog",
    "url": "https://github.com/edburns/dd-3061974-02-cargotracker/issues/5",
    "body_verified": true,
    "linked": true
  },
  {
    "implementationSubsection": "4.5 — Issue 5: Integrate deadline editing into the Administration dashboard",
    "bodyFile": "issue-bodies/05-4.5-body.md",
    "id": 5414951906,
    "number": 6,
    "title": "4.5: Integrate deadline editing into the Administration dashboard",
    "url": "https://github.com/edburns/dd-3061974-02-cargotracker/issues/6",
    "body_verified": true,
    "linked": true
  }
]
<shellId: 6 completed with exit code 0>
```

</details>


---

<sub>2m 49s</sub>

### Copilot

Created and linked five ordered, unassigned child issues under #1. All persisted bodies and postconditions were verified; issues were created **without an issue type** because the repository owner is a user.

| Subsection | Issue | Title | URL |
|---|---:|---|---|
| 4.1 | #2 | Add the application-layer deadline change operation | https://github.com/edburns/dd-3061974-02-cargotracker/issues/2 |
| 4.2 | #3 | Expose deadline changes through the booking facade | https://github.com/edburns/dd-3061974-02-cargotracker/issues/3 |
| 4.3 | #4 | Implement the deadline editor backing model | https://github.com/edburns/dd-3061974-02-cargotracker/issues/4 |
| 4.4 | #5 | Implement the PrimeFaces deadline dialog | https://github.com/edburns/dd-3061974-02-cargotracker/issues/5 |
| 4.5 | #6 | Integrate deadline editing into the Administration dashboard | https://github.com/edburns/dd-3061974-02-cargotracker/issues/6 |

**Ordered child list:** `2,3,4,5,6`

**Suggested stage-25 invocation:** invoke `shepherd-task-25-given-list` with ordered issues `2,3,4,5,6`, campaign ID `c9e71f6c-ab48-4663-8125-5b796a989029`, and plan directory `1-arrival-deadline-control-remove-before-merge`. Stage 25 will derive lesson propagation from the campaign manifest.

---

<sub>Generated by [GitHub Copilot CLI](https://github.com/features/copilot/cli)</sub>
