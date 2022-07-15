package com.example.studentspringboot.service;

import com.example.studentspringboot.model.Student;
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
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        //Check Tồn tại studentCode, email, phone
        Optional<Student> studentCheckStudentCode = studentRepository.findByStudentCode(student.getStudentCode());
        Optional<Student> studentCheckEmail = studentRepository.findByEmail(student.getEmail());
        Optional<Student> studentCheckPhone = studentRepository.findByPhone(student.getPhone());
        System.out.println(studentCheckPhone);
        if(studentCheckStudentCode.isPresent()||studentCheckPhone.isPresent()||studentCheckEmail.isPresent()){
            return (Student) ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED);
        }else{
            return studentRepository.save(student);
        }

    }


    @Override
    public Student updateStudent(Student studentUpdate, int id) {
        if(studentRepository.findById(id).isPresent()){
            Optional<Student> student = searchStudentById(id);
            studentUpdate.setId(id);
            student.stream().map(st-> {
                st.setId(id);
                st.setStudentName(studentUpdate.getStudentName());
                st.setStudentCode(studentUpdate.getStudentCode());
                st.setAddress(studentUpdate.getAddress());
                st.setEmail(studentUpdate.getEmail());
                st.setPhone(studentUpdate.getPhone());
                return st;
            });
        }
        return studentRepository.save(studentUpdate);

    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<Student> searchStudentById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public Optional<Student> searchByName(String name) {
        return studentRepository.findByStudentName(name);
    }

    @Override
    public Optional<Student> searchByStudentCode(String studentCode) {
        return studentRepository.findByStudentCode(studentCode);

    }

    @Override
    public Optional<Student> searchByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Optional<Student> searchByPhone(String phone) {
        return studentRepository.findByPhone(phone);
    }





}
