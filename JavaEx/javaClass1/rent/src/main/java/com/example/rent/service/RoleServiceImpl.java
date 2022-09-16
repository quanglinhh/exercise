package com.example.rent.service;

import com.example.rent.model.Roles;
import com.example.rent.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Optional<Roles> findByName(String name) {
        return roleRepository.findByName(name);
    }
}
