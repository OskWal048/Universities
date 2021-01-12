package com.example.oskar.universities.repository;

import com.example.oskar.universities.entity.University;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniversityRepository extends MongoRepository<University, String> {
    Optional<University> findUniversityByName(String name);
}
