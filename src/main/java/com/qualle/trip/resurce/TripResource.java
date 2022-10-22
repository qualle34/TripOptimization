package com.qualle.trip.resurce;

import com.qualle.trip.entity.Trip;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TripResource extends PagingAndSortingRepository<Trip, Long> {
}
