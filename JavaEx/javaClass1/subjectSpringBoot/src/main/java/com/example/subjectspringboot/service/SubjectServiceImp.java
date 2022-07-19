package com.example.subjectspringboot.service;

import com.example.subjectspringboot.model.Subject;
import com.example.subjectspringboot.repository.SubjectRepository;
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
    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject saveSubject(Subject subject) {
       return subjectRepository.save(subject);
    }

    @Override
    public Optional<Subject> findSubjectById(long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public Subject updateSubjectById(long id, Subject subjectUpdate) {
        if(subjectRepository.findById(id).isPresent()){
            Optional<Subject> subject = subjectRepository.findById(id);
            subjectUpdate.setId(id);
            subject.stream().map(sb->{sb.setName(subjectUpdate.getName());
                                      sb.setDescription(subjectUpdate.getDescription());
                                      sb.setDuration(subjectUpdate.getDuration());
                                      sb.setDescription(subjectUpdate.getDescription());
                                      sb.setSem(subjectUpdate.getSem());
                                      return sb;});
        }
        return subjectRepository.save(subjectUpdate);
    }

    @Override
    public void deleteSubjectById(long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Optional<Subject> findSubjectByName() {
        return Optional.empty();
    }

    @Override
    public List<Subject> findSubjectBySem(int sem) {
        return subjectRepository.findAllBySem(sem);
    }



    @Override
    public int sumOfSubjectBySem(int sem) {
        return subjectRepository.countBySem(sem);
    }

    @Override
    public List<Subject> findAllBy(String field, String orderByType) {
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



}
