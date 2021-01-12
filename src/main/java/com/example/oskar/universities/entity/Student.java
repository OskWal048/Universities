package com.example.oskar.universities.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "students")
@Getter @Setter @NoArgsConstructor
public class Student {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("gender")
    private Gender gender;

    @JsonProperty("studentStatus")
    private StudentStatus studentStatus;

    @JsonProperty("averageGrade")
    private Double averageGrade;

    @JsonProperty("fieldsOfStudy")
    private List<FieldOfStudy> fieldsOfStudy;

    public enum Gender{
        MALE("male"),
        FEMALE("female");

        private String value;

        Gender(String value){this.value = value;}

        @Override
        @JsonValue
        public String toString(){return value;}

        @JsonCreator
        public static Gender fromValue(String value){
            for(Gender g : Gender.values()){
                if(g.value.equals(value))
                    return g;
            }
            return null;
        }
    }

    public enum StudentStatus{
        ACTIVE("active"),
        INACTIVE("inactive"),
        SUSPENDED("suspended"),
        DEANS_LEAVE("dean's leave");

        private String value;

        StudentStatus(String value){this.value = value;}

        @Override
        @JsonValue
        public String toString(){return value;}

        @JsonCreator
        public static StudentStatus fromValue(String value){
            for(StudentStatus s : StudentStatus.values()){
                if(s.value.equals(value))
                    return s;
            }
            return null;
        }
    }
}
