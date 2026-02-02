package com.pravaah.case_service.service.impl;

import com.pravaah.case_service.dto.PriorityDTO;
import com.pravaah.case_service.repo.PriorityRepository;
import com.pravaah.case_service.service.PriorityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PriorityServiceImpl implements PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityServiceImpl(PriorityRepository priorityRepository){
        this.priorityRepository = priorityRepository;
    }

    @Override
    public List<PriorityDTO> getPriorities() {
        return priorityRepository.findAll().stream()
                .map(priority -> new PriorityDTO(
                        priority.getPriorityId(),
                        priority.getPriorityCode()
                ))
                .collect(Collectors.toList());
    }
}
