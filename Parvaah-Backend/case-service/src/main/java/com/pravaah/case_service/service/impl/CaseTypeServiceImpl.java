package com.pravaah.case_service.service.impl;

import com.pravaah.case_service.dto.CaseTypeDTO;
import com.pravaah.case_service.repo.CaseTypeRepository;
import com.pravaah.case_service.service.CaseTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaseTypeServiceImpl implements CaseTypeService {

    private final CaseTypeRepository caseTypeRepository;

    public CaseTypeServiceImpl(CaseTypeRepository caseTypeRepository){
        this.caseTypeRepository = caseTypeRepository;
    }

    @Override
    public List<CaseTypeDTO> getAllCaseTypes(){
        return caseTypeRepository.findAll().stream()
                .map(caseType -> new CaseTypeDTO(
                        caseType.getCasetypeId(),
                        caseType.getCaseTypeName()
                ))
                .collect(Collectors.toList());
    }
}
