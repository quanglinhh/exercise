package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.model.Employee;
import com.example.thymeleafdemo.repository.EmployeeRepository;
import com.example.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping({"/list","/"})
    public String getAllEmployees(Model model){
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees",employees);
        return "list_employee";
    }

    @GetMapping("/addEmployeeForm")
    public String addEmployee(Model model){
        Employee newEmployee = new Employee();
        model.addAttribute("employee",employeeService.saveEmployee(newEmployee));
        return "add-employee-form";
    }
    @PostMapping("saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/list";
    }
    @GetMapping("/showUpdateForm")
    public String showUpdateForm(Model model,@RequestParam Long employeeId ){
        Employee employee = employeeRepository.findById(employeeId).get();
        model.addAttribute("employee",employee);
        return "add-employee-form";
    }
    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return "redirect:/list";
    }
}
