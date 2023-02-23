package com.example.zoospringv1.zoo;

import com.example.zoospringv1.animal.Animal;

import java.util.List;
public record Zoo (String name, String city, List<Animal> animals) {
}
