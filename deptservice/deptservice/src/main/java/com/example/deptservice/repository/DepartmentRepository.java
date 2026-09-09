package com.example.deptservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.deptservice.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
}
