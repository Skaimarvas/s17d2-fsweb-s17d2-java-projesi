package com.example.dependencyInjection.rest;

import com.example.dependencyInjection.model.Developer;
import com.example.dependencyInjection.model.JuniorDeveloper;
import com.example.dependencyInjection.model.MidDeveloper;
import com.example.dependencyInjection.model.SeniorDeveloper;
import com.example.dependencyInjection.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CrossOrigin neden kullanılır?
 * developers = new HashMap<>() olarak oluşturmadığım için nullpointer hatası aldım.
 * ilk başta @GetMapping("/${id}")  olarak yazdığım için hata aldım.
 */

@RestController
@RequestMapping("/developer")
public class DeveloperController {

  private Map<Integer, Developer> developers = new HashMap<>();

  @Autowired
  private Taxable tax;

  @PostConstruct
  void init(){
    developers.put(1, new JuniorDeveloper(1,"Micheal Jackson"));
    developers.put(2, new MidDeveloper(2,"Jason Derulo"));
    developers.put(3, new SeniorDeveloper(3,"Mikhail Gorbachev"));
  }

  @GetMapping
  public List<Developer> listAll(){
    return developers.values().stream().toList();
  }

  @GetMapping("/{id}")
  public Developer findDeveloper(@PathVariable int id){
    if(developers.containsKey(id)){
      return developers.get(id);
    }
    return null;
  }

  @PostMapping
  public ResponseEntity<String> postDeveloper(@RequestBody Developer developer){
    if(developers.containsKey(developer.getId())){
      String message = "This developer is already exist:" + developers.get(developer.getId()).getName();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    } else {
      developers.put(developer.getId(), developer);
      String message = "The developer:" + developer.getName() + " was succesfully added";
      return ResponseEntity.status(HttpStatus.CONFLICT).body(message);

    }

  }





}
