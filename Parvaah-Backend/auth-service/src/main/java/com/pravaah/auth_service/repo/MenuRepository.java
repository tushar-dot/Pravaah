package com.pravaah.auth_service.repo;

import com.pravaah.auth_service.dto.MenuDto;
import com.pravaah.auth_service.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu,Long> {

    @Query("""
SELECT new com.pravaah.auth_service.dto.MenuDto(
    m.code, m.label, m.route, m.icon
)
FROM RoleMenu rm
JOIN rm.menu m
WHERE rm.roleName = :role
  AND rm.isActive = true
  AND m.enabled = true
ORDER BY m.orderNo
""")
    List<MenuDto> findMenusByRole(@Param("role") String role);
}
