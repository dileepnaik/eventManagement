package com.dileep.eventmanagementapi.entites.protections;

import com.dileep.eventmanagementapi.entites.Venue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.validation.annotation.Validated;

@Projection(name = "virtual", types = { Venue.class })
public interface StreetAddressProjection {

    @Value("#{target.streetAddress} #{target.streetAddress2}")
    String getCompleteStreetAddress();
}
