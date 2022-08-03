package com.example.studentspringboot.service;

import com.example.studentspringboot.model.TblUser;
import com.example.studentspringboot.repository.TblUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TblUserServiceImp implements TblUserService{
    @Autowired
    private TblUserRepository tblUserRepository;
    @Override
    public List<TblUser> getAllUser() {
        return tblUserRepository.findAllByOrderByIdDesc();
    }



    @Override
    public TblUser saveUser(TblUser user) {
        tblUserRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        tblUserRepository.deleteById(id);
    }

    @Override
    public Optional<TblUser> findUserById(Long id) {
        return tblUserRepository.findById(id);
    }

    @Override
    public TblUser getOne(Long id) {
        return tblUserRepository.findById(id).get();
    }
}
