package com.example.oskar.universities.service;

import com.example.oskar.universities.entity.University;
import com.example.oskar.universities.error.UniversityNotFoundException;

import java.util.List;

public interface UniversityService {
    List<University> findAll();
    University findByName(String name) throws UniversityNotFoundException;
}
