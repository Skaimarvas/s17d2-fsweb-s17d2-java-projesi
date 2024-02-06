package com.example.dependencyInjection.model;

public class SeniorDeveloper extends Developer {
    public SeniorDeveloper(int id, String name, int salary, Experience experience) {
        super(id, name, 8000, Experience.SENIOR);
    }
}
