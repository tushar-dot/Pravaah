package com.pravaah.auth_service.config;

import com.pravaah.auth_service.repo.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void createUser() {

        // Prevent duplicate insert on every restart
        if (userRepository.findByUserName("sanya.singh").isPresent()) {
            return;
        }


    }
}
