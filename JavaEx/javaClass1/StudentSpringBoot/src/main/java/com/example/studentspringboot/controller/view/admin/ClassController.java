package com.example.studentspringboot.controller.view.admin;

import com.example.studentspringboot.model.TblClass;
import com.example.studentspringboot.service.ClassServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClassController {
    @Autowired
    ClassServiceImp classService;

    @GetMapping("class/list")
    public String getAllClass(Model model){
        List<TblClass> classList = classService.getAllClass();
        model.addAttribute("classList",classList);
        return "class";
    }

    @GetMapping("/addClass")
    public String addClass(Model model){
        TblClass newClass = new TblClass();
        model.addAttribute("class",classService.saveClass(newClass));
        return "addAndUpdateClass";
    }

    @PostMapping("saveClass")
    public String saveClass(@ModelAttribute TblClass tblClass){
        classService.saveClass(tblClass);
        return "redirect:/class/list";
    }

    @GetMapping ("classUpdate")
    public String classUpdate(Model model,@RequestParam Long classId){
        TblClass tblClass =  classService.getClassById(classId).get();
        model.addAttribute("class",tblClass);
        return "addAndUpdateClass";
    }
    @GetMapping("deleteClass")
    public String deleteClass(@RequestParam Long classId){
        classService.deleteClass(classId);
        return "redirect:/class/list";
    }

}
