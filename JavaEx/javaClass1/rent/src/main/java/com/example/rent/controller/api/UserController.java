package com.example.rent.controller.api;

import com.example.rent.model.Users;
import com.example.rent.repository.UserRepository;
import com.example.rent.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserServiceImpl userService;



    @GetMapping("/{email}")
    public Optional<Users> findByEmail(@PathVariable("email")String email){
        return userService.findByEmail(email);
    }
    @Autowired
    UserRepository userRepository;
    @GetMapping("user/{id}")
    public Users getUserById(@PathVariable("id") long id){

        return userService.getUserById(id).getBody();
    }

    @GetMapping("/topSheller")
    public List<Long> getTopSheller(){
        return userService.getListUserIdSortByContractAmount();
    }

}

