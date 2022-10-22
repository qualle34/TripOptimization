package com.qualle.trip.resurce;

import com.qualle.trip.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoleResource extends PagingAndSortingRepository<Role, Long> {
}