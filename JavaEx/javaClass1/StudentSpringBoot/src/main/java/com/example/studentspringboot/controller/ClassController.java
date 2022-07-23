package com.example.studentspringboot.controller;

import com.example.studentspringboot.model.TblclassEntity;
import com.example.studentspringboot.service.ClassServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/class")
public class ClassController {
    @Autowired
    ClassServiceImp classServiceImp;

    @GetMapping
    public List<TblclassEntity> getAllClass(){
        return classServiceImp.getAllClass();
    }

    @PostMapping
    public ResponseEntity<TblclassEntity> insertClass(@RequestBody TblclassEntity tblclass){
        classServiceImp.saveClass(tblclass);
        return ResponseEntity.ok(tblclass);
    }

    @PutMapping("/{id}")
    public TblclassEntity updateClass(@PathVariable("id") long id,@RequestBody TblclassEntity classUpdate){
        return classServiceImp.updateClass(classUpdate,id);
    }
    @GetMapping("/{id}")
    public Object getClassById(@PathVariable("id") long id){
        return classServiceImp.getClassById(id);
    }

    @DeleteMapping("/{id}")
    public Object deleteStudent(@PathVariable("id") long id) {
        classServiceImp.deleteClass(id);
        return ResponseEntity.ok("Delete class id = "+id);
    }
}
