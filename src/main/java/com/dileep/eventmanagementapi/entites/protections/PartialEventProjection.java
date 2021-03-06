package com.dileep.eventmanagementapi.entites.protections;

import com.dileep.eventmanagementapi.entites.Event;
import org.springframework.data.rest.core.config.Projection;

import java.time.Instant;
import java.time.ZonedDateTime;

@Projection(name = "partial", types = { Event.class })
public interface PartialEventProjection {

    String getName();
    ZonedDateTime getStartTime();
    ZonedDateTime getEndTime();
    Instant getCreated();
}
