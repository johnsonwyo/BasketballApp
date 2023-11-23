package com.basketballapp.practiceservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.basketballapp.practiceservice.config.ServiceConfig;
import com.basketballapp.practiceservice.model.Event;
import com.basketballapp.practiceservice.repository.EventRepository;
import com.basketballapp.practiceservice.repository.PracticeRepository;

@Service
public class EventService {

    @Autowired
    MessageSource messages;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private PracticeRepository practiceRepository;

    @Autowired
    ServiceConfig config;

    public Event getEvent(int eventId) {
        Event event = eventRepository.findById(eventId).get();
        if (null == event) {
            throw new IllegalArgumentException(
                    String.format(messages.getMessage("event.search.error.message", null, null), eventId));
        }
        return event;
    }

    public Event createEvent(Event event, String date, int grade) {
        event.setPractice(practiceRepository.findByDateAndGrade(date, grade));
        eventRepository.save(event);

        return event;
    }

    public Event updateEvent(Event newevent, String date, int grade) {
        Event event = eventRepository.findById(newevent.getEventId()).get();
        this.deleteEvent(event.getEventId());
        this.createEvent(newevent, date, grade);
        return newevent;
    }

    public String deleteEvent(int eventId) {
        eventRepository.delete(eventRepository.findById(eventId).get());
        return "event #: " + eventId + " was deleted.";

    }

}
