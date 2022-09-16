package com.example.rent.repository;

import com.example.rent.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByEmail(String email);
    Boolean existsByEmail(String email);
    Optional<Users> findByUsername(String username);
    Boolean existsByUsername(String username);


}
