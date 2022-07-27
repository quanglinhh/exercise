package com.example.thymeleafdemo.service;

import com.example.thymeleafdemo.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Employee employeeUpdate, long id);
    void deleteEmployee(long id);
    Optional<Employee> searchEmployeeById(long id);
    Optional<Employee> searchEmployeeByName(String name);

}
