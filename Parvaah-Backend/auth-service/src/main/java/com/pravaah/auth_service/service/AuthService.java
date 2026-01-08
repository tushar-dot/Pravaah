package com.pravaah.auth_service.service;

import com.pravaah.auth_service.entity.User;
import com.pravaah.auth_service.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private  final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public  String login(String username, String password){
        User user = userRepository.findByUserName(username).orElseThrow(() -> new RuntimeException("User not found."));

        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        return "Login successful";
    }
}
