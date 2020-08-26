package com.dileep.eventmanagementapi.repository;

import com.dileep.eventmanagementapi.entites.Venue;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {
    List<Venue> findByPostalCode(@Param("postalCode") String postalCode);
}
