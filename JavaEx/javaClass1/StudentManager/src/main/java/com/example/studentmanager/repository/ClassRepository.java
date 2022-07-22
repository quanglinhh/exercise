package com.example.studentmanager.repository;

import com.example.studentmanager.model.TblclassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<TblclassEntity,Long> {
    Optional<TblclassEntity> findByName(String name);
}
