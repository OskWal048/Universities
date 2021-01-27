package com.example.oskar.universities.exception;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
