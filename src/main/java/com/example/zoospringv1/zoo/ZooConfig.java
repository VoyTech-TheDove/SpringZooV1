package com.example.zoospringv1.zoo;

import com.example.zoospringv1.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZooConfig {
    @Autowired
    AnimalService animalService;
    @Bean
    public Zoo zoo (){
     return new Zoo("ExampleZoo", "Las Covidas", animalService.generateRandomAnimals());
    }



}
