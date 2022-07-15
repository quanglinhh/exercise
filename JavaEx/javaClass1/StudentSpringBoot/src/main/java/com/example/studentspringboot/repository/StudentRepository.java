package com.example.studentspringboot.repository;

import com.example.studentspringboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

     Optional<Student> findByStudentName(String name);
     Optional<Student> findByEmail(String email);
     Optional<Student> findByPhone(String phone);
     Optional<Student> findByStudentCode(String studentCode);



}
