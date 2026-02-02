package com.pravaah.case_service.controller;

import com.pravaah.case_service.dto.ApiResponse;
import com.pravaah.case_service.dto.CaseDTO;
import com.pravaah.case_service.dto.CaseTypeDTO;
import com.pravaah.case_service.service.CaseTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("case-type")
public class CaseTypeController {

    private final CaseTypeService caseTypeService;

    public CaseTypeController(CaseTypeService caseTypeService){
        this.caseTypeService = caseTypeService;
    }

    @GetMapping("/getAllCaseTypes")
    public ResponseEntity<ApiResponse<List<CaseTypeDTO>>> getAllCaseTypes(){
        List<CaseTypeDTO> caseTypes = caseTypeService.getAllCaseTypes();
        ApiResponse<List<CaseTypeDTO>> response =
                new ApiResponse<>(200, "Fetched Case Types succesfully", caseTypes);
        return ResponseEntity.ok(response);
    }
}
