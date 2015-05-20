package ssd.comedyvenue.repository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import ssd.comedyvenue.model.Event;
import ssd.comedyvenue.util.ConnectionProvider;

import java.sql.SQLException;
import java.util.List;

public class EventRepository implements Repository<Event> {

    Dao<Event, Integer> eventDao;

    public EventRepository(){

        try {
            this.eventDao = DaoManager.createDao(ConnectionProvider.getConnection(), Event.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Event entity){

        try {
            this.eventDao.create(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Event entity){

        try {
            this.eventDao.update(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Event> list(){

        try {
            return this.eventDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Event getById(int id){

        try {
            return this.eventDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void remove(int id){

        try {
            this.eventDao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
