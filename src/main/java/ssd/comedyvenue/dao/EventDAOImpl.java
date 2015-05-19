package ssd.comedyvenue.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ssd.comedyvenue.model.Event;

import java.util.List;

@Repository
public class EventDAOImpl implements EventDAO {

    private SessionFactory sessionFactory;

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addEvent(Event event) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(event);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateEvent(Event event) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(event);
    }

    @Override
    public List<Event> listEvents() {
        Session session = this.sessionFactory.openSession();
        List<Event> eventList = session.createQuery("from Event").list();
        session.close();
        return eventList;
    }

    @Override
    public Event getEventById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Event event = (Event) session.load(Event.class, new Integer(id));
        return event;
    }

    @Override
    public void removeEvent(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Event event = (Event) session.load(Event.class, new Integer(id));
        if(null != event){
            session.delete(event);
        }
    }
}
