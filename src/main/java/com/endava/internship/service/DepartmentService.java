package com.endava.internship.service;

import com.endava.internship.domain.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();

    Department getDepartmentById(Integer id) throws DataNotFoundException;

    void createDepartment(Department department);

    Department updateDepartment(Integer id, Department department) throws DataNotFoundException;
}
