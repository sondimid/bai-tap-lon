package com.example.btnjava.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "role")
@Getter
@Setter
public class RoleEntity extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "roleEntity", cascade = CascadeType.ALL)
    private List<UserEntity> userEntities;
}
