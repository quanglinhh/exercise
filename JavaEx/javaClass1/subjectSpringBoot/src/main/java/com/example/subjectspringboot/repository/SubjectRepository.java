package com.example.subjectspringboot.repository;

import com.example.subjectspringboot.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    List<Subject> findAllByName(String name);
    public List<Subject> findAllByOrderByIdAsc();
    public List<Subject> findAllByOrderByIdDesc();

    List<Subject> findAllByOrderByNameAsc();
    List<Subject> findAllByOrderByNameDesc();
    List<Subject> findAllByOrderBySemAsc();
    List<Subject> findAllByOrderBySemDesc();

    int countBySem(int sem);
    List<Subject> findAllBySem(int sem);
}
