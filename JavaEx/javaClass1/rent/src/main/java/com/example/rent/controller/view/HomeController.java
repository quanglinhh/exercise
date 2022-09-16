package com.example.rent.controller.view;

import com.example.rent.common.Constants;
import com.example.rent.controller.payload.RegisterUser;
import com.example.rent.model.*;
import com.example.rent.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    ImageServiceImpl imageService;
    @Autowired
    RoomServiceImpl roomService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRoleServiceImpl userRoleService;

//    @GetMapping(value = {"/","/index","/home"})
//    public String showIndex(){
//        return "index";//tên view = tên file html
//    }
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

    @GetMapping(value = {"/","/index","/home"})
    public String showIndex(Model model){
        model.addAttribute("currentUserId",getcurrentUserId());
        Users currentUser = userService.getUserById(getcurrentUserId()).getBody();
        model.addAttribute("currentUser",currentUser);
        List<Room> roomsTop3 = roomService.findByTop3();
        model.addAttribute("roomsTop3",roomsTop3);
        List<Room> room4Lastest = roomService.findLastesRoom();
        model.addAttribute("roomTop4Lastest",room4Lastest);
        List<Users> topSheller = new ArrayList<>();
        List<Long> uIdByConTracts = userService.getListUserIdSortByContractAmount();
        for(int i=0 ; i <=2; i++ ){
           Users user = userService.getUserById(uIdByConTracts.get(i)).getBody();
           topSheller.add(user);
        }
        model.addAttribute("topSheller",topSheller);
        return "homes/index";
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
//        Users user = new Users();
//        model.addAttribute("user",user);
        return "register";
    }
    @PostMapping("/registerSubmit")
    public String processRegister(@ModelAttribute RegisterUser registerUser) {
        if (userService.existsByEmail(registerUser.getEmail())) {
        } else {
            Users u = new Users();
            String password = passwordEncoder.encode(registerUser.getPassword());
            u.setEmail(registerUser.getEmail());
            u.setUsername(registerUser.getUsername());
            u.setPassword(password);
            userService.saveUser(u);
            Set<Roles> roles = new HashSet<>();
            Roles role = roleService.findByName(Constants.ROLE_USER).get();
            roles.add(role);
            Collection<UserRole> userRoles = new ArrayList<>();
            roles.forEach(r->{
                UserRole userRole = new UserRole();
                userRole.setUsersByUserId(u);
                userRole.setRolesByRoleId(r);
                userRoleService.saveUserRole(userRole);
                userRoles.add(userRole);
            });

            u.setUserRolesById(userRoles);



        }
        return "login";
    }

}
