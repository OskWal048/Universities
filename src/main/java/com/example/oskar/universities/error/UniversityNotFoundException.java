package com.example.oskar.universities.error;

public class UniversityNotFoundException extends Exception{
    public UniversityNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
