package com.example.interviewproject.api.views;

import com.example.interviewproject.domain.entities.Animal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.catalina.LifecycleState;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class UserView {
    private String username;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private List<Animal> animals;
}
