package com.example.dependencyInjection.rest;

import com.example.dependencyInjection.model.*;
import com.example.dependencyInjection.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

  @Value("${info.app.name}")
  private String appName;
  @Value("${info.app.description}")
  private String appDescription;

  @Value("${info.app.version}")
  private String appVersion;


  @GetMapping("/app-info")
  public String getAppInfo(){
    return "App Name: " + appName + ", App Description: " + appDescription +", App Version: " + appVersion;
  }

  @Autowired
  private Taxable tax;

  @PostConstruct
  void init(){
    developers.put(1, new JuniorDeveloper(1,"Micheal Jackson", 4000* tax.getSimpleTaxRate()));
    developers.put(2, new MidDeveloper(2,"Jason Derulo", 6000* tax.getMiddleTaxRate()));
    developers.put(3, new SeniorDeveloper(3,"Mikhail Gorbachev", 8000* tax.getUpperTaxRate()));
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
  public ResponseEntity<String> addDeveloper(@RequestBody Developer developer){
    if(developers.containsKey(developer.getId())){
      String message = "This developer is already exist:" + developers.get(developer.getId()).getName();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    } else {
      if(developer.getExperience().equals(Experience.JUNIOR)){
        JuniorDeveloper junior = new JuniorDeveloper(developer.getId(),developer.getName(),developer.getSalary()* tax.getSimpleTaxRate());
        developers.put(junior.getId(), junior);
        String message = "The developer: " + junior.getClass().getSimpleName() + " " + developer.getName() + " was succesfully added";
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
      } else if (developer.getExperience().equals(Experience.MID)) {
        MidDeveloper mid = new MidDeveloper(developer.getId(),developer.getName(),developer.getSalary() * tax.getMiddleTaxRate() );
        developers.put(mid.getId(), mid);
        String message = "The developer: " + mid.getClass().getSimpleName() + " " + developer.getName() + " was succesfully added";
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
      } else if (developer.getExperience().equals(Experience.SENIOR)) {
        SeniorDeveloper senior = new SeniorDeveloper(developer.getId(),developer.getName(),developer.getSalary()* tax.getUpperTaxRate());
        developers.put(senior.getId(), senior);
        String message = "The developer: " + senior.getClass().getSimpleName() + " " + developer.getName() + " was succesfully added";
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
      }


      return ResponseEntity.status(HttpStatus.CONFLICT).body("Error occured");

    }

  }

  @PutMapping("/{id}")
  public void updatedDeveloper(@PathVariable int id, @RequestBody Developer developer){
    if (developers.containsKey(id)){
       Developer developer1 = developers.get(id);
       developer1.setExperience(developer.getExperience());
       developer1.setName(developer.getName());
       developer1.setSalary(developer.getSalary());
    } else {
      ResponseEntity.status(HttpStatus.CONFLICT).body("There is no developer by this id");
    }
  }

  @DeleteMapping("/{id}")
  public void deleteDeveloper(@PathVariable int id){
    if(developers.containsKey(id)){
      developers.remove(id);
    } else {
      ResponseEntity.status(HttpStatus.CONFLICT).body("There is no developer by this id");
    }
  }





}
