package com.example.zoospringv1;

import java.util.List;
public record Zoo (String name, String city, List<Animal> animals) {
}
