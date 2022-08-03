package com.example.studentspringboot.service;

import com.example.studentspringboot.model.TblUser;

import java.util.List;
import java.util.Optional;

public interface TblUserService {
    List<TblUser> getAllUser();

    TblUser saveUser(TblUser user);

    void deleteUser(Long id);

    Optional<TblUser> findUserById(Long id);

    public TblUser getOne(Long id);
}
