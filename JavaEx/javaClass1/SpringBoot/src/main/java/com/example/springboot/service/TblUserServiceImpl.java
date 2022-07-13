package com.example.springboot.service;

import com.example.springboot.model.TblUser;
import com.example.springboot.repository.TblUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TblUserServiceImpl implements TblUserService{
    @Autowired
    private TblUserRepository tblUserRepository;
    @Override
    public List<TblUser> getAllUser() {
        return tblUserRepository.findAllByOrderByIdDesc();
    }

    @Override
    public void saveUser(TblUser user) {
        tblUserRepository.save(user);
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
