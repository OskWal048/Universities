package com.example.oskar.universities.service;

import com.example.oskar.universities.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    void add(Student student);
    void update(Student student);
    void deleteById(String id);
}
