package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping
    public List<Integer> getAnimalKeys(){
        List<Integer> keys = new ArrayList<>();
        for(Map.Entry<Integer,Animal> entry : animals.entrySet()){
            keys.add(entry.getKey());
        }

        return keys;
    }

    @GetMapping("/{id}")
    public Animal getAnimalByID(@PathVariable int id){
        return animals.get(id);
    }

    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal){
        animals.put(animal.getId(),animal);
        return animal;
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id,@RequestBody Animal animal){
        animals.put(id,animal);
        return animal;
    }

    @DeleteMapping("/{id}")
    public Animal deleteAnimal(@PathVariable int id){
        return animals.remove(id);
    }
}
