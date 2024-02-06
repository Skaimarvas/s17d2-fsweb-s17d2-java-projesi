package com.example.dependencyInjection.model;

public class JuniorDeveloper extends Developer{



    public JuniorDeveloper(int id, String name) {
        super(id, name,  4000, Experience.JUNIOR);
    }

}
