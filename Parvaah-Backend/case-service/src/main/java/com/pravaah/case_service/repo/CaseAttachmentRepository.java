package com.pravaah.case_service.repo;

import com.pravaah.case_service.entity.Case;
import com.pravaah.case_service.entity.CaseAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseAttachmentRepository extends JpaRepository<CaseAttachment, Long> {

    List<CaseAttachment> findByCaseEntity(Case caseEntity);
}
