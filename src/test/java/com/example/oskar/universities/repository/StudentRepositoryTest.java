package com.example.oskar.universities.repository;

import com.example.oskar.universities.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataMongoTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void checkIfStudentExistsTest(){
        Student student = new Student();
        mongoTemplate.save(student);

        assertTrue(studentRepository.existsById(student.getId()));
        assertFalse(studentRepository.existsById("123"));

        mongoTemplate.remove(student);
    }
}