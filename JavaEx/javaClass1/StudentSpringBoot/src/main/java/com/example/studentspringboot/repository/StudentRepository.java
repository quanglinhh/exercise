package com.example.studentspringboot.repository;

import com.example.studentspringboot.model.TblstudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<TblstudentEntity,Integer> {

     Optional<TblstudentEntity> findByStudentname(String name);
     Optional<TblstudentEntity> findByEmail(String email);
     Optional<TblstudentEntity> findByPhone(String phone);
     Optional<TblstudentEntity> findByStudentcode(String studentcode);



}
