package com.example.dependencyInjection.model;

public class MidDeveloper extends Developer{
    public MidDeveloper(int id, String name, int salary, Experience experience) {
        super(id, name, 6000, Experience.MID);

    }
}
