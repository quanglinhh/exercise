package com.example.studentspringboot.controller.view.admin;

import com.example.studentspringboot.model.TblStudent;
import com.example.studentspringboot.service.ClassServiceImp;
import com.example.studentspringboot.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class StudentController {
    private final String UPLOAD_DIR = "src/main/resources/static/uploads/";
    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    ClassServiceImp classServiceImp;


    @GetMapping({"/student/list"})
    public String getAllEmployees(Model model){
        List<TblStudent> students = studentService.getAllStudent();
        model.addAttribute("students",students);
        return "students";
    }

    @GetMapping("/addStudent")
    public String addStudent(Model model){
        TblStudent newStudent = new TblStudent();
        model.addAttribute("student",newStudent);
        return "addAndUpdateStudent";
    }
    @PostMapping("saveStudent")
    public String saveStudent(@ModelAttribute  TblStudent student, @RequestParam MultipartFile file){
        // check if file is empty
        if (file.isEmpty()) {
            return "addAndUpdateStudent";
        }
        // normalize the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        // save the file on the local file system
        try {
            Path path = Paths.get(UPLOAD_DIR);
            //String avatar = path.toString();
            student.setAvatar("/uploads/"+fileName);
            Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // return success response
        studentService.saveStudent(student);
        return "redirect:/student/list";
    }

    @GetMapping ("studentUpdate")
    public String studentUpdate(Model model,@RequestParam Long studentId){
        TblStudent student = studentService.searchStudentById(studentId).get();
        model.addAttribute("student",student);
        return "addAndUpdateStudent";
    }
    @GetMapping("deleteStudent")
    public String deleteStudent(@RequestParam Long studentId){
        studentService.deleteStudent(studentId);
        return "redirect:/student/list";
    }

}
