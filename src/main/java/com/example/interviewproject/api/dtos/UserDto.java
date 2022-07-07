package com.example.interviewproject.api.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
@Validated
public class UserDto {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String roles;
}
