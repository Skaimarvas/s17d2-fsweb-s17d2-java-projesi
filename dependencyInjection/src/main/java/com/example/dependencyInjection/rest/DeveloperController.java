package com.example.dependencyInjection.rest;

import com.example.dependencyInjection.model.Developer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/developer")
public class DeveloperController {
  private Map<Integer, Developer> developers;

}
