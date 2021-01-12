package com.example.oskar.universities.service;

import com.example.oskar.universities.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentById(String id);
}
