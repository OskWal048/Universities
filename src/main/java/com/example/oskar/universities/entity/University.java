package com.example.oskar.universities.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document(collection = "universities")
@Getter @Setter @NoArgsConstructor
public class University implements Serializable {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonIgnore
    private String uuid = UUID.randomUUID().toString();

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

    @JsonProperty("students")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> students;

    @JsonProperty("fieldsOfStudy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> fieldsOfStudy;

    public int hashCode(){
        return Objects.hash(uuid);
    }

    public boolean equals(Object that){
        return this == that || that instanceof University && uuid.equals(((University) that).getUuid());
    }


}
