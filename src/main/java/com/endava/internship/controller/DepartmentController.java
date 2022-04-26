package com.endava.internship.controller;

import com.endava.internship.domain.Department;
import com.endava.internship.domain.Employee;
import com.endava.internship.repository.DepartmentRepository;
import com.endava.internship.service.DataNotFoundException;
import com.endava.internship.service.DepartmentService;
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
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping(path = "/{id}")
    ResponseEntity<?> getDepartment(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(departmentService.getDepartmentById(id));
        } catch (DataNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping
    ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping
    ResponseEntity<Department> createDepartment(@RequestBody Department newDepartment) {
        departmentService.createDepartment(newDepartment);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDepartment);
    }

    @PutMapping(path = "/{id}")
    ResponseEntity<?> editDepartment(@PathVariable Integer id,
                                     @RequestBody Department editedDepartment) {
        editedDepartment.setId(id);
        try {
            departmentService.updateDepartment(id, editedDepartment);
            return ResponseEntity.ok(editedDepartment);
        } catch (DataNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
