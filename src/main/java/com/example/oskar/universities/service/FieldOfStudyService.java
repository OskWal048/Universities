package com.example.oskar.universities.service;

import com.example.oskar.universities.entity.FieldOfStudy;
import com.example.oskar.universities.entity.Student;
import com.example.oskar.universities.exception.FieldOfStudyNotFoundException;

import java.util.List;

public interface FieldOfStudyService {
    List<FieldOfStudy> findAll();
    FieldOfStudy findById(String id) throws FieldOfStudyNotFoundException;
    List<FieldOfStudy> findByUniversityId(String universityId);
    List<FieldOfStudy> findByName(String name);
    List<Student> findStudentsByFieldId(String fieldId);
    void add(FieldOfStudy fieldOfStudy);
    void update(FieldOfStudy fieldOfStudy);
    void deleteById(String id);
}
