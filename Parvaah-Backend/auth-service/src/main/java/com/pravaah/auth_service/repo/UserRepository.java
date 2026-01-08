package com.pravaah.auth_service.repo;

import com.pravaah.auth_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository {
    Optional<User> findByUserName(String userName);
}
