package com.example.interviewproject.api.views;

import lombok.Data;

import java.util.List;

@Data
public class AnimalView {
    private Long id;
    private List<String> species;
    private String birth;
    private String sex;
    private String name;

}
