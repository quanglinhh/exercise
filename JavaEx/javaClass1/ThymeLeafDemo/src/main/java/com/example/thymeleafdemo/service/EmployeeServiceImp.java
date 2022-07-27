package com.example.thymeleafdemo.service;

import com.example.thymeleafdemo.model.Employee;
import com.example.thymeleafdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImp implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employeeUpdate, long id) {
        if(employeeRepository.findById(id).isPresent()){
           employeeUpdate.setId(id);
        }
        return employeeUpdate;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> searchEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Optional<Employee> searchEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }
}
