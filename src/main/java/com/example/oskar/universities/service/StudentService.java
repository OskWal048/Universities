package com.example.oskar.universities.service;

import com.example.oskar.universities.entity.FieldOfStudy;
import com.example.oskar.universities.entity.Grade;
import com.example.oskar.universities.entity.Student;
import com.example.oskar.universities.exception.FieldOfStudyNotFoundException;
import com.example.oskar.universities.exception.StudentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll(Optional<Integer> optionalMinAge, Optional<Integer> optionalMaxAge, Optional<Student.Gender> optionalGender,
                          Optional<Student.StudentStatus> optionalStatus, Optional<Double> optionalMinAvgGrade, Optional<Double> optionalMaxAvgGrade);
    Student findById(String id) throws StudentNotFoundException;
    boolean checkIfStudentExists(String id) throws StudentNotFoundException;
    void add(Student student);
    void update(Student student);
    List<Grade> getGradesById(String studentId) throws StudentNotFoundException;
    void addGrade(String studentId, Grade grade) throws StudentNotFoundException, FieldOfStudyNotFoundException;
    List<FieldOfStudy> findStudentFieldsOfStudy(String studentId) throws StudentNotFoundException, FieldOfStudyNotFoundException;
    void enrollStudentInFieldOfStudy(String studentId, String fieldOfStudyId) throws FieldOfStudyNotFoundException, StudentNotFoundException;
    void deleteById(String id);
}
