package ssd.comedyvenue.repository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import ssd.comedyvenue.model.Booking;
import ssd.comedyvenue.util.ConnectionProvider;

import java.sql.SQLException;
import java.util.List;

public class BookingRepository implements Repository<Booking> {

    Dao<Booking, Integer> bookingDao;

    public BookingRepository(){

        try {
            this.bookingDao = DaoManager.createDao(ConnectionProvider.getConnection(), Booking.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Booking entity){

        try {
            this.bookingDao.create(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void update(Booking entity){

        try {
            this.bookingDao.update(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Booking> list(){

        try {
            return this.bookingDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Booking getById(int id){

        try {
            return this.bookingDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void remove(int id){

        try {
            this.bookingDao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
