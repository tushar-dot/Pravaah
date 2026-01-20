package com.pravaah.case_service.controller;

import com.pravaah.case_service.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
@CrossOrigin(origins = "http://localhost:5173")

public class CommonController {
    private final MenuService menuService;

    public CommonController(MenuService menuService){
        this.menuService = menuService;
    }

    @GetMapping("/getMenu")
    public ResponseEntity<String> getMenu(Authentication authentication){
        if (authentication == null) {
            System.out.println("AUTH IS NULL ❌");
        } else {
            System.out.println("AUTH OK ✅");
            authentication.getAuthorities()
                    .forEach(a -> System.out.println(a.getAuthority()));
        }


//        String role = authentication.getAuthorities()
//                .iterator()
//                .next()
//                .getAuthority();
        return ResponseEntity.ok("Successful");
    }


}
