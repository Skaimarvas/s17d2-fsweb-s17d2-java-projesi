package com.example.dependencyInjection.model;

public class JuniorDeveloper extends Developer{


    public JuniorDeveloper(int id, String name, int salary) {
        super(id, name, salary, Experience.JUNIOR);
    }
}
