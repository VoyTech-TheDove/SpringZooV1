package com.example.zoospringv1.animal;

import com.example.zoospringv1.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnimalMapper {
    @Autowired
    AnimalService animalService;

    public AnimalDto toDto(Animal animal) {
        String name = animal.name();
        String species = animal.species();
        return new AnimalDto(species, name);
    }

    public AnimalDto toAnimal(AnimalDto animalDto) {
        return toDto(animalService.addAnimalRequested(animalDto.species(), animalDto.name()));
    }

    public AnimalDto getAnimalByIdDto(int id) {
        return toDto(animalService.getAnimalById(id));
    }

    public List<AnimalDto> getAnimalsDto() {
        List<AnimalDto> animalsDto = new ArrayList<>();
        List<Animal> animals = animalService.getAnimals();
        for (Animal a : animals) {
            animalsDto.add(toDto(a));
        }
        return animalsDto;
    }
}