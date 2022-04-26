package com.endava.internship.service;

import com.endava.internship.domain.Employee;
import com.endava.internship.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll() ;
    }

    @Override
    public Employee getEmployeeById(Integer id) throws DataNotFoundException {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("No user with id=" + id + " found"));
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Integer id, Employee updateData) throws DataNotFoundException {
        Employee employeeToUpdate = employeeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("No user with id=" + id + " found"));

        employeeToUpdate.setEmail(updateData.getEmail());
        employeeToUpdate.setDepartment(updateData.getDepartment());
        employeeToUpdate.setFirstName(updateData.getFirstName());
        employeeToUpdate.setLastName(updateData.getLastName());
        employeeToUpdate.setSalary(updateData.getSalary());
        employeeToUpdate.setPhoneNumber(updateData.getPhoneNumber());

        employeeRepository.save(employeeToUpdate);

        return employeeToUpdate;
    }
}
