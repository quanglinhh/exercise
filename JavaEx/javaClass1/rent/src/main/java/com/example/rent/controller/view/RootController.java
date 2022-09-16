package com.example.rent.controller.view;

import com.example.rent.model.Users;
import com.example.rent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class RootController {
    @Autowired
    UserService userService;

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
    public void GetId(
            Model model
    ) {
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
        model.addAttribute("currentUserId",u.getId());
        model.addAttribute("name", u.getFullname());

        System.out.println(u.getId());
    }


    @GetMapping("rooms")
    public String room(
            Model model
    ) {
        GetId(model);
        return "rooms/rooms";
    }


    @GetMapping("/about")
    public String blogSingle(Model model) {
        Long id = getcurrentUserId();
        model.addAttribute("currentUserId",id);
        Users currentUser = userService.getUserById(id).getBody();
        model.addAttribute("currentUser",currentUser);
        return "homes/about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        Long id = getcurrentUserId();
        model.addAttribute("currentUserId",id);
        Users currentUser = userService.getUserById(id).getBody();
        model.addAttribute("currentUser",currentUser);
        return "homes/contact";
    }

}
