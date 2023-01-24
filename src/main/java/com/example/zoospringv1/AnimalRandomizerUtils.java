package com.example.zoospringv1;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class AnimalRandomizerUtils {
    private static final String[] NAMES = {"John", "Sam", "Tom", "Peter", "Tim", "Richard", "Bob", "Jane", "Sarah", "Tina"};
    private static final String[] SPECIES = {"lion", "bear", "monkey", "elephant", "giraffe", "zebra", "panda", "parrot"};
    private static AtomicLong COUNTER = new AtomicLong();
    public static Animal createRandomAnimal() {
        String species = AnimalRandomizerUtils.getRandomSpecies();
        return  createRandomSpecies(species);
    }
    public static Animal createRandomSpecies(String species) {
        String name = AnimalRandomizerUtils.getRandomName();
        return createAnimalSpeciesName(species,name);
    }
    public static Animal createAnimalSpeciesName (String species, String name){
        int id = AnimalRandomizerUtils.getNextId();
        return new Animal (id,species,name);
    }
    private static int getNextId(){
        return (int) COUNTER.incrementAndGet();
    }
    private static String getRandomName() {
        return NAMES[new Random().nextInt(NAMES.length)];
    }
    private static String getRandomSpecies() {
        return SPECIES[new Random().nextInt(SPECIES.length)];
    }

}
