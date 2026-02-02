package com.pravaah.case_service.service.impl;

import com.pravaah.case_service.entity.Case;
import com.pravaah.case_service.entity.CaseAttachment;
import com.pravaah.case_service.repo.CaseAttachmentRepository;
import com.pravaah.case_service.repo.CaseRepository;
import com.pravaah.case_service.service.CaseAttachmentService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CaseAttachmentServiceImpl implements CaseAttachmentService{

    private final CaseAttachmentRepository attachmentRepository;

    private final CaseRepository caseRepository;

    public CaseAttachmentServiceImpl(
            CaseAttachmentRepository attachmentRepository,
            CaseRepository caseRepository) {
        this.attachmentRepository = attachmentRepository;
        this.caseRepository = caseRepository;
    }



    @Override
    public void saveAttachment(Long caseId, MultipartFile file) throws IOException {

        Case caseEntity = caseRepository.findById(caseId)
                .orElseThrow(() -> new RuntimeException("Case not found"));

        CaseAttachment attachment = new CaseAttachment();
        attachment.setCaseEntity(caseEntity);   // ✅ FK mapping
        attachment.setFileName(file.getOriginalFilename());
        attachment.setFileType(file.getContentType());
        attachment.setFileSize(file.getSize());
        attachment.setFileData(file.getBytes());
        attachment.setUploadedAt(LocalDateTime.now());

        attachmentRepository.save(attachment);
    }



}
