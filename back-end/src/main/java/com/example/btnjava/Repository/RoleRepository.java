package com.example.btnjava.Repository;

import com.example.btnjava.Model.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findByRole(String name);
}
