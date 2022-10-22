package com.qualle.trip.resurce;

import com.qualle.trip.entity.Passport;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PassportResource extends PagingAndSortingRepository<Passport, Long> {
}