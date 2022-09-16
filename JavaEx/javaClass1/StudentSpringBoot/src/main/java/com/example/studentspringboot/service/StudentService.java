package com.example.studentspringboot.service;

import com.example.studentspringboot.model.TblStudent;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<TblStudent> getAllStudent();
     TblStudent addStudent(TblStudent student);
     TblStudent saveStudent(TblStudent student);
    TblStudent updateStudent(TblStudent studentUpdate, long id);
    void deleteStudent(long id);
    Optional<TblStudent> searchStudentById(long id);

    Optional<TblStudent> searchByName(String name);
    Optional<TblStudent> searchByStudentCode(String studentcode);
    Optional<TblStudent> searchByEmail(String email);
    Optional<TblStudent> searchByPhone(String phone);





}
