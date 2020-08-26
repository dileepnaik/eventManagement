package com.dileep.eventmanagementapi.controller;

import com.dileep.eventmanagementapi.controller.exceptions.NotCheckInException;
import com.dileep.eventmanagementapi.entites.Participant;
import com.dileep.eventmanagementapi.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

    @RepositoryRestController
    @RequestMapping("/events")
    public class CheckOutController {

        @Autowired
        private ParticipantRepository participantRepository;

        @PostMapping("/checkout/{id}")
        public ResponseEntity<PersistentEntityResource> CheckOut(@PathVariable("id") Long id,
                PersistentEntityResourceAssembler assembler)
                throws NotCheckInException {

            Optional<Participant> participant = participantRepository.findById(id);

            if (participant != null) {
                if (!participant.get().isCheckedIn()) {
                    throw new NotCheckInException();
                }
            }

            Participant participant2 = participant.get();
            participant2.setCheckedIn(Boolean.FALSE);
            participantRepository.save(participant2);
            return ResponseEntity.ok(assembler.toFullResource(participant2));
        }
    }