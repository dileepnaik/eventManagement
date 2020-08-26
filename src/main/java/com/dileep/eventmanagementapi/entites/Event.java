package com.dileep.eventmanagementapi.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

@Data
@EqualsAndHashCode(of="id")
@Entity
@JsonPropertyOrder({"started","resourceID","name","description"})
public class Event extends AbstractEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @JsonProperty("desc")
    private String description;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private ZoneId zoneId;
    private Boolean started;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Organizer organizer;
    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Participant> participants;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @RestResource(exported = false)
    private Venue venue;

    public Long getResourceID(){
        return id;
    }
}
