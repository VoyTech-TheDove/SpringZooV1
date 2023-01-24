package com.example.zoospringv1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZooConfig {
    @Bean
    public Zoo zoo (){
     return new Zoo("ExampleZoo", "Las Covidas", AnimalRespositoryUtils.generateRandomAnimals());
    }
}
