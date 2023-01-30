package com.example.zoospringv1;

import com.example.zoospringv1.animal.Animal;

import java.util.List;
public record Zoo (String name, String city, List<Animal> animals) {
}
