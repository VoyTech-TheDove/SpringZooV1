package com.example.zoospringv1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    Mapper mapper;

    @GetMapping
    public List<AnimalDTO> get() {
        return mapper.getAnimalsDTO();
    }

    @GetMapping("/{id}")
    public AnimalDTO get(@PathVariable("id") Integer id) {
        return mapper.getAnimalByIdDTO(id);
    }

    @PostMapping
    public AnimalDTO add(
            @RequestParam(value = "species", required = false) String species,
            @RequestParam(value = "name", required = false) String name) {
        return mapper.toAnimal(new AnimalDTO(species, name));
    }
}
