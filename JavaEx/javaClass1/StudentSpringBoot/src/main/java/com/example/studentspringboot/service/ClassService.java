package com.example.studentspringboot.service;

import com.example.studentspringboot.model.TblclassEntity;

import java.util.List;

public interface ClassService {
    List<TblclassEntity> getAllClass();
    TblclassEntity saveClass(TblclassEntity tblclass);
    TblclassEntity updateClass(TblclassEntity tblclass, Long id);

    Object getClassById(long id);
    void deleteClass(long id);
}
