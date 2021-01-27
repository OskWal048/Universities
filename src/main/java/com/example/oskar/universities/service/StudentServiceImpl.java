package com.example.oskar.universities.service;

import com.example.oskar.universities.entity.Student;
import com.example.oskar.universities.exception.StudentNotFoundException;
import com.example.oskar.universities.exception.UniversityNotFoundException;
import com.example.oskar.universities.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
//    private final UniversityService universityService;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
//        this.universityService = universityService;
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

//    @Override
//    public void enrollStudentByUniversityId(Student student, String universityId) throws UniversityNotFoundException, StudentNotFoundException {
////        universityService.enrollStudentByUniversityId(universityId, student.getId());
//    }
//
//    @Override
//    public void enrollStudentByUniversityName(Student student, String universityName) throws UniversityNotFoundException, StudentNotFoundException {
////        universityService.enrollStudentByUniversityName(universityName, student.getId());
//    }

    @Override
    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }
}
