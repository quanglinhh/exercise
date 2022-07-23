package com.example.studentspringboot.repository;

import com.example.studentspringboot.model.TblMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends JpaRepository<TblMark,Long> {

}
