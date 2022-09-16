package com.example.rent.service;

import com.example.rent.model.ContractDemo;
import com.example.rent.model.Users;
import com.example.rent.repository.ContractDemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractDemoServiceImpl implements ContractDemoService{
    @Autowired
    ContractDemoRepository contractDemoRepository;
    @Override
    public List<ContractDemo> findAllByUserId(Long user_id) {
        return contractDemoRepository.findAllByUserId(user_id);
    }

    @Override
    public List<ContractDemo> findAllByOwnderId(Long owner_id) {
        return contractDemoRepository.findAllByOwnderId(owner_id);
    }

    @Override
    public ContractDemo saveContractDemo(ContractDemo contractDemo) {
        return contractDemoRepository.save( contractDemo);
    }

    @Override
    public ContractDemo findById(Long id) {
        return contractDemoRepository.findById(id).get();
    }

    @Override
    public ResponseEntity<ContractDemo> deleteContractDemo(Long id) {
        if(contractDemoRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        contractDemoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
