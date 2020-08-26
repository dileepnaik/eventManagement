package com.dileep.eventmanagementapi.entites;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@EqualsAndHashCode(of="id")
@Entity
public class Organizer extends AbstractEntity {

    @OneToMany(mappedBy = "organizer")
    private Set<Event> events;
    private String name;

    public Long getResourceID(){
        return id;
    }
}
