package com.pravaah.case_service.repo;

import com.pravaah.case_service.entity.Menu;
import com.pravaah.case_service.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMenuRepository extends JpaRepository<Role, Long> {
    @Query("""
        SELECT r.menu
        FROM Role r
        WHERE r.roleName = :role
        AND r.isActive = true
        AND r.menu.isActive = true
        ORDER BY r.menu.displayOrder
    """)
    List<Menu> findMenusByRole(@Param("role") String role);
}
