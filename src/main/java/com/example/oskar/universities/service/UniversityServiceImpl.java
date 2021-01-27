package com.example.oskar.universities.service;

import com.example.oskar.universities.entity.Student;
import com.example.oskar.universities.entity.University;
import com.example.oskar.universities.exception.StudentNotFoundException;
import com.example.oskar.universities.exception.UniversityNotFoundException;
import com.example.oskar.universities.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService{

    private final UniversityRepository universityRepository;
    private final StudentService studentService;

    public UniversityServiceImpl(UniversityRepository universityRepository, StudentService studentService) {
        this.universityRepository = universityRepository;
        this.studentService = studentService;
    }

    @Override
    public List<University> findAll() {
        return universityRepository.findAll();
    }

    @Override
    public List<University> findAllExcludeLists() {
        return universityRepository.findAllExcludeLists();
    }

    @Override
    public University findById(String id) throws UniversityNotFoundException {
        Optional<University> optionalUniversity = universityRepository.findById(id);
        return optionalUniversity.orElseThrow(() -> new UniversityNotFoundException("Could not find university with id: "+id));
    }

    @Override
    public University findByName(String name) throws UniversityNotFoundException {
        Optional<University> optionalUniversity = universityRepository.findUniversityByName(name);
        return optionalUniversity.orElseThrow(() -> new UniversityNotFoundException("Could not find university with name: "+name));
    }

    @Override
    public void add(University university) {
        university.setAdditionDate(LocalDateTime.now());
        universityRepository.insert(university);
    }

    @Override
    public void update(University university) {
        universityRepository.save(university);
    }

    @Override
    public void enrollStudentByUniversityId(String universityId, String studentId) throws UniversityNotFoundException, StudentNotFoundException {
        University university = this.findById(universityId);
        List<String> students = university.getStudents();

        studentService.checkIfStudentExists(studentId);

        students.add(studentId);
    }

    @Override
    public void enrollStudentByUniversityName(String universityName, String studentId) throws UniversityNotFoundException, StudentNotFoundException {
        University university = this.findByName(universityName);
        List<String> students = university.getStudents();

        studentService.checkIfStudentExists(studentId);

        students.add(studentId);
    }

    @Override
    public void deleteById(String id) {
        universityRepository.deleteById(id);
    }
}
