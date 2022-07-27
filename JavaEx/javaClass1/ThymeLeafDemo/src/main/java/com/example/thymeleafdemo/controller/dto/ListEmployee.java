package com.example.thymeleafdemo.controller.dto;

import com.example.thymeleafdemo.model.Employee;

import java.util.List;

public class ListEmployee {
    private List<Employee> data;

    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }
}
