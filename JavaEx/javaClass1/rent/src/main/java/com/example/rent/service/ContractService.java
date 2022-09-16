package com.example.rent.service;

import com.example.rent.model.Contract;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContractService {
    List<Contract> getAllContract();

    ResponseEntity<Contract> getContractById(Long id);

    ResponseEntity<Contract> updateContractById(Contract contract,Long id);

    ResponseEntity<Contract> deleteContractById(Long id);

    Contract saveContract(Contract contract);

    List<Contract> getAllByUserId(Long userId);
    List<Contract> getAllByOwnerId(Long ownerId);

}
