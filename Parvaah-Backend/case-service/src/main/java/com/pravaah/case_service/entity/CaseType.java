package com.pravaah.case_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "case_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "case_type_id")
    private int casetypeId;

    @Column(name = "case_type_name")
    private String caseTypeName;
}
