package com.example.oskar.universities.service;

import com.example.oskar.universities.entity.FieldOfStudy;
import com.example.oskar.universities.entity.Grade;
import com.example.oskar.universities.entity.Student;
import com.example.oskar.universities.exception.FieldOfStudyNotFoundException;
import com.example.oskar.universities.exception.StudentNotFoundException;
import com.example.oskar.universities.repository.FieldOfStudyRepository;
import com.example.oskar.universities.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final FieldOfStudyRepository fieldOfStudyRepository;

    public StudentServiceImpl(StudentRepository studentRepository, FieldOfStudyRepository fieldOfStudyRepository) {
        this.studentRepository = studentRepository;
        this.fieldOfStudyRepository = fieldOfStudyRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(String id) throws StudentNotFoundException {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElseThrow(()-> new StudentNotFoundException("Could not find student with id: "+id));
    }

    @Override
    public boolean checkIfStudentExists(String id) throws StudentNotFoundException {
        if(studentRepository.existsById(id))
            return true;
        else
            throw new StudentNotFoundException("Could not find student with id: "+id);
    }

    @Override
    public void add(Student student) {
        studentRepository.insert(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Grade> getGradesById(String studentId) throws StudentNotFoundException {
        return findById(studentId).getGrades();
    }

    @Override
    public void addGrade(String studentId, Grade grade) throws StudentNotFoundException, FieldOfStudyNotFoundException {
        Student student = findById(studentId);
        if(!fieldOfStudyRepository.existsById(grade.getFieldOfStudy())){
            throw new FieldOfStudyNotFoundException("Could not find Field of Study with id: " + grade.getFieldOfStudy());
        }

        student.getGrades().add(grade);
    }

    @Override
    public List<FieldOfStudy> findStudentFieldsOfStudy(String studentId) throws StudentNotFoundException, FieldOfStudyNotFoundException {
        List<FieldOfStudy> fields = new ArrayList<>();
        Student student = findById(studentId);

        for(String fieldId : student.getFieldsOfStudy()){
            fields.add(fieldOfStudyRepository.findById(fieldId).orElseThrow(() -> new FieldOfStudyNotFoundException("Could not find Field Of Study with id: "+fieldId)));
        }

        return fields;
    }

    @Override
    public void enrollStudentInFieldOfStudy(String studentId, String fieldOfStudyId) throws FieldOfStudyNotFoundException, StudentNotFoundException {
        if(!fieldOfStudyRepository.existsById(fieldOfStudyId))
            throw new FieldOfStudyNotFoundException("Could not find field of study with id: "+fieldOfStudyId);

        Student student = this.findById(studentId);
        List<String> fieldsOfStudy = student.getFieldsOfStudy();

        fieldsOfStudy.add(fieldOfStudyId);
    }

    @Override
    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }
}
