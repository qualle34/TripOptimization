package com.qualle.trip.resurce;

import com.qualle.trip.entity.Department;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DepartmentResource extends PagingAndSortingRepository<Department, Long> {
}
