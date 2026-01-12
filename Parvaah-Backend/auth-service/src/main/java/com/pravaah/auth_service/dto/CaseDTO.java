package com.pravaah.auth_service.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaseDTO {
    private int caseTypeId;
    private int priorityId;
    private String caseTitle;
    private String caseDesc;
    private int assignedTo;

}
