package com.example.oskar.universities.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Document(collection = "fieldsOfStudy")
@Getter @Setter @NoArgsConstructor
public class FieldOfStudy implements Serializable {

    @Id
    @JsonProperty("id")
    private String id;

    private String uuid = UUID.randomUUID().toString();

    @JsonProperty("universityId")
    private String universityId;

    @JsonProperty("nameOfStudyField")
    private String nameOfStudyField;

    @JsonProperty("startDate")
    private LocalDate startDate;

    @JsonProperty("studentsLimit")
    private int studentsLimit;

    public int hashCode(){
        return Objects.hashCode(uuid);
    }

    public boolean equals(Object that){
        return this == that || that instanceof FieldOfStudy && uuid.equals(((FieldOfStudy) that).getUuid());
    }


}
