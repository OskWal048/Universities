package com.example.oskar.universities.repository;

import com.example.oskar.universities.entity.FieldOfStudy;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FieldOfStudyRepository extends MongoRepository<FieldOfStudy, String> {
    List<FieldOfStudy> findAllByNameOfStudyFieldLike(String nameOfStudyField);
    List<FieldOfStudy> findAllByUniversityId(String universityId);
    boolean existsById(String id);
}
