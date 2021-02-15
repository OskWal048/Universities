package com.example.oskar.universities.rest;

import com.example.oskar.universities.entity.FieldOfStudy;
import com.example.oskar.universities.entity.Student;
import com.example.oskar.universities.exception.FieldOfStudyNotFoundException;
import com.example.oskar.universities.exception.UniversityNotFoundException;
import com.example.oskar.universities.service.FieldOfStudyService;
import com.example.oskar.universities.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fieldsOfStudy")
public class FieldOfStudyRestController {

    private final FieldOfStudyService fieldOfStudyService;
    private final UniversityService universityService;

    public FieldOfStudyRestController(FieldOfStudyService fieldOfStudyService, UniversityService universityService) {
        this.fieldOfStudyService = fieldOfStudyService;
        this.universityService = universityService;
    }

    @GetMapping
    public List<FieldOfStudy> findAll(){
        return fieldOfStudyService.findAll();
    }

    @GetMapping("/{fieldOfStudyId}")
    public FieldOfStudy findById(@PathVariable String fieldOfStudyId) throws FieldOfStudyNotFoundException {
        return fieldOfStudyService.findById(fieldOfStudyId);
    }

    @GetMapping("/{fieldOfStudyId}/students")
    public List<Student> findStudentsByFieldOfStudyId(@PathVariable String fieldOfStudyId){
        return fieldOfStudyService.findStudentsByFieldId(fieldOfStudyId);
    }

    @PostMapping
    public FieldOfStudy add(@RequestBody FieldOfStudy fieldOfStudy, @RequestParam(name="universityId")Optional<String> universityId) throws UniversityNotFoundException, FieldOfStudyNotFoundException {
        fieldOfStudyService.add(fieldOfStudy);

        if(universityId.isPresent())
            universityService.addFieldOfStudy(universityId.get(), fieldOfStudy.getId());

        return fieldOfStudy;
    }

    @PutMapping
    public FieldOfStudy update(@RequestBody FieldOfStudy fieldOfStudy){
        fieldOfStudyService.update(fieldOfStudy);

        return fieldOfStudy;
    }

}
