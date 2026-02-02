package com.pravaah.case_service.service;

import com.pravaah.case_service.entity.CaseAttachment;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CaseAttachmentService {
    void saveAttachment(Long caseId, MultipartFile file) throws IOException;

//    CaseAttachment getAttachment(Long attachmentId);

//    List<CaseAttachment> getAttachmentsByCaseId(Long caseId);

}
