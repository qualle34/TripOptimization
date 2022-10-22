package com.qualle.trip.resurce;

import com.qualle.trip.entity.Credentials;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CredentialsResource extends PagingAndSortingRepository<Credentials, Long> {
}
