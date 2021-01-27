package com.example.oskar.universities.rest;

import com.example.oskar.universities.entity.Student;
import com.example.oskar.universities.exception.StudentNotFoundException;
import com.example.oskar.universities.exception.UniversityNotFoundException;
import com.example.oskar.universities.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentRestController {

    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable String id) throws StudentNotFoundException {
        return studentService.findById(id);
    }

    @PostMapping
    public Student add(@RequestBody Student student,
                       @RequestParam(name="universityId") Optional<String> universityId,
                       @RequestParam(name="universityName") Optional<String> universityName) throws UniversityNotFoundException, StudentNotFoundException {
        studentService.add(student);

//        if(universityId.isPresent())
//            studentService.enrollStudentByUniversityId(student, universityId.get());
//        else if(universityName.isPresent())
//            studentService.enrollStudentByUniversityName(student, universityName.get());

        return student;
    }

    @PutMapping
    public Student update(@RequestBody Student student){
        studentService.update(student);
        return student;
    }
}
