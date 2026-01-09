package com.pravaah.auth_service.config;

import com.pravaah.auth_service.entity.User;
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

        String username = "sanyasingh"; // EXACT match with DB

        if (userRepository.findByUserName(username).isPresent()) {
            return;
        }

        User u = new User();
        u.setUserName(username);
        u.setEmailId("sanyasingh@gmail.com");
        u.setPassword(passwordEncoder.encode("password123"));

        userRepository.save(u);

        System.out.println("✅ Test user created");
    }

}
