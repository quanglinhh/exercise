package com.example.studentspringboot.controller;

import com.example.studentspringboot.model.TblClass;
import com.example.studentspringboot.model.TblMark;
import com.example.studentspringboot.service.MarkServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/marks")
public class MarkController {
    @Autowired
    MarkServiceImp markServiceImp;
    @GetMapping
    public List<TblMark> getAllMark(){
        return markServiceImp.getAllMark();
    }

    @GetMapping("/{id}")
    public Object getMarkById(@PathVariable("id") long id){
        return markServiceImp.getMarkById(id);
    }

    @PostMapping
    public ResponseEntity<TblMark> insertMark(@RequestBody TblMark tblMark){
        markServiceImp.saveMark(tblMark);
        return ResponseEntity.ok(tblMark);
    }
   @PutMapping("/{id}")
    public TblMark updateMark(@PathVariable("id") long id, @RequestBody TblMark markUpdate){
        return markServiceImp.updateMark(markUpdate,id);
   }

    @DeleteMapping("/{id}")
    public Object deleteMark(@PathVariable("id") long id){
        markServiceImp.deleteMark(id);
        return ResponseEntity.ok("Deleted mark id= "+id);
    }


}
