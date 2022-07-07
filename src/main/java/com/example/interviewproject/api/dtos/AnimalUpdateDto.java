package com.example.interviewproject.api.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AnimalUpdateDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String host;
}
