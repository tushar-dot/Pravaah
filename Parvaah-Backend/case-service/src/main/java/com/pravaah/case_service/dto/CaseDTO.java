package com.pravaah.case_service.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CaseDTO {
    private Long caseId;
    private String caseNumber;
    private String status;
    private LocalDateTime createdAt;
    private String caseTitle;
    private String caseDesc;
    private int priorityId;
    private Integer assignedTo;
    private int caseTypeId;
    private String complaint;


}
