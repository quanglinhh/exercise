package com.example.rent.controller.view.admin;

import com.example.rent.model.Room;
import com.example.rent.model.Users;
import com.example.rent.service.RoomServiceImpl;
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
public class PostAdminController {
    @Autowired
    RoomServiceImpl roomService;
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
    @GetMapping("/admin/list/room")
    public String getAllPost(Model model){
        List<Room> rooms = roomService.getAllRoom();
        model.addAttribute("rooms",rooms);
        Long id = getcurrentUserId();
        model.addAttribute("currentUserId",id);
        return "admin/listPost";
    }

}
