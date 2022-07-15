package com.example.studentspringboot.controller;

import com.example.studentspringboot.model.Student;
import com.example.studentspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Students")
public class Controller {
    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
         List<Student> students=studentService.getAllStudent();
        if(students.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent( @RequestBody Student student){
        studentService.saveStudent(student);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{id}")
    public Object searchStudentById(@PathVariable("id") int id){
        Optional<Student> student = studentService.searchStudentById(id);
        System.out.println(student);
        if(student.isEmpty()){
            return ResponseEntity.notFound();
        }
        return ResponseEntity.ok(student);

    }

    @GetMapping("/studentcode={studentCode}")
    public Object searchStudentByStudentCode(@PathVariable("studentCode") String studentCode){
        Optional<Student> student = studentService.searchByStudentCode(studentCode);
        if(student.isEmpty()){
            return ResponseEntity.notFound();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping("/email={studentEmail}")
    public Object searchStudentByStudentEmail(@PathVariable("studentEmail") String studentEmail){
        Optional<Student> student = studentService.searchByEmail(studentEmail);
        if(student.isEmpty()){
            return ResponseEntity.notFound();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping("/phone={phone}")
    public Object searchStudentByPhone(@PathVariable("phone") String phone){
        Optional<Student> student = studentService.searchByPhone(phone);
        if(student.isEmpty()){
            return ResponseEntity.notFound();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("id") int id, @RequestBody Student studentUpdate){
        Student student = studentService.updateStudent(studentUpdate,id);
        return student;
    }

    @DeleteMapping("/{id}")
    public Object deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Delete student id = "+id);
    }


}
