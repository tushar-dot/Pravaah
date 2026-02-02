package com.pravaah.auth_service.controller;

import com.pravaah.auth_service.dto.MeResponse;
import com.pravaah.auth_service.entity.User;
import com.pravaah.auth_service.service.MeService;
import lombok.extern.java.Log;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.internal.Logger;

@RestController
@RequestMapping("/api")
public class MenuController {
    private final MeService meService;
    private static final Logger log = Logger.getLogger(MenuController.class.getName());

    public MenuController(MeService meService) {
        this.meService = meService;
    }
    @GetMapping("/menu")
    public MeResponse getMe(Authentication authentication) {

        String email = authentication.getName();
        log.debug("email :" + email);

        return meService.getMenuByEmail(email);
    }
}
