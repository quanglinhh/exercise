package com.example.studentspringboot.service;

import com.example.studentspringboot.model.TblClass;

import java.util.List;
import java.util.Optional;

public interface ClassService {
    List<TblClass> getAllClass();
    void addClass(TblClass tblclass);
    TblClass saveClass(TblClass tblclass);
    TblClass updateClass(TblClass tblclass, Long id);

    Optional<TblClass> getClassById(long id);
    void deleteClass(long id);
}
