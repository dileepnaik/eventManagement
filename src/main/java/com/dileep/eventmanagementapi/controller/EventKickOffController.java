package com.dileep.eventmanagementapi.controller;

import com.dileep.eventmanagementapi.entites.Event;
import com.dileep.eventmanagementapi.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RepositoryRestController
@RequestMapping("/events")
public class EventKickOffController {

    @Autowired
    EventRepository eventRepository;

    @PostMapping("/start/{id}")
    public ResponseEntity start(@PathVariable Long id) {

        Optional<Event> event = eventRepository.findById(id);

        if (event.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        Event event1 = event.get();
        event1.setStarted(Boolean.TRUE);
        eventRepository.save(event1);

        return ResponseEntity.ok(event1.getName()+ " Has Started");
    }
}
