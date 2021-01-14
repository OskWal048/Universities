package com.example.oskar.universities.rest;

import com.example.oskar.universities.entity.FieldOfStudy;
import com.example.oskar.universities.service.FieldOfStudyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fieldsOfStudy")
public class FieldOfStudyRestController {

    private final FieldOfStudyService fieldOfStudyService;

    public FieldOfStudyRestController(FieldOfStudyService fieldOfStudyService) {
        this.fieldOfStudyService = fieldOfStudyService;
    }

    @GetMapping
    public List<FieldOfStudy> findAll(){
        return fieldOfStudyService.findAll();
    }

    @PostMapping
    public FieldOfStudy add(@RequestBody FieldOfStudy fieldOfStudy){

        fieldOfStudyService.add(fieldOfStudy);

        return fieldOfStudy;
    }

    @PutMapping
    public FieldOfStudy update(@RequestBody FieldOfStudy fieldOfStudy){
        fieldOfStudyService.update(fieldOfStudy);

        return fieldOfStudy;
    }

}
