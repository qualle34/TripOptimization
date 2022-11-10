package com.qualle.trip.web.service.impl;

import com.qualle.trip.web.client.DepartmentClient;
import com.qualle.trip.web.client.api.Department;
import com.qualle.trip.web.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentClient departmentClient;


    @Override
    public List<Department> getDepartments(int page, int size) {
        return new ArrayList<>(departmentClient.getDepartments(page, size, "").getContent());
    }

    @Override
    public Department getDepartment(long id) {
        return departmentClient.getDepartment(id).getContent();
    }
}
