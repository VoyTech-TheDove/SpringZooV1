package com.example.zoospringv1.animal;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class AnimalRandomizerUtils {
    private static final String[] NAMES = {"John", "Sam", "Tom", "Peter", "Tim", "Richard", "Bob", "Jane", "Sarah", "Tina"};
    private static final String[] SPECIES = {"lion", "bear", "monkey", "elephant", "giraffe", "zebra", "panda", "parrot"};
    private static AtomicLong COUNTER = new AtomicLong();

    public static Animal createRandomAnimal() {
        return createAnimalSpeciesName(null, null);
    }

    public static Animal createAnimalSpeciesName(String species, String name) {
        return new Animal(getNextId(), randomSpeciesIfNull(species), randomNameIfNull(name));
    }

    public static String randomSpeciesIfNull(String species) {
        return (species == null) ? AnimalRandomizerUtils.getRandomSpecies() : species;
    }

    public static String randomNameIfNull(String name) {
        return (name == null) ? AnimalRandomizerUtils.getRandomName() : name;
    }

    private static int getNextId() {
        return (int) COUNTER.incrementAndGet();
    }

    private static String getRandomName() {
        return NAMES[new Random().nextInt(NAMES.length)];
    }

    private static String getRandomSpecies() {
        return SPECIES[new Random().nextInt(SPECIES.length)];
    }

}
