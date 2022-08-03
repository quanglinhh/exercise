package com.example.studentspringboot.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/","/index","/home"})
    public String showIndex(){
        return "index";//tên view = tên file html
    }
    @GetMapping("/403")
    public String showPermissionDenied(){
        return "/403";
    }
}
