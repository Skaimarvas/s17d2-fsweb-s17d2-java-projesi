package com.example.dependencyInjection.model;

public class MidDeveloper extends Developer{
    public MidDeveloper(int id, String name, int salary) {
        super(id, name, salary, Experience.MID);
    }
}
