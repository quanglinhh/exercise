package com.example.studentspringboot.service;

import com.example.studentspringboot.model.TblClass;
import com.example.studentspringboot.model.TblMark;


import java.util.List;
import java.util.Optional;

public interface MarkService {
    List<TblMark> getAllMark();

    TblMark saveMark(TblMark mark);
    TblMark updateMark(TblMark mark, Long id);

    Optional<TblMark> getMarkById(long id);
    void deleteMark(long id);
}
