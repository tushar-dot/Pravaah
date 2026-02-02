package com.pravaah.case_service.repo;

import com.pravaah.case_service.entity.CaseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseTypeRepository extends JpaRepository<CaseType, Integer> {
}
