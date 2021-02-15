package com.example.oskar.universities.service;

import com.example.oskar.universities.entity.FieldOfStudy;
import com.example.oskar.universities.entity.Student;
import com.example.oskar.universities.exception.FieldOfStudyNotFoundException;
import com.example.oskar.universities.exception.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(String id) throws StudentNotFoundException;
    boolean checkIfStudentExists(String id) throws StudentNotFoundException;
    void add(Student student);
    void update(Student student);
    List<FieldOfStudy> findStudentFieldsOfStudy(String studentId) throws StudentNotFoundException, FieldOfStudyNotFoundException;
    void enrollStudentInFieldOfStudy(String studentId, String fieldOfStudyId) throws FieldOfStudyNotFoundException, StudentNotFoundException;
    void deleteById(String id);
}
