package com.endava.internship.service;

import com.endava.internship.domain.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id) throws DataNotFoundException;

    void createEmployee(Employee employee);

    void updateEmployee(Integer id, Employee employee) throws DataNotFoundException;
}
