package com.pravaah.case_service.repo;

import com.pravaah.case_service.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Integer> {
}
