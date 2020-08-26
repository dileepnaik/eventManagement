package com.dileep.eventmanagementapi.entites;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@EqualsAndHashCode(of="id")
@Entity
public class Venue extends AbstractEntity {

    private String name;
    private String streetAddress;
    private String streetAddress2;
    private String city;
    private String state;
    private String country;
    private String postalCode;


    public Long getResourceID(){
        return id;
    }
}
