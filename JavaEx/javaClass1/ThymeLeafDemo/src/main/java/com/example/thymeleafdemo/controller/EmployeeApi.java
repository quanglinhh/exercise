package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.controller.dto.ListEmployee;
import com.example.thymeleafdemo.model.Employee;
import com.example.thymeleafdemo.service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApi {
    @Autowired
    EmployeeServiceImp employeeService;

    @GetMapping()
    public ResponseEntity<ListEmployee> listUser(){
        List<Employee> listEmployee = employeeService.getAllEmployee();
        ListEmployee ls = new ListEmployee();
        ls.setData(listEmployee);
        return new ResponseEntity<>(ls, HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<Employee> insertSubject(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    @GetMapping("/{id}")
    public Object getEmployeeById(@PathVariable("id") Long id){
        Optional<Employee> employee = employeeService.searchEmployeeById(id);
        if(employee.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(employee);
    }
    @PutMapping("/{id}")
    public Employee updateSubject(@PathVariable("id") long id, @RequestBody Employee employee){
        return (employeeService.updateEmployee(employee,id));
    }

    @DeleteMapping("/{id}")
    public Object deleteSubject(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Deleted subject with id = "+ id);
    }

}
