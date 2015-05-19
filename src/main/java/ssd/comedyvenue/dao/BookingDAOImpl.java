package ssd.comedyvenue.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ssd.comedyvenue.model.Booking;

import java.util.List;

@Repository
public class BookingDAOImpl implements BookingDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBooking(Booking booking) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(booking);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateBooking(Booking booking) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(booking);
    }

    @Override
    public List<Booking> listBookings() {
        Session session = this.sessionFactory.openSession();
        List<Booking> bookingList = session.createQuery("from Booking").list();
        session.close();
        return bookingList;
    }

    @Override
    public Booking getBookingById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Booking booking = (Booking) session.load(Booking.class, new Integer(id));
        return booking;
    }

    @Override
    public void removeBooking(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Booking booking = (Booking) session.load(Booking.class, new Integer(id));
        if(null != booking){
            session.delete(booking);
        }
    }
}
