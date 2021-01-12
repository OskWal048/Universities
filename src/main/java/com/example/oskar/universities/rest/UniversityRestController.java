package com.example.oskar.universities.rest;

import com.example.oskar.universities.entity.University;
import com.example.oskar.universities.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityRestController {

    private final UniversityService universityService;

    public UniversityRestController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public List<University> getAllUniversities(){
        return universityService.findAll();
    }


}
