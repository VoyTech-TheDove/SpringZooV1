package com.example.zoospringv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalRespositoryUtils {
    private static List<Animal> animals = new ArrayList<>();

    public static List<Animal> generateRandomAnimals() {
        int numAnimals = new Random().nextInt(15) + 2;
        for (int i = 0; i < numAnimals; i++) {
            animals.add(AnimalRandomizerUtils.createRandomAnimal());
        }
        return animals;
    }

    public static List<Animal> returnAnimals() {
        return animals;
    }

    public static Animal getAnimalById(int id) {
        System.out.println(id);
        for (Animal a : animals) {
            if (id == a.id()) {
                return a;
            }
        }
        return null;
    }

    public static Animal addAnimal(String species) {
        Animal animal = AnimalRandomizerUtils.createRandomSpecies(species);
        animals.add(animal);
        return animal;
    }

    public static Animal addAnimal(String species, String name) {
        Animal animal = AnimalRandomizerUtils.createAnimalSpeciesName(species, name);
        animals.add(animal);
        return animal;
    }
}
