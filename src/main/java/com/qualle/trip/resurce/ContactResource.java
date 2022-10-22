package com.qualle.trip.resurce;

import com.qualle.trip.entity.Allowance;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ContactResource extends PagingAndSortingRepository<Allowance, Long> {
}
