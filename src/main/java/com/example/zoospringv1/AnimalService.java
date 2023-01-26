package com.example.zoospringv1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
public class AnimalService {
    private List<Animal> animals = new ArrayList<>();
    public List<Animal> getAnimals(){
        return animals;
    }
    public void addAnimalToList(Animal animal){
        getAnimals().add(animal);
    }
    public Animal addAnimal (){
        Animal animal = AnimalRandomizerUtils.createRandomAnimal();
        addAnimalToList(animal);
        return animal;
    }
    public Animal addAnimal (String species){
        Animal animal = AnimalRandomizerUtils.createRandomSpecies(species);
        addAnimalToList(animal);
        return animal;
    }
    public Animal addAnimal (String species,String name){
        Animal animal = AnimalRandomizerUtils.createAnimalSpeciesName(species, name);
        addAnimalToList(animal);
        return animal;
    }
    public Animal addAnimalRequested (String species, String name){
        Animal animal;
        if (species == null){
            animal = addAnimal();
        }else if (name == null){
            animal = addAnimal(species);
        } else {
            animal = addAnimal(species, name);
        }
        return animal;
    }

    public List<Animal> generateRandomAnimals(){
        int numAnimals = new Random().nextInt(15)+2;
        for (int i=0; i<numAnimals; i++){
            addAnimalToList(AnimalRandomizerUtils.createRandomAnimal());
        }
        return animals;
    }
    public Animal getAnimalById (int id){
        for (Animal a : animals){
            if (id == a.id()) {
                return a;
            }
        }
    return null;
    }


}
