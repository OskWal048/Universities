package com.example.oskar.universities.exception;

public class FieldOfStudyNotFoundException extends Exception{
    public FieldOfStudyNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
