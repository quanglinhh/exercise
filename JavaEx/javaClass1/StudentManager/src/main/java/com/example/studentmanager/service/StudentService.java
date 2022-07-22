package com.example.studentmanager.service;

import com.example.studentmanager.model.TblstudentEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<TblstudentEntity> getAllStudent();
    TblstudentEntity saveStudent(TblstudentEntity student);
    TblstudentEntity updateStudent(TblstudentEntity studentUpdate, long id);
    void deleteStudent(long id);
    Optional<TblstudentEntity> searchStudentById(long id);

    Optional<TblstudentEntity> searchByName(String name);
    Optional<TblstudentEntity> searchByStudentCode(String studentcode);
    Optional<TblstudentEntity> searchByEmail(String email);
    Optional<TblstudentEntity> searchByPhone(String phone);




}