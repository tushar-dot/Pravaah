package com.pravaah.auth_service.entity;

import com.pravaah.auth_service.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "user_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "email_id", unique = true, nullable = false)
    private String emailId;

    @Column(nullable = false)
    private String password;

    @Column(name = "status_id")
    private int statusId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_on")
    private Date updatedOn;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", nullable = true)
    private Role role;
}


