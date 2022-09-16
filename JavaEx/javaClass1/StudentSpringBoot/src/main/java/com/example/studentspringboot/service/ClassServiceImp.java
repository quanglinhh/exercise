package com.example.studentspringboot.service;

import com.example.studentspringboot.model.TblClass;
import com.example.studentspringboot.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImp implements ClassService{
    @Autowired
    ClassRepository classRepository;
    @Override
    public List<TblClass> getAllClass() {
        return classRepository.findAll();
    }

    @Override
    public void addClass(TblClass tblclass) {
        Optional<TblClass> tblClass = classRepository.findByName(tblclass.getName());
        if(tblClass.isPresent()){
            ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED);
            return;
        }
        classRepository.save(tblclass);
    }

    @Override
    public TblClass saveClass(TblClass tblclass) {
       return classRepository.save(tblclass);
    }

    @Override
    public TblClass updateClass(TblClass classUpdate, Long id) {
        if(classRepository.findById(id).isPresent()){
            classUpdate.setId(id);
        }

        return classRepository.save(classUpdate);
    }

    @Override
    public  Optional<TblClass> getClassById(long id) {
        return classRepository.findById(id);

    }

    @Override
    public void deleteClass(long id) {
        classRepository.deleteById(id);
    }
}
