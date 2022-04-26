package com.endava.internship.controller;

import com.endava.internship.domain.Employee;
import com.endava.internship.service.DataNotFoundException;
import com.endava.internship.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(path = "/{id}")
    ResponseEntity<?> getEmployee(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(employeeService.getEmployeeById(id));
        } catch (DataNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping
    ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    ResponseEntity<Employee> createEmployee(@RequestBody Employee newEmployee) {
        employeeService.createEmployee(newEmployee);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
    }

    @PutMapping(path = "/{id}")
    ResponseEntity<?> editEmployee(@PathVariable Integer id,
                                        @RequestBody Employee editedEmployee) {
        editedEmployee.setId(id);
        try {
            employeeService.updateEmployee(id, editedEmployee);
            return ResponseEntity.ok(editedEmployee);
        } catch (DataNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
