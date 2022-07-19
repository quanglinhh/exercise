package com.example.subjectspringboot.repository;

import com.example.subjectspringboot.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    List<Subject> findAllByName();
    public List<Subject> findAllByOrderByIdAsc();
    public List<Subject> findAllByOrderByIdDesc();
    List<Subject> findBySem();
    List<Subject> findAllByOrderByNameAsc();
    List<Subject> findAllByOrderByNameDesc();
    List<Subject> findAllByOrderBySemAsc();
    List<Subject> findAllByOrderBySemDesc();
    int countAll();
    int countBySem();
}
