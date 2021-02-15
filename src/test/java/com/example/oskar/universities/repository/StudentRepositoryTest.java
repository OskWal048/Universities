package com.example.oskar.universities.repository;

import com.example.oskar.universities.entity.FieldOfStudy;
import com.example.oskar.universities.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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

    @Test
    public void findByFieldsOfStudyContainingTest(){
        Student student1 = new Student();
        Student student2 = new Student();
        FieldOfStudy fieldOfStudy = new FieldOfStudy();

        mongoTemplate.save(fieldOfStudy);
        student1.getFieldsOfStudy().add(fieldOfStudy.getId());
        student2.getFieldsOfStudy().add(fieldOfStudy.getId());

        mongoTemplate.save(student1);
        mongoTemplate.save(student2);

        List<Student> foundStudents = studentRepository.findByFieldsOfStudyContaining(fieldOfStudy.getId());

        assertEquals(2, foundStudents.size());

        for(Student student : foundStudents){
            assertTrue(student.getId().equals(student1.getId()) || student.getId().equals(student2.getId()) );
        }

        mongoTemplate.remove(student1);
        mongoTemplate.remove(student2);
        mongoTemplate.remove(fieldOfStudy);
    }
}