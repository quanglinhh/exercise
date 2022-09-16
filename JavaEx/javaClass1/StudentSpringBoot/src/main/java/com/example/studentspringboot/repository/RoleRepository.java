package com.example.studentspringboot.repository;

import com.example.studentspringboot.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Roles,Long> {

    Optional<Roles> findByName(String name);


}
