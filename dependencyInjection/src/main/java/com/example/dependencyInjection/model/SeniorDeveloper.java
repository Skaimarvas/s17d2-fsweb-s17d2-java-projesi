package com.example.dependencyInjection.model;

public class SeniorDeveloper extends Developer {
    public SeniorDeveloper(int id, String name, int salary) {
        super(id, name, salary, Experience.SENIOR);
    }
}
