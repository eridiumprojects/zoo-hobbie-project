package com.example.interviewproject.domain.repos;

import com.example.interviewproject.domain.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {
    Optional<Animal> findByName(String name);

    Optional<Animal> findBySpecies(String species);

    @Query("select an from animal an where an.user.id = :uId")
    List<Animal> getAnimalsByUserId(@Param("uId") Long userId);
}
