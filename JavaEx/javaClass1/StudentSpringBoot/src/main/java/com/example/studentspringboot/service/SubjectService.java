package com.example.studentspringboot.service;

import com.example.studentspringboot.dto.TblSubjectCount;
import com.example.studentspringboot.model.TblSubject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<TblSubject> getAllSubject();

    TblSubject saveSubject(TblSubject tblSubject);

    Optional<TblSubject> findSubjectById(long id);

    TblSubject updateSubjectById(long id, TblSubject tblSubject);

    void deleteSubjectById(long id);
    Optional<TblSubject> findSubjectByName();
    List<TblSubject> findSubjectBySem(int sem);

    int sumOfSubjectBySem(int sem);

    List<TblSubject> findAllBy(String field, String orderByType);

    List<TblSubjectCount> countByAllSem();


}
