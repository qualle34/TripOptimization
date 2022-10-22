package com.qualle.trip.resurce;

import com.qualle.trip.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserResource extends PagingAndSortingRepository<User, Long> {
}
