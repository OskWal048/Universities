package com.example.oskar.universities.repository;

import com.example.oskar.universities.entity.FieldOfStudy;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FieldOfStudyRepository extends MongoRepository<FieldOfStudy, String> {
}
