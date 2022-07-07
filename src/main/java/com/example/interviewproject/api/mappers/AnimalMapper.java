package com.example.interviewproject.api.mappers;

import com.example.interviewproject.api.dtos.AnimalDto;
import com.example.interviewproject.api.views.AnimalView;
import com.example.interviewproject.domain.entities.Animal;
import com.example.interviewproject.domain.entities.User;
import com.example.interviewproject.domain.repos.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimalMapper {
    public AnimalView toView(Animal animal) {
        AnimalView animalView = new AnimalView();
        animalView.setSpecies(animal.getSpecies());
        animalView.setBirth(animal.getBirth());
        animalView.setSex(animal.getSex());
        animalView.setName(animal.getName());
        animalView.setId(animal.getId());
//        animalView.setHost(animal.getHost());
        return animalView;

    }

    public List<AnimalView> toViews(List<Animal> animals) {
        return animals.stream().map(this::toView).toList();
    }

    public Animal toAnimal(AnimalDto animalDto) {
        Animal animal = new Animal();
        animal.setSpecies(animalDto.getSpecies());
        animal.setSex(animalDto.getSex());
        animal.setName(animalDto.getName());
        animal.setBirth(animalDto.getBirth());
//        animal.setHost(animalDto.getHost());
//        animal.setUser(userService.get(animalDto.getHost());
        return animal;
    }
}
