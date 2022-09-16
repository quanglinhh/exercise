package com.example.studentspringboot.controller;

import com.example.studentspringboot.dto.TblSubjectCount;
import com.example.studentspringboot.model.TblSubject;
import com.example.studentspringboot.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/subjects")
public class TblSubjectController {
    @Autowired
    SubjectService service;
    @GetMapping
    public ResponseEntity<List<TblSubject>> getAllSubject(){
        List<TblSubject> subjects = service.getAllSubject();
        if(subjects.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(subjects);
    }
    @GetMapping("/{id}")
    public Object getSubjectById(@PathVariable("id") Long id){
        Optional<TblSubject> subject = service.findSubjectById(id);
        if(subject.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(subject);
    }

    @GetMapping("/field={field}/type={type}")
    public List<TblSubject> getAllSubjectBy(@PathVariable("field") String field, @PathVariable String type){
        return service.findAllBy(field,type);
    }

    @PostMapping
    public ResponseEntity<TblSubject> insertSubject(@RequestBody TblSubject subject){
        return ResponseEntity.ok(service.saveSubject(subject));
    }

    @GetMapping("/countbysem={sem}")
    public int countBySem(@PathVariable("sem") int sem){
        return service.sumOfSubjectBySem(sem);
    }

    @PutMapping("/{id}")
    public TblSubject updateSubject(@PathVariable("id") long id, @RequestBody TblSubject subject){
        return (service.updateSubjectById(id,subject));
    }

    @DeleteMapping("/{id}")
    public Object deleteSubject(@PathVariable("id") long id){
        service.deleteSubjectById(id);
        return ResponseEntity.ok("Deleted subject with id = "+ id);
    }

    @GetMapping("/countbysem")
    public ResponseEntity<List<TblSubjectCount>> countByAllSem(){
        List<TblSubjectCount> subjectCounts = service.countByAllSem();
        return new ResponseEntity<List<TblSubjectCount>>(subjectCounts,HttpStatus.OK);
    }

}
