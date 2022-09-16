package com.example.studentspringboot.service;

import com.example.studentspringboot.model.UserRoles;
import com.example.studentspringboot.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    public ArrayList<Integer> findByRoleId(Integer roleId){
        List<UserRoles> userRoles = userRoleRepository.findAllByRoleId(roleId);
        ArrayList<Integer> userId = new ArrayList<>();
        for (UserRoles ur: userRoles) {
            userId.add(ur.getUserId());
        }
        return userId;
    }

}
