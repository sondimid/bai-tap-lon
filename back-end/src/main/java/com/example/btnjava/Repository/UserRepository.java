package com.example.btnjava.Repository;

import com.example.btnjava.Model.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByEmail(String email);
    boolean existsByUserName(String username);
    Optional<UserEntity> findByUserName(String username);
    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByResetToken(String token);
}
