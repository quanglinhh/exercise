package com.example.studentspringboot.controller.view;

import com.example.studentspringboot.service.TblUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserAdminController {
    @Autowired
    TblUserService userService;

    @GetMapping(value = {"/admin/user"})
    public String showUserList(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "admin_user";
    }
}
