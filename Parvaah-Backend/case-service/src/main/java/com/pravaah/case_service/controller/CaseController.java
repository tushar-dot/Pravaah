package com.pravaah.case_service.controller;

import com.pravaah.case_service.dto.ApiResponse;
import com.pravaah.case_service.dto.CaseDTO;
import com.pravaah.case_service.service.CaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<Void>> createCase(@RequestBody CaseDTO caseRequest) {
        caseService.createCase(caseRequest);
        ApiResponse<Void> response =
                new ApiResponse<>(201, "Case created successfully", null);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/allCases")
    public ResponseEntity<ApiResponse<List<CaseDTO>>> getAllCases() {
        List<CaseDTO> cases = caseService.getAllCases();
        ApiResponse<List<CaseDTO>> response =
                new ApiResponse<>(200, "Fetched successfully", cases);

        return ResponseEntity.ok(response);
    }


}
