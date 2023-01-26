package com.example.zoospringv1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> get() {
        return animalService.getAnimals();
    }

    @GetMapping("/{id}")
    public Animal get(@PathVariable("id") Integer id) {
        return animalService.getAnimalById(id);
    }

    @PostMapping
    public Animal add(
            @RequestParam(value = "species", required = false) String species,
            @RequestParam(value = "name", required = false) String name) {
        return animalService.addAnimalRequested(species, name);
    }
}
