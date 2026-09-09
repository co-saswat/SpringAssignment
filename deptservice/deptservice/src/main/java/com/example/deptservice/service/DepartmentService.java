package com.example.deptservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.deptservice.model.Department;
import com.example.deptservice.repository.DepartmentRepository;

@Service 
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department updateDepartment(Long id, Department updatedDepartment) {
        Department existingDepartment = departmentRepository.findById(id).orElse(null);
        if (existingDepartment != null) {
            existingDepartment.setDeptName(updatedDepartment.getDeptName());
            existingDepartment.setDeptLocation(updatedDepartment.getDeptLocation());
            return departmentRepository.save(existingDepartment);
        }
        return null;
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
