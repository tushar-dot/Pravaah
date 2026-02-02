package com.pravaah.auth_service.dto;
import com.pravaah.auth_service.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MeResponse {
    private Long userId;
    private String username;
    private String email;
    private String role;
    private List<MenuDto> menus;

    public MeResponse(User user, List<MenuDto> menus) {
        this.userId = user.getUserId();
        this.email = user.getEmailId();
        this.username = user.getUserName();
        this.role = String.valueOf(user.getRole());
        this.menus = menus;
    }
}
