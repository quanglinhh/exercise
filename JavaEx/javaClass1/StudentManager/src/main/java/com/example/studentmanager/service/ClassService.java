package com.example.studentmanager.service;

import com.example.studentmanager.model.TblclassEntity;

import java.util.List;
import java.util.Optional;

public interface ClassService {
    List<TblclassEntity> getAllClass();
    TblclassEntity saveClass(TblclassEntity tblclass);
    TblclassEntity updateClass(TblclassEntity tblclass, Long id);

    void deleteClass(long id);
    TblclassEntity getOne(Long id);
}
