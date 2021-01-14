package com.example.oskar.universities.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "fieldsOfStudy")
@Getter @Setter @NoArgsConstructor
public class FieldOfStudy {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("universityId")
    private String universityId;

    @JsonProperty("nameOfStudyField")
    private String nameOfStudyField;

    @JsonProperty("startDate")
    private LocalDate startDate;

    @JsonProperty("studentsLimit")
    private Integer studentsLimit;

}
