package com.qualle.trip.web.client;

import com.qualle.trip.web.client.api.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "departmentClient", url = "http://localhost:8080/")
public interface DepartmentClient {

    @GetMapping(value = "/departments?page={page}&size={size}&sort={sort}")
    CollectionModel<Department> getDepartments(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("sort") String sort);

    @GetMapping(value = "/departments/{id}")
    EntityModel<Department> getDepartment(@PathVariable("id") Long id);

    @GetMapping(value = "/users/{userId}/department")
    EntityModel<Department> getDepartmentByUserId(@PathVariable("userId") Long userId);

}
