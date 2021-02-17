package com.example.oskar.universities.rest;

import com.example.oskar.universities.entity.FieldOfStudy;
import com.example.oskar.universities.entity.Grade;
import com.example.oskar.universities.entity.Student;
import com.example.oskar.universities.exception.FieldOfStudyNotFoundException;
import com.example.oskar.universities.exception.StudentNotFoundException;
import com.example.oskar.universities.exception.UniversityNotFoundException;
import com.example.oskar.universities.service.StudentService;
import com.example.oskar.universities.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentRestController {

    private final StudentService studentService;
    private final UniversityService universityService;

    public StudentRestController(StudentService studentService, UniversityService universityService) {
        this.studentService = studentService;
        this.universityService = universityService;
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

        if(universityId.isPresent())
            universityService.enrollStudentByUniversityId(universityId.get(), student.getId());
        else if(universityName.isPresent())
            universityService.enrollStudentByUniversityName(universityName.get(), student.getId());

        return student;
    }

    @PutMapping
    public Student update(@RequestBody Student student){
        studentService.update(student);
        return student;
    }

    @GetMapping("/{studentId}/grades")
    public List<Grade> findGradesById(@PathVariable String studentId) throws StudentNotFoundException {
        return studentService.getGradesById(studentId);
    }

    @PostMapping("/{studentId}/grades")
    public void addGrade(@PathVariable String studentId, @RequestBody Grade grade) throws FieldOfStudyNotFoundException, StudentNotFoundException {
        studentService.addGrade(studentId, grade);
    }

    @GetMapping("/{studentId}/fieldsOfStudy")
    public List<FieldOfStudy> findStudentFieldsOfStudy(@PathVariable String studentId) throws FieldOfStudyNotFoundException, StudentNotFoundException {
        return studentService.findStudentFieldsOfStudy(studentId);
    }

    @PutMapping("/{studentId}/fieldsOfStudy")
    public void enrollStudentInFieldOfStudy(@PathVariable String studentId, @RequestParam(name="fieldId") String fieldOfStudyId) throws FieldOfStudyNotFoundException, StudentNotFoundException {
        studentService.enrollStudentInFieldOfStudy(studentId, fieldOfStudyId);
    }
}
