package com.example.springboot.repository;

import com.example.springboot.model.TblUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TblUserRepository extends JpaRepository<TblUser,Long> {


    public List<TblUser> findAllByOrderByIdAsc();
    public List<TblUser> findAllByOrderByIdDesc();
    public List<TblUser> findAllByOrderByNameAsc();
    public List<TblUser> findAllByOrderByNameDesc();


}
