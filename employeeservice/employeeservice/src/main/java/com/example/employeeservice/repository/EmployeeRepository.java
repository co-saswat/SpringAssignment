package com.example.employeeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeeservice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDeptId(Long deptId);
    
}
