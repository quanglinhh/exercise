package com.example.studentspringboot.service;

import com.example.studentspringboot.model.TblstudentEntity;
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
    public List<TblstudentEntity> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public TblstudentEntity saveStudent(TblstudentEntity student) {
        //Check Tồn tại studentCode, email, phone
        Optional<TblstudentEntity> studentCheckStudentCode = studentRepository.findByStudentcode(student.getStudentcode());
        Optional<TblstudentEntity> studentCheckEmail = studentRepository.findByEmail(student.getEmail());
        Optional<TblstudentEntity> studentCheckPhone = studentRepository.findByPhone(student.getPhone());
        System.out.println(studentCheckPhone);
        if(studentCheckStudentCode.isPresent()||studentCheckPhone.isPresent()||studentCheckEmail.isPresent()){
            return (TblstudentEntity) ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED);
        }else{
            return studentRepository.save(student);
        }

    }

    @Override
    public TblstudentEntity updateStudent(TblstudentEntity studentUpdate, long id) {
        if(studentRepository.findById(id).isPresent()){
            Optional<TblstudentEntity> student = searchStudentById(id);
            studentUpdate.setId(id);
            student.stream().map(st-> {
                st.setId(id);
                st.setStudentname(studentUpdate.getStudentname());
                st.setStudentcode(studentUpdate.getStudentcode());
                st.setAddress(studentUpdate.getAddress());
                st.setEmail(studentUpdate.getEmail());
                st.setPhone(studentUpdate.getPhone());

                return st;
            });
        }
        return studentRepository.save(studentUpdate);

    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<TblstudentEntity> searchStudentById(long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Optional<TblstudentEntity> searchByName(String name) {
        return studentRepository.findByStudentname(name);
    }

    @Override
    public Optional<TblstudentEntity> searchByStudentCode(String studentcode) {
        return studentRepository.findByStudentcode(studentcode);

    }

    @Override
    public Optional<TblstudentEntity> searchByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Optional<TblstudentEntity> searchByPhone(String phone) {
        return studentRepository.findByPhone(phone);
    }

}
