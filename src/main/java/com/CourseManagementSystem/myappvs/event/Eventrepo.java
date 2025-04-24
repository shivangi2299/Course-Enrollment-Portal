package com.CourseManagementSystem.myappvs.event;

import com.CourseManagementSystem.myappvs.event.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface Eventrepo extends MongoRepository<Event, String> {
    List<Event> findByDate(LocalDate date);

}