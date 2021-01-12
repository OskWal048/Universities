package com.example.oskar.universities.service;

import com.example.oskar.universities.entity.University;
import com.example.oskar.universities.error.UniversityNotFoundException;
import com.example.oskar.universities.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public University findByName(String name) throws UniversityNotFoundException {
        Optional<University> optionalUniversity = universityRepository.findUniversityByName(name);

        if(optionalUniversity.isEmpty())
            throw new UniversityNotFoundException("Could not find university with name: "+name);

        return optionalUniversity.get();
    }
}
