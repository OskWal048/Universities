package com.example.oskar.universities.service;

import com.example.oskar.universities.entity.Student;
import com.example.oskar.universities.entity.University;
import com.example.oskar.universities.exception.StudentNotFoundException;
import com.example.oskar.universities.exception.UniversityNotFoundException;

import java.util.List;

public interface UniversityService {
    List<University> findAll();
    List<University> findAllExcludeLists();
    University findById(String id) throws UniversityNotFoundException;
    University findByName(String name) throws UniversityNotFoundException;
    List<Student> findStudentsFromUniversity(String universityId) throws UniversityNotFoundException;
    void add(University university);
    void update(University university);
    void enrollStudentByUniversityId(String universityId, String studentId) throws UniversityNotFoundException, StudentNotFoundException;
    void enrollStudentByUniversityName(String universityName, String studentId) throws UniversityNotFoundException, StudentNotFoundException;
    void deleteById(String id);
}
