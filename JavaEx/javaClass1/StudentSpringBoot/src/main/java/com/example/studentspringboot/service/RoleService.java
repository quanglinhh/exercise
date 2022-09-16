package com.example.studentspringboot.service;

import com.example.studentspringboot.model.Roles;

import java.util.Optional;

public interface RoleService {
    Optional<Roles> findByName(String name);
}
