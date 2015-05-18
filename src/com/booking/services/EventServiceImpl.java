package com.booking.services;

import com.booking.domain.Event;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void addEvent(Event event) {
        em.persist(event);
    }

    @Transactional
    public List<Event> listEvents() {
        CriteriaQuery<Event> c = em.getCriteriaBuilder().createQuery(Event.class);
        c.from(Event.class);
        return em.createQuery(c).getResultList();
    }

    @Transactional
    public void removeEvent(Integer id) {
        Event event = em.find(Event.class, id);
        if (null != event) {
            em.remove(event);
        }
    }
}
