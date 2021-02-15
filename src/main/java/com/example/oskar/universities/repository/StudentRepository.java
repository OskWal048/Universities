package com.example.oskar.universities.repository;

import com.example.oskar.universities.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    boolean existsById(String id);
    List<Student> findByFieldsOfStudyContaining(String fieldOfStudyId);
}
