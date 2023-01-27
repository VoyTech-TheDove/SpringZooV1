package com.example.zoospringv1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mapper {
    @Autowired
    AnimalService animalService;

    public AnimalDTO toDTO(Animal animal) {
        String name = animal.name();
        String species = animal.species();
        return new AnimalDTO(species, name);
    }

    public AnimalDTO toAnimal(AnimalDTO animalDTO) {
        return toDTO(animalService.addAnimalRequested(animalDTO.species(), animalDTO.name()));
    }

    public AnimalDTO getAnimalByIdDTO(int id) {
        return toDTO(animalService.getAnimalById(id));
    }

    public List<AnimalDTO> getAnimalsDTO() {
        List<AnimalDTO> animalsDTO = new ArrayList<>();
        List<Animal> animals = animalService.getAnimals();
        for (Animal a : animals) {
            animalsDTO.add(new AnimalDTO(a.species(), a.name()));
        }
        return animalsDTO;
    }

}
