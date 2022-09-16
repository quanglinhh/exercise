package com.example.rent.repository;

import com.example.rent.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface StatusRepository extends JpaRepository<Status,Integer> {
}
