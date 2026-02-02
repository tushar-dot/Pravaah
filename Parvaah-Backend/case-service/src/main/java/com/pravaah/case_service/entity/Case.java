package com.pravaah.case_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "create_case")
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "case_id")
    private long caseId;

    @Column(name = "case_type_id")
    private int caseTypeId;

    @Column(name = "case_number", unique = true, nullable = false)
    private String caseNumber;

    @Column(name = "complaint")
    private String complaint;

    @Column(name = "priority_id")
    private int priorityId;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private LocalDateTime  createdAt;

    @Column(name = "created_on")
    private String createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

}
