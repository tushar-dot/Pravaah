package com.pravaah.case_service.service;

import com.pravaah.case_service.dto.MenuDTO;
import com.pravaah.case_service.entity.Menu;
import com.pravaah.case_service.repo.RoleMenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    private final RoleMenuRepository roleMenuRepository;

    public MenuService(RoleMenuRepository roleMenuRepository){
        this.roleMenuRepository = roleMenuRepository;
    }

    public List<MenuDTO> getMenuByRole(String role) {

        List<Menu> menus = roleMenuRepository.findMenusByRole(role);

        return menus.stream()
                .map(menu -> new MenuDTO(
                        menu.getMenuCode(),
                        menu.getLabel(),
                        menu.getDisplayOrder()
                ))
                .toList();
    }

}
