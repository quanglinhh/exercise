package com.example.studentmanager.controller;

import com.example.studentmanager.model.TblclassEntity;
import com.example.studentmanager.model.TblstudentEntity;
import com.example.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<TblstudentEntity>> getAllStudent(){
        List<TblstudentEntity> students=studentService.getAllStudent();
        if(students.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<TblstudentEntity>>(students,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TblstudentEntity> saveStudent( @RequestBody TblstudentEntity student){
        studentService.saveStudent(student);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{id}")
    public Object searchStudentById(@PathVariable("id") int id){
        Optional<TblstudentEntity> student = studentService.searchStudentById(id);
        if(student.isEmpty()){
            return ResponseEntity.notFound();
        }
        return ResponseEntity.ok(student);

    }

    @GetMapping("/studentcode={studentcode}")
    public Object searchStudentByStudentCode(@PathVariable("studentcode") String studentcode){
        Optional<TblstudentEntity> student = studentService.searchByStudentCode(studentcode);
        if(student.isEmpty()){
            return ResponseEntity.notFound();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping("/email={studentEmail}")
    public Object searchStudentByStudentEmail(@PathVariable("studentEmail") String studentEmail){
        Optional<TblstudentEntity> student = studentService.searchByEmail(studentEmail);
        if(student.isEmpty()){
            return ResponseEntity.notFound();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping("/phone={phone}")
    public Object searchStudentByPhone(@PathVariable("phone") String phone){
        Optional<TblstudentEntity> student = studentService.searchByPhone(phone);
        if(student.isEmpty()){
            return ResponseEntity.notFound();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public TblstudentEntity updateStudent(@PathVariable("id") int id, @RequestBody TblstudentEntity studentUpdate){
        TblstudentEntity student = studentService.updateStudent(studentUpdate,id);
        return student;
    }

    @DeleteMapping("/{id}")
    public Object deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Delete student id = "+id);
    }



}

