package com.pravaah.case_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Entity
@Table(name = "case_attachment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaseAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attachment_id")
    private long attachmentId;

//    @Column(name = "case_id")
//    private long caseId;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "case_id", nullable = false)
private Case caseEntity;


    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_size")
    private Long fileSize;

    @Lob
    @JdbcTypeCode(SqlTypes.BINARY)
    @Column(name = "file_data", columnDefinition = "BYTEA")
    private byte[] fileData;


    @Column(name = "uploaded_at")
    private LocalDateTime uploadedAt;
}
