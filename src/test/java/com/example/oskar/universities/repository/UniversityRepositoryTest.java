package com.example.oskar.universities.repository;

import com.example.oskar.universities.entity.University;
import com.example.oskar.universities.exception.UniversityNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataMongoTest
public class UniversityRepositoryTest {

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void findByNameTest(){
        String name = "Mock University";
        University newUniversity = new University();
        newUniversity.setName(name);

        mongoTemplate.save(newUniversity);

        try {
            University found = universityRepository.findUniversityByName(name).orElseThrow(()-> new UniversityNotFoundException("JUNIT TEST University not found"));

            assertEquals(found, newUniversity);
        } catch (UniversityNotFoundException e) {
            fail();
        }

        mongoTemplate.remove(newUniversity);
    }

}