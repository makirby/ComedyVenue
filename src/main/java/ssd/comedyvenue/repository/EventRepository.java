package ssd.comedyvenue.repository;

import org.springframework.transaction.annotation.Transactional;
import ssd.comedyvenue.dao.EventDAO;
import ssd.comedyvenue.model.Event;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventRepository implements Repository<Event> {

    private EventDAO eventDAO;

    public void setEventDAO(EventDAO eventDAO){
        this.eventDAO = eventDAO;
    }

    @Override
    @Transactional
    public void add(Event entity) {
        this.eventDAO.addEvent(entity);
    }

    @Override
    @Transactional
    public void update(Event entity) {
        this.eventDAO.updateEvent(entity);
    }

    @Override
    @Transactional
    public List<Event> list() {
        return this.eventDAO.listEvents();
    }

    @Override
    @Transactional
    public Event getById(int id) {
        return this.eventDAO.getEventById(id);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.eventDAO.removeEvent(id);
    }
}
