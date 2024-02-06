package com.example.dependencyInjection.rest;

import com.example.dependencyInjection.model.Developer;
import com.example.dependencyInjection.model.JuniorDeveloper;
import com.example.dependencyInjection.model.MidDeveloper;
import com.example.dependencyInjection.model.SeniorDeveloper;
import com.example.dependencyInjection.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * CrossOrigin neden kullanılır?
 */

@RestController
@RequestMapping("/developer")
public class DeveloperController {
  private Map<Integer, Developer> developers;

  @Autowired
  private Taxable tax;

  @PostConstruct
  void init(){
    developers.put(1, new JuniorDeveloper(1,"Micheal Jackson"));
    developers.put(2, new MidDeveloper(2,"Jason Derulo"));
    developers.put(3, new SeniorDeveloper(3,"Mikhail Gorbachev"));
  }





}
