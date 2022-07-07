package com.example.interviewproject.domain.services;

import com.example.interviewproject.api.dtos.AnimalDto;
import com.example.interviewproject.api.dtos.AnimalUpdateDto;
import com.example.interviewproject.api.views.AnimalView;
import com.example.interviewproject.domain.entities.Animal;
import com.example.interviewproject.domain.entities.User;
import com.example.interviewproject.domain.repos.AnimalRepository;
import com.example.interviewproject.domain.repos.UserRepository;
import com.example.interviewproject.exceptions.AnimalAlreadyExistsException;
import com.example.interviewproject.exceptions.AnimalNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
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
        if(!(isSpeciesExist(animal.getSpecies()))) {
            throw new AnimalNotFoundException("Invalid species. Try again");
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

    public boolean isSpeciesExist(String species) {
        List<String> list = getInfoAboutSpecies();
        int size = list.size();
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(species, list.get(i))) {
                flag = true;
                break;
            }
        }
        return flag;
    }


    public List<String> getInfoAboutSpecies() {
        List<String> species = List.of("Cat","Dog","Mouse","Tiger","Bear");
        System.out.println("Species in collection:");
        return species;
    }
}
