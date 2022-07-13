package com.example.springboot.service;

import com.example.springboot.model.TblUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TblUserService {
    List<TblUser> getAllUser();

    void saveUser(TblUser user);

    void deleteUser(Long id);

    Optional<TblUser> findUserById(Long id);

    public TblUser getOne(Long id);
}
