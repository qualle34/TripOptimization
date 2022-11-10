package com.qualle.trip.web.service;

import com.qualle.trip.web.client.api.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getDepartments(int page, int size);

    Department getDepartment(long id);
}
