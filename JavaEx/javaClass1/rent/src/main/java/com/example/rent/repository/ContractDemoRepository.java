package com.example.rent.repository;

import com.example.rent.model.ContractDemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDemoRepository extends JpaRepository<ContractDemo,Long> {
    List<ContractDemo> findAllByUserId(Long user_id);
    @Query(value = "select c from ContractDemo c where c.ownderId = ?1")
    List<ContractDemo> findAllByOwnderId(Long owner_id);
}
