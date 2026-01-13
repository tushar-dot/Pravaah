package com.pravaah.auth_service.service;

import com.pravaah.auth_service.dto.CaseDTO;
import com.pravaah.auth_service.entity.Case;
import com.pravaah.auth_service.repo.CaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CaseService {
    private CaseRepository caseRepository;

    public CaseService(CaseRepository caseRepository){
        this.caseRepository =  caseRepository;
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
}
