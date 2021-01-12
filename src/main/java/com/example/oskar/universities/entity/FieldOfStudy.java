package com.example.oskar.universities.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
public class FieldOfStudy {

    @JsonProperty("universityId")
    private String universityId;

    @JsonProperty("nameOfStudyField")
    private String nameOfStudyField;

    @JsonProperty("startDate")
    private LocalDate startDate;

    @JsonProperty("studentsLimit")
    private Integer studentsLimit;

    @JsonProperty("grade")
    private Double grade;
}
