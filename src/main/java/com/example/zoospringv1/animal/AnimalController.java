package com.example.zoospringv1.animal;

import com.example.zoospringv1.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private Mapper mapper;
    @GetMapping
    public List<AnimalDto> get() {
        return mapper.getAnimalsDto();
    }
    @GetMapping("/{id}")
    public AnimalDto get(@PathVariable("id") Integer id) {
        return mapper.getAnimalByIdDto(id);
    }
    @PostMapping
    public AnimalDto add(
            @RequestParam(value = "species", required = false) String species,
            @RequestParam(value = "name", required = false) String name) {
        return mapper.toAnimal(new AnimalDto(species, name));
    }
}
