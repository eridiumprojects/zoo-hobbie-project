package com.example.interviewproject.domain.repos;

import com.example.interviewproject.domain.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {
    Optional<Animal> findByName(String name);
}
