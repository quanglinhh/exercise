package com.example.studentspringboot.repository;

import com.example.studentspringboot.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);


    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
