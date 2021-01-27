package com.example.oskar.universities.rest;

import com.example.oskar.universities.entity.University;
import com.example.oskar.universities.exception.StudentNotFoundException;
import com.example.oskar.universities.exception.UniversityNotFoundException;
import com.example.oskar.universities.service.UniversityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/universities")
public class UniversityRestController {

    private final UniversityService universityService;

    public UniversityRestController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public List<University> getAllUniversities(@RequestParam(name="includeLists") Optional<Boolean> includeLists){
        if(includeLists.isPresent() && !includeLists.get())
            return universityService.findAllExcludeLists();
        return universityService.findAll();
    }

    @GetMapping("/{id}")
    public University getUniversityById(@PathVariable String id) throws UniversityNotFoundException {
        return universityService.findById(id);
    }

    @PostMapping
    public University addUniversity(@RequestBody University university){

        universityService.add(university);

        return university;
    }

    @PutMapping
    public University updateUniversity(@RequestBody University university){
        universityService.update(university);
        return university;
    }

    @PutMapping
    public void assignStudent(@RequestParam(name="universityId") String universityId, @RequestParam(name="studentId") String studentId) throws UniversityNotFoundException, StudentNotFoundException {
        universityService.enrollStudentByUniversityId(universityId, studentId);
    }


}
