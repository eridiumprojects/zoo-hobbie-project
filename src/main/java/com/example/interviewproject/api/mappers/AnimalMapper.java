package com.example.interviewproject.api.mappers;

import com.example.interviewproject.api.dtos.AnimalDto;
import com.example.interviewproject.api.views.AnimalView;
import com.example.interviewproject.domain.entities.Animal;
import com.example.interviewproject.domain.entities.User;
import com.example.interviewproject.domain.repos.UserRepository;
import com.example.interviewproject.domain.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AnimalMapper {

    public final UserService userService;

    public AnimalView toView(Animal animal) {
        AnimalView animalView = new AnimalView();
        animalView.setSpecies(animal.getSpecies());
        animalView.setBirth(animal.getBirth());
        animalView.setSex(animal.getSex());
        animalView.setName(animal.getName());
        animalView.setId(animal.getId());
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
        animal.setUser(userService.getUser(animalDto.getHost()));
        return animal;
    }
}
