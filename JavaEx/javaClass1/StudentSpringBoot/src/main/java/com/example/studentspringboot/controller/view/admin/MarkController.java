package com.example.studentspringboot.controller.view.admin;

import com.example.studentspringboot.model.TblMark;
import com.example.studentspringboot.service.MarkServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MarkController {
    @Autowired
    MarkServiceImp markService;

    @GetMapping("mark/list")
    public String getAllMark(Model model){
        List<TblMark> marks = markService.getAllMark();
        model.addAttribute("marks",marks);
        return "marks";
    }

    @GetMapping("/addMark")
    public String addMark(Model model){
        TblMark newMark = new TblMark();
        model.addAttribute("mark",markService.saveMark(newMark));
        return "addAndUpdateMark";
    }

    @PostMapping("saveMark")
    public String saveMark(@ModelAttribute TblMark mark){
        markService.saveMark(mark);
        return "redirect:/mark/list";
    }

    @GetMapping ("markUpdate")
    public String markUpdate(Model model,@RequestParam Long markId){
        TblMark tblMark = markService.getMarkById(markId).get();
        model.addAttribute("mark",tblMark);
        return "addAndUpdateMark";
    }
    @GetMapping("deleteMark")
    public String deleteClass(@RequestParam Long markId){
        markService.deleteMark(markId);
        return "redirect:/mark/list";
    }
}
