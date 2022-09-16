package com.example.studentspringboot.controller.view;

import com.example.studentspringboot.common.Constaints;
import com.example.studentspringboot.controller.payload.RegisterUser;
import com.example.studentspringboot.model.Roles;
import com.example.studentspringboot.model.Users;
import com.example.studentspringboot.repository.UserRepository;
import com.example.studentspringboot.service.RoleService;
import com.example.studentspringboot.service.RoleServiceImpl;
import com.example.studentspringboot.service.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    UserServicesImpl userServices;
    @Autowired
    PasswordEncoder passwordEncoder;
    @GetMapping(value = {"/","/index","/home"})
    public String showIndex(){
        return "index";//tên view = tên file html
    }
    @GetMapping("/403")
    public String showPermissionDenied(){
        return "/403";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        return "login";
    }
    @GetMapping("/register")
    public String registerPage(Model model){
        return "register";
    }
    @PostMapping("/registerSubmit")
    public String registersubmit(@ModelAttribute RegisterUser registerUser){
        if(userServices.existsByUsername(registerUser.getUsername())){

        }else{
            Users u = new Users();
            u.setUsername(registerUser.getUsername());
            String password = passwordEncoder.encode(registerUser.getPassword());
            u.setPassword(password);
            Set<Roles> roles = new HashSet<>();
            Roles role = roleService.findByName(Constaints.ROLE_USER).get();
            role.setName("ROLE_USER");
            roles.add(role);
            u.setRoles(roles);
            userServices.saveUser(u);
        }
        return "login";
    }
    @GetMapping("/logoutSuccessful")
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfull";
    }
}
