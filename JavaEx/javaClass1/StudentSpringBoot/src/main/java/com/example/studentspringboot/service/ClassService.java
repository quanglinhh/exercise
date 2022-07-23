package com.example.studentspringboot.service;

import com.example.studentspringboot.model.TblClass;

import java.util.List;

public interface ClassService {
    List<TblClass> getAllClass();
    void saveClass(TblClass tblclass);
    TblClass updateClass(TblClass tblclass, Long id);

    Object getClassById(long id);
    void deleteClass(long id);
}
