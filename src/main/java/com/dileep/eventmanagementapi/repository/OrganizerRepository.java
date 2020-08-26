package com.dileep.eventmanagementapi.repository;

import com.dileep.eventmanagementapi.entites.Organizer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long> {

}
