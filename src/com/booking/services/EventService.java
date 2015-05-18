package com.booking.services;

import com.booking.domain.Event;

import java.util.List;

public interface EventService {

    public void addEvent(Event event);

    public List<Event> listEvents();

    public void removeEvent(Integer id);

}
