package com.pravaah.case_service.controller;

import com.pravaah.case_service.dto.ApiResponse;
import com.pravaah.case_service.dto.CaseDTO;
import com.pravaah.case_service.entity.Case;
import com.pravaah.case_service.service.CaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/case")
@CrossOrigin(origins = "http://localhost:5173")

public class CaseController {
    private final CaseService caseService;

    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    @PostMapping("/create-case")
    public ResponseEntity<ApiResponse<CaseDTO>> createCase(Authentication authentication,
            @RequestBody CaseDTO caseRequest) {

        CaseDTO savedCase = caseService.createCase(caseRequest);

        ApiResponse<CaseDTO> response =
                new ApiResponse<>(201, "Case created successfully", savedCase);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }



    @GetMapping("/allCases")
    public ResponseEntity<ApiResponse<List<CaseDTO>>> getAllCases(Authentication authentication) {
        System.out.println(authentication.getName());
        List<CaseDTO> cases = caseService.getAllCases();
        ApiResponse<List<CaseDTO>> response =
                new ApiResponse<>(200, "Fetched successfully", cases);

        return ResponseEntity.ok(response);
    }


}
