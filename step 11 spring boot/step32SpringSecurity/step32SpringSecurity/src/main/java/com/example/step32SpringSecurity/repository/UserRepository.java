package com.example.step32SpringSecurity.repository;

import com.example.step32SpringSecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserRepository, Long> {

    Optional<User> findByUserName(String username);

}
