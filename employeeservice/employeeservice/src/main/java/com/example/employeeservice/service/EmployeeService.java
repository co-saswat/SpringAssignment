package com.example.employeeservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepository;

@Service 
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployeesByDeptId(Long deptId) {
        return employeeRepository.findByDeptId(deptId);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setEmpName(updatedEmployee.getEmpName());
            existingEmployee.setEmpEmail(updatedEmployee.getEmpEmail());
            existingEmployee.setEmpSalary(updatedEmployee.getEmpSalary());
            existingEmployee.setDeptId(updatedEmployee.getDeptId());
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
