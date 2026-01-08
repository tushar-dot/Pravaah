package com.pravaah.auth_service.controller;

import com.pravaah.auth_service.dto.LoginRequest;
import com.pravaah.auth_service.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request.getUserName(), request.getPassword()));
    }

}
