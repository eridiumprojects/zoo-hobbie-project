package com.example.interviewproject.api.views;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.query.criteria.internal.ValueHandlerFactory;
import org.springframework.core.SpringVersion;

import javax.persistence.JoinColumn;
import java.util.List;

@Data
public class AnimalView {
    private Long id;
    private String species;
    private String birth;
    private String sex;
    private String name;
//    @JsonIgnore
//    private Long host;

}
