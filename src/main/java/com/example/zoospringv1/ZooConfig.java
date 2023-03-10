package com.example.zoospringv1;

import com.example.zoospringv1.animal.AnimalService;
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
