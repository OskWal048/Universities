package com.example.oskar.universities.service;

import com.example.oskar.universities.entity.University;
import com.example.oskar.universities.exception.UniversityNotFoundException;
import com.example.oskar.universities.repository.UniversityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService{

    private final UniversityRepository universityRepository;

    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
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
    public void deleteById(String id) {
        universityRepository.deleteById(id);
    }
}
