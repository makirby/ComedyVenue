package ssd.comedyvenue.dao;

import org.hibernate.SessionFactory;
import ssd.comedyvenue.model.Event;

import java.util.List;

/**
 * Created by merrick on 19/05/15.
 */
public interface EventDAO {
    void setSessionFactory(SessionFactory sessionFactory);

    void addEvent(Event event);

    void updateEvent(Event event);

    List<Event> listEvents();

    Event getEventById(int id);

    void removeEvent(int id);
}
