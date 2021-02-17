package com.example.oskar.universities.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
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
    private int age;

    @JsonProperty("gender")
    private Gender gender;

    @JsonProperty("studentStatus")
    private StudentStatus studentStatus;

    @JsonProperty("averageGrade")
    private double averageGrade;

    @JsonProperty("fieldsOfStudy")
    private List<String> fieldsOfStudy;

    @JsonProperty("grades")
    private List<Grade> grades;

    public List<String> getFieldsOfStudy(){
        if(fieldsOfStudy == null)
            fieldsOfStudy = new ArrayList<>();

        return fieldsOfStudy;
    }

    public double getAverageGrade() {

        this.setAverageGrade(calculateAverageGrade());

        return Math.round(averageGrade * 100.0)/100.0;
    }

    public void setAverageGrade(double averageGrade){
        this.averageGrade = averageGrade;
    }

    private double calculateAverageGrade(){

        return grades.stream().mapToDouble(Grade::getGrade).average().orElse(0.0);
    }

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
