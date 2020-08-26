package com.dileep.eventmanagementapi.controller;

import com.dileep.eventmanagementapi.controller.exceptions.AlredyCheckedInException;
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
public class CheckInController {

    @Autowired
    private ParticipantRepository participantRepository;

    @PostMapping("/checkin/{id}")
    public ResponseEntity<PersistentEntityResource> CheckIn(@PathVariable("id") Long id,
            PersistentEntityResourceAssembler assembler) throws AlredyCheckedInException {

        Optional<Participant> participant = participantRepository.findById(id);

        if (participant != null) {
            if (participant.get().isCheckedIn()) {
                throw new AlredyCheckedInException();
            }
        }

        Participant participant2 = participant.get();
        participant2.setCheckedIn(Boolean.TRUE);
        participantRepository.save(participant2);
        return ResponseEntity.ok(assembler.toFullResource(participant2));
    }
}
