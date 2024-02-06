package com.example.dependencyInjection.model;

public class SeniorDeveloper extends Developer {
    public SeniorDeveloper(int id, String name) {
        super(id, name, 8000, Experience.SENIOR);
    }
}
