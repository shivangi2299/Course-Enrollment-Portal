package com.CourseManagementSystem.myappvs.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private Eventrepo eventRepository;

    // Get events by date
    @GetMapping("/{date}")
    public List<Event> getEventsByDate(@PathVariable LocalDate date) {
        return eventRepository.findByDate(date);
    }

    // Create a new event
    @PostMapping
    public Event createEvent(@Validated @RequestBody Event event) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        event.setEmailId(userDetails.getUsername()); // Set the emailId from the authenticated user
        return eventRepository.save(event);
    }

    // Update an event
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable String id, @Validated @RequestBody Event eventDetails) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String authenticatedUserEmail = userDetails.getUsername();

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        // Check if the authenticated user is the owner of the event
        if (!event.getEmailId().equals(authenticatedUserEmail)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("You are not authorized to update this event. This event is not hosted by you.");
        }

        event.setDate(eventDetails.getDate());
        event.setEventName(eventDetails.getEventName());

        final Event updatedEvent = eventRepository.save(event);
        return ResponseEntity.ok(updatedEvent);
    }

    // Delete an event
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable String id) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String authenticatedUserEmail = userDetails.getUsername();

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        // Check if the authenticated user is the owner of the event
        if (!event.getEmailId().equals(authenticatedUserEmail)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("You are not authorized to delete this event. This event is not hosted by you.");
        }

        eventRepository.delete(event);
        return ResponseEntity.ok().build();
    }

    // Get all events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}