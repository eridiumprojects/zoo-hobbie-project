package com.example.interviewproject.domain.services;

import com.example.interviewproject.api.dtos.AnimalUpdateDto;
import com.example.interviewproject.domain.entities.Animal;
import com.example.interviewproject.domain.repos.AnimalRepository;
import com.example.interviewproject.domain.repos.UserRepository;
import com.example.interviewproject.exceptions.AnimalAlreadyExistsException;
import com.example.interviewproject.exceptions.AnimalNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimalService {
    public final AnimalRepository animalRepository;
    public final UserRepository userRepository;


    public Animal getById(Long animalId) {
        return animalRepository.findById(animalId).
                orElseThrow(() -> new AnimalNotFoundException("The animal with such ID was not found"));
    }

    public Animal saveAnimal(Animal animal) {
        isNameUnique(animal.getName());
        if (!(someTests(animal.getSpecies(), animal.getSex(), animal.getBirth()))) {
            throw new AnimalNotFoundException("Invalid data. Try again");
        }

        return animalRepository.save(animal);
    }

    public void deleteAnimalById(Long animalId) {
        animalRepository.findById(animalId).
                orElseThrow(() -> new AnimalNotFoundException("The animal with such ID was not found"));
        animalRepository.deleteById(animalId);
    }

    public void updateAnimalById(Long animalId, AnimalUpdateDto animalUpdateDto) {
        Animal animal = animalRepository.findById(animalId).
                orElseThrow(() -> new AnimalNotFoundException("The animal with such ID was not found"));
        animal.setName(animalUpdateDto.getName());
        animal.setUser(userRepository.findByUsername(animalUpdateDto.getHost())
                .orElseThrow(() -> new UsernameNotFoundException("Not found...")));
        animalRepository.save(animal);
    }

    public void isNameUnique(String name) {
        Optional<Animal> animalOptional = animalRepository.findByName(name);
        if (animalOptional.isPresent()) {
            throw new AnimalAlreadyExistsException("An animal with that name already exists");
        }
    }

    public boolean someTests(String species, String sex, String birth) {
        List<String> speciesList = List.of("Cat", "Dog", "Mouse", "Tiger", "Bear");
        int counter = 0;
        for (String s : speciesList) {
            if (Objects.equals(species, s)) {
                counter++;
                break;
            }
        }
        List<String> sexList = List.of("Male", "Female");
        for (String x : sexList) {
            if (Objects.equals(sex, x)) {
                counter++;
            }
        }
        if ((birth.length() == 10)) {
            counter++;
        }
        return counter == 3;
    }
}
