package com.example.zoospringv1.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private AnimalMapper animalMapper;

    @GetMapping
    public List<AnimalDto> get() {
        return animalMapper.getAnimalsDto();
    }

    @GetMapping("/{id}")
    public AnimalDto get(@PathVariable("id") Integer id) {
        return animalMapper.getAnimalByIdDto(id);
    }

    @PostMapping
    public AnimalDto add(
            @RequestParam(value = "species", required = false) String species,
            @RequestParam(value = "name", required = false) String name) {
        return animalMapper.toAnimal(new AnimalDto(species, name));
    }
}
