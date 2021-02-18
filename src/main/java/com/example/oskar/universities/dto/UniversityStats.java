package com.example.oskar.universities.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @NoArgsConstructor
public class UniversityStats {

    private String id;
    private String name;
    private LocalDateTime additionDate;
    private String address;
    private String email;
    private String phone;
    private int numberOfFieldsOfStudy;
    private int numberOfStudents;
    private int numberOfFemaleStudents;
    private int numberOfMaleStudents;
    private int numberOfActiveStudents;
    private int numberOfInactiveStudents;
    private int numberOfSuspendedStudents;
    private int numberOfStudentsOnDeansLeave;

    public UniversityStats setId(String id) {
        this.id = id;
        return this;
    }

    public UniversityStats setName(String name) {
        this.name = name;
        return this;
    }

    public UniversityStats setAdditionDate(LocalDateTime additionDate) {
        this.additionDate = additionDate;
        return this;
    }

    public UniversityStats setAddress(String address) {
        this.address = address;
        return this;
    }

    public UniversityStats setEmail(String email) {
        this.email = email;
        return this;
    }

    public UniversityStats setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UniversityStats setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        return this;
    }

    public UniversityStats setNumberOfFieldsOfStudy(int numberOfFieldsOfStudy) {
        this.numberOfFieldsOfStudy = numberOfFieldsOfStudy;
        return this;
    }

    public UniversityStats setNumberOfMaleStudents(int numberOfMaleStudents) {
        this.numberOfMaleStudents = numberOfMaleStudents;
        return this;
    }

    public UniversityStats setNumberOfFemaleStudents(int numberOfFemaleStudents) {
        this.numberOfFemaleStudents = numberOfFemaleStudents;
        return this;
    }

    public UniversityStats setNumberOfActiveStudents(int numberOfActiveStudents) {
        this.numberOfActiveStudents = numberOfActiveStudents;
        return this;
    }

    public UniversityStats setNumberOfInactiveStudents(int numberOfInactiveStudents) {
        this.numberOfInactiveStudents = numberOfInactiveStudents;
        return this;
    }

    public UniversityStats setNumberOfSuspendedStudents(int numberOfSuspendedStudents) {
        this.numberOfSuspendedStudents = numberOfSuspendedStudents;
        return this;
    }

    public UniversityStats setNumberOfStudentsOnDeansLeave(int numberOfStudentsOnDeansLeave) {
        this.numberOfStudentsOnDeansLeave = numberOfStudentsOnDeansLeave;
        return this;
    }
}
