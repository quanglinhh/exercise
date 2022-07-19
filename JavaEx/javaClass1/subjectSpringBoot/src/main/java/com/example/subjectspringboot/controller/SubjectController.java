package com.example.subjectspringboot.controller;

import com.example.subjectspringboot.model.Subject;
import com.example.subjectspringboot.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/subjects")
public class SubjectController {
    @Autowired
    SubjectService service;
    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubject(){
        List<Subject> subjects = service.getAllSubject();
        if(subjects.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(subjects);
    }
    @GetMapping("/{id}")
    public Object getSubjectById(@PathVariable("id") Long id){
        Optional<Subject> subject = service.findSubjectById(id);
        if(subject.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(subject);
    }

    @GetMapping("/field={field}/type={type}")
    public List<Subject> getAllSubjectBy(@PathVariable("field") String field, @PathVariable String type){
        return service.findAllBy(field,type);
    }

    @PostMapping
    public ResponseEntity<Subject> insertSubject(@RequestBody Subject subject){
        return ResponseEntity.ok(service.saveSubject(subject));
    }

    @GetMapping("/countbysem={sem}")
    public int countBySem(@PathVariable("sem") int sem){
        return service.sumOfSubjectBySem(sem);
    }

    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable("id") long id, @RequestBody Subject subject){
        return (service.updateSubjectById(id,subject));
    }

    @DeleteMapping("/{id}")
    public Object deleteSubject(@PathVariable("id") long id){
        service.deleteSubjectById(id);
        return ResponseEntity.ok("Deleted subject with id = "+ id);
    }

}

