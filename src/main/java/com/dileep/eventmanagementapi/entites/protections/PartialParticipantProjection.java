package com.dileep.eventmanagementapi.entites.protections;

import com.dileep.eventmanagementapi.entites.Participant;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "participantPartial", types = { Participant.class })
public interface PartialParticipantProjection {
    String getName();
    boolean getCheckedIn();
}
