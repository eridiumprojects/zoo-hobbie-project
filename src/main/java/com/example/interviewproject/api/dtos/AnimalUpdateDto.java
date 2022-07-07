package com.example.interviewproject.api.dtos;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Data
@Validated
public class AnimalUpdateDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String host;
}
