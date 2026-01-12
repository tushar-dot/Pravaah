package com.pravaah.auth_service.controller;

import com.pravaah.auth_service.dto.LoginRequest;
import com.pravaah.auth_service.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){
        System.out.println("Called");
        return ResponseEntity.ok(authService.login(request.getEmailId(), request.getPassword()));
    }

    @GetMapping("/hi")
    public ResponseEntity<String> sayHi(Authentication authentication) {

        String email = authentication.getName();

        return ResponseEntity.ok("Hi " + email);
    }



}
