package com.example.zoospringv1;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ZooController {
    @GetMapping("/animal")
    public List<Animal> showList() {
        return AnimalRespositoryUtils.returnAnimals();
    }

    @GetMapping("/animal/{id}")
    public Animal animal(@PathVariable("id") Integer id) {
        return AnimalRespositoryUtils.getAnimalById(id);
    }

    @PostMapping("/animal/add/")
    public Animal animal(
            @RequestParam("species") String species,
            @RequestParam(value = "name", required = false) String name) {
        if (name == null) {
            return AnimalRespositoryUtils.addAnimal(species);
        } else {
            return AnimalRespositoryUtils.addAnimal(species, name);
        }
    }
}
