package com.pravaah.auth_service.controller;

import com.pravaah.auth_service.dto.LoginRequest;
import com.pravaah.auth_service.dto.LoginResponse;
import com.pravaah.auth_service.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = """
        http://localhost:5173""")
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        String token = authService.login(request.getEmailId(), request.getPassword());
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @GetMapping("/hi")
    public ResponseEntity<String> sayHi(Authentication authentication) {

        String email = authentication.getName();


        return ResponseEntity.ok("Hi " + email);
    }



}
