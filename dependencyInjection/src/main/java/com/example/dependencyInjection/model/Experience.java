package com.example.dependencyInjection.model;

public enum Experience {
    JUNIOR("The experience is less than one year"),
    MID("The experience is between one and three years"),
    SENIOR("The experience is more than three years");

    private final String description;

    Experience(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
}
