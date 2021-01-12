package com.example.oskar.universities.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.OffsetDateTime;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class University {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("additionDate")
    private OffsetDateTime additionDate;

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private String address;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("studentsList")
    private List<Student> studentsList;

    @JsonProperty("fieldsOfStudy")
    private List<FieldOfStudy> fieldsOfStudy;
}
