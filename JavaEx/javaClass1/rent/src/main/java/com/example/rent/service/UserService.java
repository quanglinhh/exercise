package com.example.rent.service;

import com.example.rent.model.Users;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<Users> getAllUser();
    ResponseEntity<Users> getUserById(Long id);
    ResponseEntity<Users> updateUserById(Long id, Users users);
    ResponseEntity<Users> deleteUserById(Long id);
    Users saveUser(Users users);
    Boolean existsByEmail(String email);
    Optional<Users> findByEmail(String email);
    Optional<Users> findByUserName(String username);

    List<Long> getListUserIdSortByContractAmount();
}
