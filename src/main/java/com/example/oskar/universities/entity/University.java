package com.example.oskar.universities.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "universities")
@Getter @Setter @NoArgsConstructor
public class University {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("additionDate")
    private LocalDateTime additionDate;

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private String address;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("studentsList")
    private List<String> studentsList;

    @JsonProperty("fieldsOfStudy")
    private List<String> fieldsOfStudy;
}
