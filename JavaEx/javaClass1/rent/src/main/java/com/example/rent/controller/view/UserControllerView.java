package com.example.rent.controller.view;

import com.example.rent.model.Room;
import com.example.rent.model.Users;
import com.example.rent.service.RoomServiceImpl;
import com.example.rent.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Controller

public class UserControllerView {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoomServiceImpl roomService;
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
    private final String UPLOAD_DIR = "src/main/resources/static/uploads/";

    public void GetId(Model model) {
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

    @GetMapping("/userInfo")
    public String getUserByUserId(Model model, @RequestParam Long userId){
        Users user = userService.getUserById(userId).getBody();
        model.addAttribute("user",user);
        GetId(model);
        return "user/userInfo";
    }

    @GetMapping ("/updateUser")
    public String updateUser(Model model,@RequestParam Long userId){
        Users user = userService.getUserById(userId).getBody();
        model.addAttribute("user",user);
        return "user/editUser";
    }
    @Transactional
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute  Users users, @RequestParam MultipartFile file){
        Long id = users.getId();
        //add username + password
        Users findUserById = userService.getUserById(id).getBody();


        users.setUsername(findUserById.getUsername());
        users.setPassword(findUserById.getPassword());
        // check if file is empty
        if (file.isEmpty()) {

        }
        // normalize the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        // save the file on the local file system
        try {
            Path path = Paths.get(UPLOAD_DIR);
            //String avatar = path.toString();
            users.setImage(fileName);
            Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // return success response
        userService.saveUser(users);

        return "redirect:/userInfo?userId="+id;
    }
    @GetMapping("/list/user")
    public String getAllUser(Model model){
        List<Users> users = userService.getAllUser();
        model.addAttribute("users",users);
        Long id = getcurrentUserId();
        model.addAttribute("currentUserId",id);
        Users currentUser = userService.getUserById(id).getBody();
        model.addAttribute("currentUser",currentUser);
        return "homes/agents-grid";
    }

    @GetMapping("/agent")
    public String getAgent(Model model, @RequestParam Long userId){
        Users u = userService.getUserById(userId).getBody();
        model.addAttribute("user",u);
        List<Room> rooms = roomService.getRoomsByUserId(userId);
        model.addAttribute("rooms",rooms);
        Long id = getcurrentUserId();
        model.addAttribute("currentUserId",id);
        Users currentUser = userService.getUserById(id).getBody();
        model.addAttribute("currentUser",currentUser);
        return "homes/agent-single";
    }

}
