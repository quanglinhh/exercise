package com.example.rent.service;

import com.example.rent.model.ContractDemo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContractDemoService {
    List<ContractDemo> findAllByUserId(Long user_id);
    List<ContractDemo> findAllByOwnderId(Long owner_id);
    ContractDemo saveContractDemo(ContractDemo contractDemo);
    ContractDemo findById(Long id);
   ResponseEntity<ContractDemo> deleteContractDemo(Long id);
}
