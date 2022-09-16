package com.example.studentspringboot.service;

import com.example.studentspringboot.model.Users;
import com.example.studentspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void saveUser(Users user) {
        userRepository.save(user);
    }


}
