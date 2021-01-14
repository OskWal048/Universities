package com.example.oskar.universities.exception;

public class UniversityNotFoundException extends Exception{
    public UniversityNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
