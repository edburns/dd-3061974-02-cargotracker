package org.eclipse.cargotracker.interfaces.booking.facade.internal;

import org.eclipse.cargotracker.application.BookingService;
import org.eclipse.cargotracker.application.util.DateUtil;
import org.eclipse.cargotracker.domain.model.cargo.Itinerary;
import org.eclipse.cargotracker.domain.model.cargo.TrackingId;
import org.eclipse.cargotracker.domain.model.location.UnLocode;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Verifies that the booking facade is a thin boundary that simply delegates
 * deadline changes to the application service.
 */
public class DefaultBookingServiceFacadeTest {

    private BookingServiceSpy bookingService;
    private DefaultBookingServiceFacade facade;

    @Before
    public void setUp() throws Exception {
        bookingService = new BookingServiceSpy();
        facade = new DefaultBookingServiceFacade();

        Field field = DefaultBookingServiceFacade.class
                .getDeclaredField("bookingService");
        field.setAccessible(true);
        field.set(facade, bookingService);
    }

    @Test
    public void testChangeDeadlineDelegatesToBookingService() {
        Date newDeadline = DateUtil.toDate("2014-04-01");

        facade.changeDeadline("ABC123", newDeadline);

        assertEquals(1, bookingService.trackingIds.size());
        assertEquals(new TrackingId("ABC123"), bookingService.trackingIds.get(0));
        assertEquals(1, bookingService.deadlines.size());
        assertEquals(newDeadline, bookingService.deadlines.get(0));
    }

    private static class BookingServiceSpy implements BookingService {

        private final List<TrackingId> trackingIds = new ArrayList<>();
        private final List<Date> deadlines = new ArrayList<>();

        @Override
        public TrackingId bookNewCargo(UnLocode origin, UnLocode destination,
                                       Date arrivalDeadline) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<Itinerary> requestPossibleRoutesForCargo(TrackingId trackingId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void assignCargoToRoute(Itinerary itinerary, TrackingId trackingId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void changeDestination(TrackingId trackingId, UnLocode unLocode) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void changeDeadline(TrackingId trackingId, Date deadline) {
            trackingIds.add(trackingId);
            deadlines.add(deadline);
        }
    }
}
