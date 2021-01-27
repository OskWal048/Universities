package com.example.oskar.universities.service;

import com.example.oskar.universities.entity.Student;
import com.example.oskar.universities.exception.StudentNotFoundException;
import com.example.oskar.universities.exception.UniversityNotFoundException;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(String id) throws StudentNotFoundException;
    boolean checkIfStudentExists(String id) throws StudentNotFoundException;
    void add(Student student);
    void update(Student student);
    void enrollStudentByUniversityId(Student student, String universityId) throws UniversityNotFoundException, StudentNotFoundException;
    void enrollStudentByUniversityName(Student student, String universityName);
    void deleteById(String id);
}
