package com.qualle.trip.resurce;

import com.qualle.trip.entity.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CountryResource extends PagingAndSortingRepository<Country, Long> {
}
