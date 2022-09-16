package com.example.studentspringboot.service;

import com.example.studentspringboot.model.Users;
import org.springframework.security.core.userdetails.User;

public interface UserServices {
    boolean existsByUsername(String username);
    void saveUser(Users user);
}
