package com.example.rent.repository;

import com.example.rent.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Roles,Integer> {
    Optional<Roles> findByName(String name);
}
