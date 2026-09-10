package org.eclipse.cargotracker.interfaces.booking.web;

import org.eclipse.cargotracker.interfaces.booking.facade.BookingServiceFacade;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.CargoRoute;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.Location;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.RouteCandidate;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

public class ChangeArrivalDeadlineDateTest {

    private ChangeArrivalDeadlineDate editor;
    private BookingServiceFacadeFake facade;

    @Before
    public void setUp() throws Exception {
        editor = new ChangeArrivalDeadlineDate();
        facade = new BookingServiceFacadeFake();
        Field field = ChangeArrivalDeadlineDate.class
                .getDeclaredField("bookingServiceFacade");
        field.setAccessible(true);
        field.set(editor, facade);
    }

    @Test
    public void testLoadUsesTrackingIdAndConvertsDeadlineDate() throws Exception {
        editor.setTrackingId("ABC123");
        facade.cargo = new CargoRoute("ABC123", "USNYC", "SESTO",
                new SimpleDateFormat("MM/dd/yyyy").parse("04/01/2014"),
                false, false, "", "");

        editor.load();

        assertEquals("ABC123", facade.loadedTrackingId);
        assertSame(facade.cargo, editor.getCargo());
        assertEquals("04/01/2014", new SimpleDateFormat("MM/dd/yyyy")
                .format(editor.getArrivalDeadlineDate()));
    }

    @Test
    public void testLoadSurfacesMalformedDeadlineDate() {
        editor.setTrackingId("ABC123");
        facade.cargo = new InvalidCargoRoute();

        try {
            editor.load();
            fail("Expected malformed deadline date to be rejected");
        } catch (IllegalArgumentException expected) {
            assertEquals("Unable to parse arrival deadline date for cargo ABC123",
                    expected.getMessage());
        }
    }

    @Test
    public void testLoadSurfacesMissingCargo() {
        editor.setTrackingId("ABC123");

        try {
            editor.load();
            fail("Expected missing cargo to be rejected");
        } catch (IllegalArgumentException expected) {
            assertEquals("Cargo with tracking ID ABC123 was not found",
                    expected.getMessage());
        }
    }

    @Test
    public void testChangeArrivalDeadlineRejectsNullDate() {
        try {
            editor.changeArrivalDeadline();
            fail("Expected null deadline date to be rejected");
        } catch (IllegalArgumentException expected) {
            assertEquals("Arrival deadline date is required", expected.getMessage());
        }

        assertEquals(0, facade.changeDeadlineCalls);
    }

    @Test
    public void testChangeArrivalDeadlineDoesNotCloseDialogWhenFacadeFails()
            throws Exception {
        Date selectedDate = new SimpleDateFormat("MM/dd/yyyy").parse("04/01/2014");
        editor.setTrackingId("ABC123");
        editor.setArrivalDeadlineDate(selectedDate);
        facade.failure = new IllegalStateException("Facade failure");

        try {
            editor.changeArrivalDeadline();
            fail("Expected facade failure");
        } catch (IllegalStateException expected) {
            assertEquals("Facade failure", expected.getMessage());
        }

        assertEquals(1, facade.changeDeadlineCalls);
        assertEquals("ABC123", facade.changedTrackingId);
        assertSame(selectedDate, facade.changedDeadline);
    }

    private static class InvalidCargoRoute extends CargoRoute {

        InvalidCargoRoute() {
            super("ABC123", "USNYC", "SESTO", new Date(), false, false, "", "");
        }

        @Override
        public String getArrivalDeadlineDate() {
            return "not a date";
        }
    }

    private static class BookingServiceFacadeFake implements BookingServiceFacade {

        private CargoRoute cargo;
        private String loadedTrackingId;
        private int changeDeadlineCalls;
        private String changedTrackingId;
        private Date changedDeadline;
        private RuntimeException failure;

        @Override
        public String bookNewCargo(String origin, String destination, Date arrivalDeadline) {
            throw new UnsupportedOperationException();
        }

        @Override
        public CargoRoute loadCargoForRouting(String trackingId) {
            loadedTrackingId = trackingId;
            return cargo;
        }

        @Override
        public void assignCargoToRoute(String trackingId, RouteCandidate route) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void changeDestination(String trackingId, String destinationUnLocode) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void changeDeadline(String trackingId, Date arrivalDeadline) {
            changeDeadlineCalls++;
            changedTrackingId = trackingId;
            changedDeadline = arrivalDeadline;
            if (failure != null) {
                throw failure;
            }
        }

        @Override
        public List<RouteCandidate> requestPossibleRoutesForCargo(String trackingId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<Location> listShippingLocations() {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<CargoRoute> listAllCargos() {
            throw new UnsupportedOperationException();
        }
    }
}
