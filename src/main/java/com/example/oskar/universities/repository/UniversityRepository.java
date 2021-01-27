package com.example.oskar.universities.repository;

import com.example.oskar.universities.entity.University;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UniversityRepository extends MongoRepository<University, String> {
    @Query(value="{}", fields="{'name': 1, 'additionDate': 1, 'address': 1, 'email': 1, 'phone': 1}")
    List<University> findAllExcludeLists();
    Optional<University> findUniversityByName(String name);
}
