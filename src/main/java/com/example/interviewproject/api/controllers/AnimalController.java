package com.example.interviewproject.api.controllers;

import com.example.interviewproject.api.dtos.AnimalDto;
import com.example.interviewproject.api.mappers.AnimalMapper;
import com.example.interviewproject.api.views.AnimalView;
import com.example.interviewproject.domain.services.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/api/animals")
@RequiredArgsConstructor
public class AnimalController {
    public final AnimalService animalService;
    public final AnimalMapper animalMapper;

    @GetMapping(value = "/{animalId}", produces = "application/json")
    public AnimalView getAnimalById(@PathVariable Long animalId) {
        return animalMapper.toView(animalService.getById(animalId));
    }

    @GetMapping(value = "/", produces = "application/json")
    public List<AnimalView> getAnimals() {
        return animalMapper.toViews(animalService.getAnimals());
    }

    @PostMapping(value = "", consumes = "application/json")
    public AnimalView saveAnimal(@Valid @RequestBody AnimalDto animalDto) {
        return animalMapper.toView(animalService.saveAnimal(animalMapper.toAnimal(animalDto)));
    }

    @DeleteMapping(value = "/delete/{animalId}", produces = "application/json")
    public void deleteAnimalById(@Valid @PathVariable Long animalId) {
        animalService.deleteAnimalById(animalId);
    }

    @PutMapping(value = "/update/{animalId}", produces = "application/json")
    public void updateAnimalById(@PathVariable Long animalId, @Valid @RequestBody AnimalDto animalDto) {
        animalService.updateAnimalById(animalId, animalDto);
    }
}
