package com.example.studentspringboot.controller.view.admin;

import com.example.studentspringboot.model.TblClass;
import com.example.studentspringboot.model.TblSubject;
import com.example.studentspringboot.repository.SubjectRepository;
import com.example.studentspringboot.service.ClassServiceImp;
import com.example.studentspringboot.service.SubjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class SubjectController {
    @Autowired
    SubjectServiceImp subjectService;
    @Autowired
    SubjectRepository subjectRepository;
    @GetMapping("subject/list")
    public String getAllClass(Model model){
        List<TblSubject> subjects = subjectService.getAllSubject();
        model.addAttribute("subjects",subjects);
        return "subjects";
    }

    @GetMapping("/addSubject")
    public String addSubject(Model model){
        TblSubject newSubject = new TblSubject();
        model.addAttribute("subject",subjectService.saveSubject(newSubject));
        return "addAndUpdateSubject";
    }

    @PostMapping("saveSubject")
    public String saveSubject(@ModelAttribute TblSubject subject){
        subjectService.saveSubject(subject);
        return "redirect:/subject/list";
    }

    @GetMapping ("subjectUpdate")
    public String subjectUpdate(Model model,@RequestParam Long subjectId){
        TblSubject tblSubject = subjectService.findSubjectById(subjectId).get();
        model.addAttribute("subject",tblSubject);
        return "addAndUpdateSubject";
    }
    @GetMapping("deleteSubject")
    public String deleteSubject(@RequestParam Long subjectId){
        subjectService.deleteSubjectById(subjectId);
        return "redirect:/subject/list";
    }
}
