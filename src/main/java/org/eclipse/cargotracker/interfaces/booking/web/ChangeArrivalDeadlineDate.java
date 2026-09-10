package org.eclipse.cargotracker.interfaces.booking.web;

import org.eclipse.cargotracker.interfaces.booking.facade.BookingServiceFacade;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.CargoRoute;
import org.primefaces.PrimeFaces;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Named
@ViewScoped
public class ChangeArrivalDeadlineDate implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String ARRIVAL_DEADLINE_DATE_FORMAT = "MM/dd/yyyy";

    private String trackingId;
    private CargoRoute cargo;
    private Date arrivalDeadlineDate;

    @Inject
    private BookingServiceFacade bookingServiceFacade;

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public CargoRoute getCargo() {
        return cargo;
    }

    public Date getArrivalDeadlineDate() {
        return arrivalDeadlineDate;
    }

    public void setArrivalDeadlineDate(Date arrivalDeadlineDate) {
        this.arrivalDeadlineDate = arrivalDeadlineDate;
    }

    public void load() {
        cargo = null;
        arrivalDeadlineDate = null;

        CargoRoute loadedCargo = bookingServiceFacade.loadCargoForRouting(trackingId);
        if (loadedCargo == null) {
            throw new IllegalArgumentException(
                    "Cargo with tracking ID " + trackingId + " was not found");
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(
                    ARRIVAL_DEADLINE_DATE_FORMAT);
            dateFormat.setLenient(false);
            Date loadedArrivalDeadlineDate =
                    dateFormat.parse(loadedCargo.getArrivalDeadlineDate());
            cargo = loadedCargo;
            arrivalDeadlineDate = loadedArrivalDeadlineDate;
        } catch (ParseException e) {
            throw new IllegalArgumentException(
                    "Unable to parse arrival deadline date for cargo " + trackingId, e);
        }
    }

    public void changeArrivalDeadline() {
        if (arrivalDeadlineDate == null) {
            throw new IllegalArgumentException("Arrival deadline date is required");
        }

        bookingServiceFacade.changeDeadline(trackingId, arrivalDeadlineDate);
        PrimeFaces.current().dialog().closeDynamic("DONE");
    }
}
