package com.qualle.trip.resurce;

import com.qualle.trip.entity.Trip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface TripResource extends PagingAndSortingRepository<Trip, Long> {

    @RestResource(path = "findByUserId")
    @Query("SELECT t FROM Trip t JOIN FETCH t.members m JOIN FETCH m.user u WHERE u.id = :userId")
    List<Trip> findByUserId(Long userId);

    @RestResource(path = "findFullById")
    @Query("SELECT t FROM Trip t JOIN FETCH t.members m JOIN FETCH m.user u WHERE t.id = :id")
    Trip findFullById(Long id);
}
