package com.pravaah.auth_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String userName;
    private String emailId;
    private String password;
    private String role;

}
