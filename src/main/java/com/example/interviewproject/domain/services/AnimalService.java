package com.example.interviewproject.domain.services;

import com.example.interviewproject.api.dtos.AnimalDto;
import com.example.interviewproject.domain.entities.Animal;
import com.example.interviewproject.domain.repos.AnimalRepository;
import com.example.interviewproject.exceptions.AnimalAlreadyExistsException;
import com.example.interviewproject.exceptions.AnimalNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimalService {
    public final AnimalRepository animalRepository;

    public Animal getById(Long animalId) {
        return animalRepository.findById(animalId).
                orElseThrow(() -> new AnimalNotFoundException("The animal with such ID was not found"));
    }

    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    public Animal saveAnimal(Animal animal) {
        isNameUnique(animal.getName());
        return animalRepository.save(animal);
    }

    public void deleteAnimalById(Long animalId) {
        animalRepository.findById(animalId).
                orElseThrow(() -> new AnimalNotFoundException("The animal with such ID was not found"));
        animalRepository.deleteById(animalId);
    }

    public void updateAnimalById(Long animalId, AnimalDto animalDto) {
        Animal animal = animalRepository.findById(animalId).
                orElseThrow(() -> new AnimalNotFoundException("The animal with such ID was not found"));
        animal.setBirth(animalDto.getBirth());
        animal.setName(animalDto.getName());
        animal.setSpecies(animalDto.getSpecies());
        animal.setSex(animalDto.getSex());
        animalRepository.save(animal);
    }

    public void isNameUnique(String name) {
        Optional<Animal> animalOptional = animalRepository.findByName(name);
        if (animalOptional.isPresent()) {
            throw new AnimalAlreadyExistsException("An animal with that name already exists");
        }
    }
}
