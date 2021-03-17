package com.webapp.dbcrud.service;

import com.webapp.dbcrud.entity.Student;
import com.webapp.dbcrud.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAllStudent() {
        List<Student> studentList = studentRepo.findAll();
        return studentList;
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).get();
    }

    public void saveorupdateStudent(Student student) {
        studentRepo.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}
