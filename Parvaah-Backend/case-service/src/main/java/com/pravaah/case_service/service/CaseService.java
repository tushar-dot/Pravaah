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
    public Case createCase(CaseDTO caseRequest){
        Case newCase = new Case();

        newCase.setCaseNumber(generateCaseNumber());
        newCase.setComplaint((caseRequest.getCaseDesc()));
        newCase.setPriorityId(caseRequest.getPriorityId());
        newCase.setStatus("Open");
        newCase.setCreatedAt(LocalDateTime.now());
        newCase.setCreatedBy("System");
        newCase.setUpdatedAt(LocalDateTime.now());
        newCase.setUpdatedBy("System");

        caseRepository.save(newCase);
        return newCase;
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
                    dto.setCaseDesc(c.getComplaint());
                    dto.setPriorityId(c.getPriorityId());
                    return dto;
                })
                .toList();
    }

}
