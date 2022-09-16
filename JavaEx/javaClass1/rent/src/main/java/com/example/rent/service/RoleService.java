package com.example.rent.service;

import com.example.rent.model.Roles;

import java.util.Optional;

public interface RoleService {
    Optional<Roles> findByName(String name);
}
