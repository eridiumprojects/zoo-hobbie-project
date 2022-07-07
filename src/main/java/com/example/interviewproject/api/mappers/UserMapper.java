package com.example.interviewproject.api.mappers;

import com.example.interviewproject.api.views.UserView;
import com.example.interviewproject.domain.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    public UserView toView(User user) {
        UserView userView = new UserView();
        userView.setUsername(user.getUsername());
        userView.setPassword(user.getPassword());
        userView.setAnimals(user.getAnimals());
        return userView;
    }
}
