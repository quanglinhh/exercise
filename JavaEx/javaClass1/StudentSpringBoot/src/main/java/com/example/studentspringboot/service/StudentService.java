package com.example.studentspringboot.service;

import com.example.studentspringboot.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudent();
     Student saveStudent(Student student);
    Student updateStudent(Student studentUpdate, int id);
    void deleteStudent(int id);
    Optional<Student> searchStudentById(int id);

    Optional<Student> searchByName(String name);
    Optional<Student> searchByStudentCode(String studentCode);
    Optional<Student> searchByEmail(String email);
    Optional<Student> searchByPhone(String phone);



}
