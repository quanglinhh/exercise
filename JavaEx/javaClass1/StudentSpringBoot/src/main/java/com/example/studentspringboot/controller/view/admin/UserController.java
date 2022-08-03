package com.example.studentspringboot.controller.view.admin;

import com.example.studentspringboot.model.TblUser;
import com.example.studentspringboot.service.TblUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    TblUserService userService;

    @GetMapping("/admin/userlist")
    public String showUserList(Model model){
        List<TblUser> lsUser = userService.getAllUser();
        model.addAttribute("lsUser",lsUser);
        return "listUser";
    }
    @GetMapping("/addUser")
    public String addUser(Model model){
        TblUser user = new TblUser();
        user.setEmail("enter email");
        user.setName("new name");
        model.addAttribute("user",userService.saveUser(user));
        return "addUser";
    }
    @PostMapping("saveUser")
    public String saveUser(@ModelAttribute TblUser user){
        userService.saveUser(user);
        return "redirect:/admin/userlist";
    }
    @GetMapping("showUpdateForm")
    public String updateUser(Model model, @RequestParam Long userId){
        TblUser user = userService.findUserById(userId).get();
        model.addAttribute("user",user);
        return "addUser";
    }
    @GetMapping("deleteUser")
    public String deleteUser( @RequestParam Long userId){
        userService.deleteUser(userId);
        return "redirect:/admin/userlist";
    }

}
