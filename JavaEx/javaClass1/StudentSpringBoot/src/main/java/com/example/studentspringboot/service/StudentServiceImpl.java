package com.example.studentspringboot.service;

import com.example.studentspringboot.model.TblStudent;
import com.example.studentspringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<TblStudent> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public TblStudent addStudent(TblStudent student) {
        //Check Tồn tại studentCode, email, phone
        Optional<TblStudent> studentCheckStudentCode = studentRepository.findByStudentcode(student.getStudentcode());
        Optional<TblStudent> studentCheckEmail = studentRepository.findByEmail(student.getEmail());
        Optional<TblStudent> studentCheckPhone = studentRepository.findByPhone(student.getPhone());
        if(studentCheckStudentCode.isPresent()||studentCheckPhone.isPresent()||studentCheckEmail.isPresent()){
            return (TblStudent) ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED);
        }else{
            return studentRepository.save(student);
        }
    }

    @Override
    public TblStudent saveStudent(TblStudent student) {
        return studentRepository.save(student);
    }

    @Override
    public TblStudent updateStudent(TblStudent studentUpdate, long id) {
        if(studentRepository.findById(id).isPresent()){
            studentUpdate.setId(id);
        }
        return studentRepository.save(studentUpdate);

    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<TblStudent> searchStudentById(long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Optional<TblStudent> searchByName(String name) {
        return studentRepository.findByStudentname(name);
    }

    @Override
    public Optional<TblStudent> searchByStudentCode(String studentcode) {
        return studentRepository.findByStudentcode(studentcode);

    }

    @Override
    public Optional<TblStudent> searchByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Optional<TblStudent> searchByPhone(String phone) {
        return studentRepository.findByPhone(phone);
    }

}
