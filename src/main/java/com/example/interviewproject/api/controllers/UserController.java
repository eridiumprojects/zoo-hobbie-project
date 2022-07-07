package com.example.interviewproject.api.controllers;

import com.example.interviewproject.api.dtos.UserDto;
import com.example.interviewproject.api.mappers.UserMapper;
import com.example.interviewproject.api.views.UserView;
import com.example.interviewproject.domain.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;
    public final UserMapper userMapper;
    @PostMapping(value = "/register",consumes = "application/json")
    public UserView register(@Valid @RequestBody UserDto userDto) {
        return userMapper.toView(userService.register(userDto));
    }
}
