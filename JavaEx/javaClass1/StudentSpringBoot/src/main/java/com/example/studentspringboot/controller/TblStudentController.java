package com.example.studentspringboot.controller;

import com.example.studentspringboot.model.TblStudent;
import com.example.studentspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "api/students")
public class TblStudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<TblStudent>> getAllStudent(){
         List<TblStudent> students=studentService.getAllStudent();
        if(students.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<TblStudent>>(students,HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TblStudent> saveStudent(@RequestBody TblStudent student){
        studentService.addStudent(student);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{id}")
    public Object searchStudentById(@PathVariable("id") long id){
        Optional<TblStudent> student = studentService.searchStudentById(id);
        if(student.isEmpty()){
            return ResponseEntity.notFound();
        }
        return ResponseEntity.ok(student);

    }

    @GetMapping("/studentcode={studentcode}")
    public Object searchStudentByStudentCode(@PathVariable("studentcode") String studentcode){
        Optional<TblStudent> student = studentService.searchByStudentCode(studentcode);
        if(student.isEmpty()){
            return ResponseEntity.notFound();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping("/email={studentEmail}")
    public Object searchStudentByStudentEmail(@PathVariable("studentEmail") String studentEmail){
        Optional<TblStudent> student = studentService.searchByEmail(studentEmail);
        if(student.isEmpty()){
            return ResponseEntity.notFound();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping("/phone={phone}")
    public Object searchStudentByPhone(@PathVariable("phone") String phone){
        Optional<TblStudent> student = studentService.searchByPhone(phone);
        if(student.isEmpty()){
            return ResponseEntity.notFound();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public TblStudent updateStudent(@PathVariable("id") int id, @RequestBody TblStudent studentUpdate){
        TblStudent student = studentService.updateStudent(studentUpdate,id);
        return student;
    }

    @DeleteMapping("/{id}")
    public Object deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Delete student id = "+id);
    }


}
