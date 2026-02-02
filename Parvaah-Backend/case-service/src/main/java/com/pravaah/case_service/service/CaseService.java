package com.pravaah.case_service.service;

import com.pravaah.case_service.dto.CaseDTO;
import com.pravaah.case_service.entity.Case;
import com.pravaah.case_service.repo.CaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CaseService {
    private CaseRepository caseRepository;

    public CaseService(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    public CaseDTO createCase(CaseDTO caseRequest) {

        Case newCase = new Case();

        newCase.setCaseNumber(generateCaseNumber());
        newCase.setCaseTypeId(caseRequest.getCaseTypeId());
        newCase.setComplaint(caseRequest.getComplaint());
        newCase.setPriorityId(caseRequest.getPriorityId());
        newCase.setStatus("Open");
        newCase.setCreatedAt(LocalDateTime.now());
        newCase.setCreatedBy("System");
        newCase.setUpdatedAt(LocalDateTime.now());
        newCase.setUpdatedBy("System");

        Case savedCase = caseRepository.save(newCase);

        // 🔁 Entity → DTO mapping
        CaseDTO responseDto = new CaseDTO();
        responseDto.setCaseId(savedCase.getCaseId());
        responseDto.setCaseNumber(savedCase.getCaseNumber());
        responseDto.setCaseTypeId(savedCase.getCaseTypeId());
        responseDto.setPriorityId(savedCase.getPriorityId());
        responseDto.setComplaint(savedCase.getComplaint());
        responseDto.setStatus(savedCase.getStatus());
        responseDto.setCreatedAt(savedCase.getCreatedAt());

        return responseDto;
    }


    private String generateCaseNumber() {
        return "CASE-" + System.currentTimeMillis();
    }

    public List<CaseDTO> getAllCases() {

        return caseRepository.findAll()
                .stream()
                .map(c -> {
                    CaseDTO dto = new CaseDTO();
                    dto.setCaseId(c.getCaseId());
                    dto.setCaseNumber(c.getCaseNumber());
                    dto.setStatus(c.getStatus());
                    dto.setCreatedAt(c.getCreatedAt());
                    dto.setPriorityId(c.getPriorityId());
                    return dto;
                })
                .toList();
    }

}
