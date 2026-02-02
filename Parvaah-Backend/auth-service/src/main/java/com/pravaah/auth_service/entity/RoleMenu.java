package com.pravaah.auth_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "role_menu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "menu_code",              // existing column
            referencedColumnName = "code",   // Menu.code
            insertable = false,
            updatable = false
    )
    private Menu menu;

    @Column(name = "menu_code")
    private String menuCode;

    private Boolean isActive = true;
}

