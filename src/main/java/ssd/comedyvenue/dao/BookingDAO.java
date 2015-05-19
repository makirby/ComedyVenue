package ssd.comedyvenue.dao;

import ssd.comedyvenue.model.Booking;

import java.util.List;

public interface BookingDAO {

    void addBooking(Booking booking);
    void updateBooking(Booking booking);
    List<Booking> listBookings();
    Booking getBookingById(int id);
    void removeBooking(int id);
}
