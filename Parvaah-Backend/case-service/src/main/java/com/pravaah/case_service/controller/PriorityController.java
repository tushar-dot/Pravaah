package com.pravaah.case_service.controller;

import com.pravaah.case_service.dto.ApiResponse;
import com.pravaah.case_service.dto.CaseTypeDTO;
import com.pravaah.case_service.dto.PriorityDTO;
import com.pravaah.case_service.service.PriorityService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/priority")
public class PriorityController {

    private final PriorityService priorityService;

    public PriorityController(PriorityService priorityService){
        this.priorityService = priorityService;
    }

    @GetMapping("/getPriorities")
    public ResponseEntity<ApiResponse<List<PriorityDTO>>> getPriorities(Authentication authentication){
        List<PriorityDTO> priority = priorityService.getPriorities();
        ApiResponse<List<PriorityDTO>> response =
                new ApiResponse<>(200, "Priorities fetched successfully", priority);
        return ResponseEntity.ok(response);
    }
}
