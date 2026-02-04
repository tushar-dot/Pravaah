package com.pravaah.case_service.controller;

import com.pravaah.case_service.dto.ApiResponse;
import com.pravaah.case_service.dto.CaseDTO;
import com.pravaah.case_service.service.CaseAttachmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/attachment")
public class CaseAttachmentController {

    private final CaseAttachmentService attachmentService;

    public CaseAttachmentController(CaseAttachmentService attachmentService){
        this.attachmentService = attachmentService;
    }

    @PostMapping("saveAttachment")
    public ResponseEntity<ApiResponse<String>> saveAttachment(
            @RequestParam Long caseId, @RequestParam MultipartFile file, Authentication authentication) throws IOException{

        attachmentService.saveAttachment(caseId, file);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(201, "Attachment saved successfully.", null));

    }

}
