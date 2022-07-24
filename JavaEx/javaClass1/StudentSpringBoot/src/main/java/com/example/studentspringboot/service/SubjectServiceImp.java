package com.example.studentspringboot.service;

import com.example.studentspringboot.dto.TblSubjectCount;
import com.example.studentspringboot.model.TblSubject;
import com.example.studentspringboot.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubjectServiceImp implements SubjectService{
    @Autowired
    SubjectRepository subjectRepository;
    @Override
    public List<TblSubject> getAllSubject() {
        return subjectRepository.findAll();
    }


    @Override
    public TblSubject saveSubject(TblSubject tblSubject) {
        return subjectRepository.save(tblSubject);
    }

    @Override
    public Optional<TblSubject> findSubjectById(long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public TblSubject updateSubjectById(long id, TblSubject tblSubjectUpdate) {
        if(subjectRepository.findById(id).isPresent()){
            Optional<TblSubject> subject = subjectRepository.findById(id);
            tblSubjectUpdate.setId(id);
            subject.stream().map(sb->{sb.setName(tblSubjectUpdate.getName());
                sb.setDescription(tblSubjectUpdate.getDescription());
                sb.setDuration(tblSubjectUpdate.getDuration());
                sb.setDescription(tblSubjectUpdate.getDescription());
                sb.setSem(tblSubjectUpdate.getSem());
                return sb;});
        }
        return subjectRepository.save(tblSubjectUpdate);
    }

    @Override
    public void deleteSubjectById(long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Optional<TblSubject> findSubjectByName() {
        return Optional.empty();
    }

    @Override
    public List<TblSubject> findSubjectBySem(int sem) {
        return subjectRepository.findAllBySem(sem);
    }



    @Override
    public int sumOfSubjectBySem(int sem) {
        return subjectRepository.countBySem(sem);
    }

    @Override
    public List<TblSubject> findAllBy(String field, String orderByType) {
        if(Objects.equals(field, "name")){
            if(Objects.equals(orderByType, "asc")){
                return subjectRepository.findAllByOrderByNameAsc();
            }else if(Objects.equals(orderByType, "desc")){
                return subjectRepository.findAllByOrderByIdDesc();
            }
        }else if(Objects.equals(field, "sem")){
            if(Objects.equals(orderByType, "asc")){
                return subjectRepository.findAllByOrderBySemAsc();
            }else if(Objects.equals(orderByType, "desc")){
                return subjectRepository.findAllByOrderBySemDesc();
            }
        }else if(Objects.equals(field, "id")){
            if(Objects.equals(orderByType,"asc")){
                return subjectRepository.findAllByOrderByIdAsc();
            }else if(Objects.equals(orderByType, "desc")){
                return subjectRepository.findAllByOrderByIdDesc();
            }
        }
        return null;
    }

    @Override
    public List<TblSubjectCount> countByAllSem() {
        return subjectRepository.countByAllSem();
    }


}
