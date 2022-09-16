package com.example.studentspringboot.controller;

import com.example.studentspringboot.model.UserRoles;
import com.example.studentspringboot.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/userroles")
public class UserRoleController {
    @Autowired
    UserRoleService userRoleService;

    @GetMapping("/{id}")
    public ArrayList<Integer> getSubjectById(@PathVariable("id") Integer id){

        return userRoleService.findByRoleId(id);
    }
}
