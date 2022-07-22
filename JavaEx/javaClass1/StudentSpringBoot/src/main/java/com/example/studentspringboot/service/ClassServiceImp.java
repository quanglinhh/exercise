package com.example.studentspringboot.service;

import com.example.studentspringboot.model.TblclassEntity;
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
    public List<TblclassEntity> getAllClass() {
        return classRepository.findAll();
    }

    @Override
    public TblclassEntity saveClass(TblclassEntity tblclass) {
        Optional<TblclassEntity> tblClass = classRepository.findByName(tblclass.getName());
        if(tblClass.isPresent()){
            return (TblclassEntity) ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED);
        }
        return classRepository.save(tblclass);
    }

    @Override
    public TblclassEntity updateClass(TblclassEntity classUpdate, Long id) {
        Optional<TblclassEntity> tblclass = classRepository.findById(id);
        classUpdate.setId(id);
        tblclass.stream().map(cl->{cl.setName(classUpdate.getName());
                                   cl.setNote(classUpdate.getNote());
                                   return cl;});
        return classRepository.save(classUpdate);
    }

    @Override
    public void deleteClass(long id) {
        classRepository.deleteById(id);
    }
}
