package com.pravaah.auth_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class MenuDto {
    private String code;
    private String label;
    private String route;
    private String icon;
    public MenuDto(String code, String label, String route, String icon) {
        this.code = code;
        this.label = label;
        this.route = route;
        this.icon = icon;
    }
}
