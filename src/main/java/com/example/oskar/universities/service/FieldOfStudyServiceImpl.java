package com.example.oskar.universities.service;

import com.example.oskar.universities.entity.FieldOfStudy;
import com.example.oskar.universities.entity.Student;
import com.example.oskar.universities.exception.FieldOfStudyNotFoundException;
import com.example.oskar.universities.repository.FieldOfStudyRepository;
import com.example.oskar.universities.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FieldOfStudyServiceImpl implements FieldOfStudyService{

    private final FieldOfStudyRepository fieldOfStudyRepository;
    private final StudentRepository studentRepository;

    public FieldOfStudyServiceImpl(FieldOfStudyRepository fieldOfStudyRepository, StudentRepository studentRepository) {
        this.fieldOfStudyRepository = fieldOfStudyRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<FieldOfStudy> findAll() {
        return fieldOfStudyRepository.findAll();
    }

    @Override
    public FieldOfStudy findById(String id) throws FieldOfStudyNotFoundException {
        Optional<FieldOfStudy> optionalFieldOfStudy = fieldOfStudyRepository.findById(id);
        return optionalFieldOfStudy.orElseThrow(() -> new FieldOfStudyNotFoundException("Could not find Field Of Study with id: "+id));
    }

    @Override
    public List<FieldOfStudy> findByUniversityId(String universityId) {
        return fieldOfStudyRepository.findAllByUniversityId(universityId);
    }

    @Override
    public List<FieldOfStudy> findByName(String name) {
        return fieldOfStudyRepository.findAllByNameOfStudyFieldLike(name);
    }

    @Override
    public List<Student> findStudentsByFieldId(String fieldId) {
        return studentRepository.findByFieldsOfStudyContaining(fieldId);
    }

    @Override
    public void add(FieldOfStudy fieldOfStudy) {
        fieldOfStudyRepository.insert(fieldOfStudy);
    }

    @Override
    public void update(FieldOfStudy fieldOfStudy) {
        fieldOfStudyRepository.save(fieldOfStudy);
    }

    @Override
    public void deleteById(String id) {
        fieldOfStudyRepository.deleteById(id);
    }
}
