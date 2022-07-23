package com.example.studentspringboot.repository;

import com.example.studentspringboot.model.TblStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<TblStudent,Long> {

     Optional<TblStudent> findByStudentname(String name);
     Optional<TblStudent> findByEmail(String email);
     Optional<TblStudent> findByPhone(String phone);
     Optional<TblStudent> findByStudentcode(String studentcode);



}
