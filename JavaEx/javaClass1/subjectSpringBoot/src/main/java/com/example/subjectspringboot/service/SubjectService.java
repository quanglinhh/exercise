package com.example.subjectspringboot.service;

import com.example.subjectspringboot.model.Subject;
import com.example.subjectspringboot.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> getAllSubject();

    Subject saveSubject(Subject subject);

    Optional<Subject> findSubjectById(long id);

    Subject updateSubjectById(long id, Subject subject);

    void deleteSubjectById(long id);
    Optional<Subject> findSubjectByName();
    List<Subject> findSubjectBySem();
    int sumOfSubject();
    int sumOfSubjectBySem();

    List<Subject> findAllBy(String field, String orderByType);
}
