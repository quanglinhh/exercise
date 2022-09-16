package com.example.rent.service;

import com.example.rent.model.Contract;
import com.example.rent.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService{
    @Autowired
    ContractRepository contractRepository;

    @Override
    public List<Contract> getAllContract() {
        return contractRepository.findAll();
    }

    @Override
    public ResponseEntity<Contract> getContractById(Long id) {
        if(contractRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Contract contract = contractRepository.findById(id).get();
        return ResponseEntity.ok(contract);
    }

    @Override
    public ResponseEntity<Contract> updateContractById(Contract contract, Long id) {
        if(contractRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        contract.setId(id);
        return ResponseEntity.ok(contract);
    }

    @Override
    public ResponseEntity<Contract> deleteContractById(Long id) {
        if(contractRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        contractRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public Contract saveContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public List<Contract> getAllByUserId(Long userId) {
        List<Long> contractIds = contractRepository.getContactIdByUserId(userId);
        List<Contract> contracts = new ArrayList<>();
        for (Long contractId: contractIds) {
            Contract contract = contractRepository.findById(contractId).get();
            contracts.add(contract);
        }
        return contracts;
    }

    @Override
    public List<Contract> getAllByOwnerId(Long ownerId) {
        List<Long> contractIds = contractRepository.getContactIdByOwnerId(ownerId);
        List<Contract> contracts = new ArrayList<>();
        for (Long contractId: contractIds) {
            Contract contract = contractRepository.findById(contractId).get();
            contracts.add(contract);
        }
        return contracts;
    }



}
