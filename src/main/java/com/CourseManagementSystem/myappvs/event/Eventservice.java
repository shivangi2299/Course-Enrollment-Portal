package com.CourseManagementSystem.myappvs.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface Eventservice {
    List<Event> getEventsByDate(LocalDate date);

    Event createEvent(Event event);

    List<Event> getAllEvents();
}