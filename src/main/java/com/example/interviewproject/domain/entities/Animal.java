package com.example.interviewproject.domain.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Accessors(chain = true)
@Entity(name = "animal")
@Table(name = "animals")

public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ElementCollection
    @Column(name = "species")
    private List<String> species;
    @Column(name = "birth")
    private String birth;
    @Column(name = "sex")
    private String sex;
    @Column(name = "name", unique = true)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return species.equals(animal.species) && birth.equals(animal.birth) && sex.equals(animal.sex) && name.equals(animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, birth, sex, name);
    }
}
