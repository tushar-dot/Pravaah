package com.pravaah.auth_service.service;

import com.pravaah.auth_service.dto.MeResponse;
import com.pravaah.auth_service.dto.MenuDto;
import com.pravaah.auth_service.entity.User;
import com.pravaah.auth_service.repo.MenuRepository;
import com.pravaah.auth_service.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MeService {

    private final MenuRepository menuRepository;

    private final UserRepository userRepository;

    public MeService(MenuRepository menuRepository, UserRepository userRepository) {
        this.menuRepository = menuRepository;
        this.userRepository = userRepository;
    }

    public MeResponse getMenuByEmail(String email) {

        User user = userRepository.findByEmailId(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        log.info(user.getEmailId() + "-----" + user.getRole());
        List<MenuDto> menus =
                menuRepository.findMenusByRole(String.valueOf(user.getRole()));

        return new MeResponse(user, menus);
    }

}
