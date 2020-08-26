package com.dileep.eventmanagementapi.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Data
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @CreationTimestamp
    @Column(updatable = false)
    @JsonIgnore
    protected Instant created;
}
