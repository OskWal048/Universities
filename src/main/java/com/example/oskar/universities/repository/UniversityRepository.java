package com.example.oskar.universities.repository;

import com.example.oskar.universities.entity.University;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends MongoRepository<University, String> {
}