package com.example.oskar.universities.service;

import com.example.oskar.universities.entity.University;
import com.example.oskar.universities.exception.UniversityNotFoundException;

import java.util.List;

public interface UniversityService {
    List<University> findAll();
    University findById(String id) throws UniversityNotFoundException;
    University findByName(String name) throws UniversityNotFoundException;
    void add(University university);
    void update(University university);
    void deleteById(String id);
}
