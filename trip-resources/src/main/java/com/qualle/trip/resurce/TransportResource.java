package com.qualle.trip.resurce;

import com.qualle.trip.entity.Transport;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TransportResource extends PagingAndSortingRepository<Transport, Long> {
}