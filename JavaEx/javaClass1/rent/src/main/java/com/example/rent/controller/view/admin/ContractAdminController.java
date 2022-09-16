package com.example.rent.controller.view.admin;

import com.example.rent.model.Contract;
import com.example.rent.model.Users;
import com.example.rent.service.ContractServiceImpl;
import com.example.rent.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ContractAdminController {
    @Autowired
    ContractServiceImpl contractService;
    @Autowired
    UserServiceImpl userService;
    public Long getcurrentUserId(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();

        } else {
            username = principal.toString();
        }
        Optional<Users> opUsert = userService.findByUserName(username);
        Users u;
        if(opUsert.isPresent()) {
            u = opUsert.get();
        } else {
            u = new Users();
        }
        Long currentUserId = u.getId();
        return currentUserId;
    }
    @GetMapping("admin/list/contract")
    public String getAllContract(Model model){
        List<Contract> contracts = contractService.getAllContract();
        model.addAttribute("contracts",contracts);
        Long id = getcurrentUserId();
        model.addAttribute("currentUserId",id);
        return"admin/listContract";
    }
}
