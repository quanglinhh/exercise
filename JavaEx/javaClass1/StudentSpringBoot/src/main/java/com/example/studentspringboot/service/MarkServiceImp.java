package com.example.studentspringboot.service;

import com.example.studentspringboot.model.TblClass;
import com.example.studentspringboot.model.TblMark;
import com.example.studentspringboot.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MarkServiceImp implements MarkService{
    @Autowired
    MarkRepository markRepository;

    @Override
    public List<TblMark> getAllMark() {
        return markRepository.findAll();
    }

    @Override
    public TblMark saveMark(TblMark mark) {
        return markRepository.save(mark);
    }


    @Override
    public TblMark updateMark(TblMark markUpdate, Long id) {
        markUpdate.setId(id);
        return markUpdate;
    }

    @Override
    public Optional<TblMark> getMarkById(long id) {
        return markRepository.findById(id);
    }

    @Override
    public void deleteMark(long id) {
        markRepository.deleteById(id);
    }
}
