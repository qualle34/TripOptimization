package com.qualle.trip.resurce;

import com.qualle.trip.entity.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface MemberResource extends PagingAndSortingRepository<Member, Long> {

    @RestResource(path = "findMemberByUserAndTrip")
    @Query("SELECT m FROM Member m JOIN FETCH m.user u JOIN FETCH m.trip t WHERE u.id = :userId AND t.id = :tripId")
    Member findMemberByUserAndTrip(Long userId, Long tripId);

    @RestResource(path = "findMembersByTrip")
    @Query("SELECT m FROM Member m JOIN FETCH m.trip t JOIN FETCH m.user JOIN FETCH m.memberAllowances ma JOIN FETCH ma.allowance WHERE t.id = :tripId")
    List<Member> findMembersByTrip(Long tripId);
}