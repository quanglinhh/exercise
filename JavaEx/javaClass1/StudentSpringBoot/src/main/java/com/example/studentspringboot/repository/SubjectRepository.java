package com.example.studentspringboot.repository;

import com.example.studentspringboot.dto.TblSubjectCount;
import com.example.studentspringboot.model.TblSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<TblSubject,Long> {
    List<TblSubject> findAllByName(String name);
    public List<TblSubject> findAllByOrderByIdAsc();
    public List<TblSubject> findAllByOrderByIdDesc();

    List<TblSubject> findAllByOrderByNameAsc();
    List<TblSubject> findAllByOrderByNameDesc();
    List<TblSubject> findAllByOrderBySemAsc();
    List<TblSubject> findAllByOrderBySemDesc();

    int countBySem(int sem);
    List<TblSubject> findAllBySem(int sem);

    @Query("SELECT new com.example.studentspringboot.dto.TblSubjectCount(s.sem, COUNT(s.name)) FROM TblSubject s GROUP BY s.sem")
    List<TblSubjectCount> countByAllSem();
}
