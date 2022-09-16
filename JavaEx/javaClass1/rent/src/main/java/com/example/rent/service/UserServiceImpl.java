package com.example.rent.service;

import com.example.rent.model.Users;
import com.example.rent.repository.ContractRepository;
import com.example.rent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    ContractRepository contractRepository;

    @Override
    public List<Users> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<Users> getUserById(Long id) {
        if(userRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Users users = userRepository.findById(id).get();
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<Users>  updateUserById(Long id, Users users) {
        if(userRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        users.setId(id);
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<Users> deleteUserById(Long id) {
        if(userRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public Users saveUser(Users users) {
        return userRepository.save(users);
    }

    @Override
    public Boolean existsByEmail(String email) {
         return userRepository.existsByEmail(email);
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<Users> findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<Long> getListUserIdSortByContractAmount() {
        //Get All User
        List<Users> users = userRepository.findAll();
        //Put userId + AmountOfContract to hashMap
        HashMap<Long,Long> userContracts = new HashMap<>();
        users.forEach(u->{
            Long amountContract = contractRepository.getAmountContractByUser(u.getId());
            userContracts.put(u.getId(),amountContract);
        });
        //Sort Hashmap ByAmountOfContract
        userContracts.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
        List<Long> userIds = new ArrayList<>();
        userContracts.forEach((k,v)->{
           userIds.add(k);
        });
        return userIds;

    }


}
