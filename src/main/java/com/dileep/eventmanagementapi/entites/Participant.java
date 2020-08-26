package com.dileep.eventmanagementapi.entites;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode(of="id")
@Entity
public class Participant extends AbstractEntity {

    private String name;
    private String email;
    private boolean checkedIn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "ID", nullable = false, updatable = false)
    private Event event;

    public Long getResourceID(){
        return id;
    }
}
