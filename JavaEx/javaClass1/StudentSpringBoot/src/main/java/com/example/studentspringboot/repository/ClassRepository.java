package com.example.studentspringboot.repository;

import com.example.studentspringboot.model.TblClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<TblClass,Long> {
    Optional<TblClass> findByName(String name);


}
