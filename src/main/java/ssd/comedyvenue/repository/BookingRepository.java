package ssd.comedyvenue.repository;

import org.springframework.transaction.annotation.Transactional;
import ssd.comedyvenue.dao.BookingDAO;
import ssd.comedyvenue.model.Booking;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingRepository implements Repository<Booking> {

    private BookingDAO bookingDAO;

    public BookingRepository() {}

    public void setBookingDAO(BookingDAO bookingDAO){
        this.bookingDAO = bookingDAO;
    }

    @Override
    @Transactional
    public void add(Booking entity) {
        this.bookingDAO.addBooking(entity);
    }

    @Override
    @Transactional
    public void update(Booking entity) {
        this.bookingDAO.updateBooking(entity);
    }

    @Override
    @Transactional
    public List<Booking> list() {
        return this.bookingDAO.listBookings();
    }

    @Override
    @Transactional
    public Booking getById(int id) {
        return this.bookingDAO.getBookingById(id);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.bookingDAO.removeBooking(id);
    }
}
