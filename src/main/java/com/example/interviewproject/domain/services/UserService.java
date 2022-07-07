package com.example.interviewproject.domain.services;

import com.example.interviewproject.api.config.SecurityConfig;
import com.example.interviewproject.api.dtos.UserDto;
import com.example.interviewproject.api.mappers.UserMapper;
import com.example.interviewproject.domain.entities.MyUserDetails;
import com.example.interviewproject.domain.entities.User;
import com.example.interviewproject.domain.repos.UserRepository;
import com.example.interviewproject.exceptions.ObjectAlreadyExistsException;
import com.example.interviewproject.exceptions.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    public final UserRepository userRepository;


    public User register(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRoles(userDto.getRoles());
        isNameUnique(user.getUsername());
        System.out.println("--------------------------------------------");
        System.out.println("The user has been successfully registered!");
        System.out.println("Now you need to log in.");
        return userRepository.save(user);
    }

    public void isNameUnique(String message) {
        Optional<User> userOptional = userRepository.findByUsername(message);
        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException("This name is already exists!");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("Not found" + username)));
        return user.map(MyUserDetails::new).get();
    }

    public User getUser(String host) {
        return userRepository.findByUsername(host).
                orElseThrow(() -> new UsernameNotFoundException("..."));

    }
}
