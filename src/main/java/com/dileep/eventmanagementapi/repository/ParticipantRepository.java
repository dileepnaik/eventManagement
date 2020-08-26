package com.dileep.eventmanagementapi.repository;
import com.dileep.eventmanagementapi.entites.Participant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> {
    Participant findByEmail(@Param("email") String email);
}
