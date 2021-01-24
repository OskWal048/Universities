package com.example.oskar.universities.repository;

import com.example.oskar.universities.entity.FieldOfStudy;
import com.example.oskar.universities.entity.University;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataMongoTest
public class FieldOfStudyRepositoryTest {

    @Autowired
    private FieldOfStudyRepository fieldOfStudyRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void findAllByNameTest(){
        String name = "Mock Field Of Study";
        List<FieldOfStudy> newFields = new ArrayList<>();

        for(int i = 0; i<4; i++){
            FieldOfStudy field = new FieldOfStudy();
            field.setNameOfStudyField(name);
            mongoTemplate.save(field);
            newFields.add(field);
        }

        List<FieldOfStudy> foundFields = fieldOfStudyRepository.findAllByNameOfStudyFieldLike(name);

        assertTrue(newFields.size() == foundFields.size() && foundFields.size() > 0);

        for(FieldOfStudy f : newFields){
            assertTrue(foundFields.contains(f));
        }

        for(FieldOfStudy f : newFields){
            mongoTemplate.remove(f);
        }

    }

    @Test
    public void findAllByUniversityIdTest(){
        List<FieldOfStudy> newFields = new ArrayList<>();
        University newUniversity = new University();
        mongoTemplate.save(newUniversity);

        for(int i=0; i<4; i++){
            FieldOfStudy field = new FieldOfStudy();
            field.setNameOfStudyField("Mock Field " + i);
            field.setUniversityId(newUniversity.getId());
            mongoTemplate.save(field);
            newFields.add(field);
        }

        List<FieldOfStudy> foundFields = fieldOfStudyRepository.findAllByUniversityId(newUniversity.getId());

        assertTrue(newFields.size() == foundFields.size() && foundFields.size() > 0);

        for(FieldOfStudy f : newFields){
            assertTrue(foundFields.contains(f));
        }

        for(FieldOfStudy f : newFields){
            mongoTemplate.remove(f);
        }
        mongoTemplate.remove(newUniversity);
    }

}