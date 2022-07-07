package com.example.interviewproject.api.controllers;

import com.example.interviewproject.api.dtos.AnimalDto;
import com.example.interviewproject.api.dtos.AnimalUpdateDto;
import com.example.interviewproject.api.mappers.AnimalMapper;
import com.example.interviewproject.api.views.AnimalView;
import com.example.interviewproject.domain.entities.MyUserDetails;
import com.example.interviewproject.domain.repos.AnimalRepository;
import com.example.interviewproject.domain.services.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/api/animals")
@RequiredArgsConstructor
public class AnimalController {
    public final AnimalService animalService;
    public final AnimalMapper animalMapper;
    public final AnimalRepository animalRepository;

    @GetMapping(value = "/{animalId}", produces = "application/json")
    public AnimalView getAnimalById(@PathVariable Long animalId, @AuthenticationPrincipal MyUserDetails userDetails) {
        return animalMapper.toView(animalService.getById(animalId));
    }

    @GetMapping(value = "/{userId}/animals", produces = "application/json")
    public List<AnimalView> getUserAnimals(@PathVariable Long userId, @AuthenticationPrincipal MyUserDetails userDetails) {
        return animalMapper.toViews(animalRepository.getAnimalsByUserId(userId));
    }

    @PostMapping(value = "", consumes = "application/json")
    public AnimalView saveAnimal(@Valid @RequestBody AnimalDto animalDto, @AuthenticationPrincipal MyUserDetails userDetails) {
        return animalMapper.toView(animalService.saveAnimal(animalMapper.toAnimal(animalDto)));
    }

    @DeleteMapping(value = "/delete/{animalId}", produces = "application/json")
    public void deleteAnimalById(@Valid @PathVariable Long animalId, @AuthenticationPrincipal MyUserDetails userDetails) {
        animalService.deleteAnimalById(animalId);
    }

    @PutMapping(value = "/update/{animalId}", produces = "application/json")
    public void updateAnimalById(@PathVariable Long animalId, @Valid @RequestBody AnimalUpdateDto animalUpdateDto,
                                 @AuthenticationPrincipal MyUserDetails userDetails) {
        animalService.updateAnimalById(animalId, animalUpdateDto);
    }
}
