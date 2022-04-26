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
    public void updateEmployee(Integer id, Employee updatedEmployee) throws DataNotFoundException {
        Employee oldEmployee = employeeRepository.findById(updatedEmployee.getId())
                .orElseThrow(() -> new DataNotFoundException("No user with id=" + id + " found"));

        oldEmployee.setEmail(updatedEmployee.getEmail());
        oldEmployee.setDepartment(updatedEmployee.getDepartment());
        oldEmployee.setFirstName(updatedEmployee.getFirstName());
        oldEmployee.setLastName(updatedEmployee.getLastName());
        oldEmployee.setSalary(updatedEmployee.getSalary());
        oldEmployee.setPhoneNumber(updatedEmployee.getPhoneNumber());

        employeeRepository.save(oldEmployee);
    }
}
