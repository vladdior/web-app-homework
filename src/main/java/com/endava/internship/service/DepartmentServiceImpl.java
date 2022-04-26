package com.endava.internship.service;

import com.endava.internship.domain.Department;
import com.endava.internship.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Integer id) throws DataNotFoundException {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("No department with id=" + id + " found"));
    }

    @Override
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void updateDepartment(Integer id, Department editedDepartment) throws DataNotFoundException {
        Department oldDepartment = departmentRepository.findById(editedDepartment.getId())
                .orElseThrow(() -> new DataNotFoundException("No department with id=" + id + " found"));

        oldDepartment.setLocation(editedDepartment.getLocation());
        oldDepartment.setName(editedDepartment.getName());

        departmentRepository.save(oldDepartment);
    }
}
