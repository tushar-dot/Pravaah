package com.pravaah.auth_service.controller;

import com.pravaah.auth_service.dto.CaseDTO;
import com.pravaah.auth_service.dto.LoginRequest;
import com.pravaah.auth_service.service.AuthService;
import com.pravaah.auth_service.service.CaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/case")
@CrossOrigin(origins = "http://localhost:5173")

public class CaseController {
    private final CaseService caseService;

    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    @PostMapping("/create-case")
    public ResponseEntity<String> login(@RequestBody CaseDTO caseRequest){
        System.out.println("Called");
        return ResponseEntity.ok("Case created successfully.");
    }

}
