package com.example.interviewproject.api.views;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserView {
    private String username;
    @JsonIgnore
    private String password;
    private String roles;
}
