package com.example.btnjava.Model.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "motel")
public class MotelEntity extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "address")
    private String address;

    @Column(name = "ward")
    private  String ward;

    @Column(name = "province")
    private String province;

    @Column(name = "district")
    private String district;

    @Column(name = "area")
    private Integer area;

    @Column(name = "price")
    private Integer price;

    @Column(name = "type")
    private String type;

    @Column(name = "detail")
    private String detail;

    @Column(name = "userid")
    private Integer userId;

    @Column(name = "maxpeople")
    private Integer maxPeople;

    @Column(name = "status")
    private Integer status = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    private UserEntity user = new UserEntity();

    @OneToMany(mappedBy = "motelEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL
            , orphanRemoval = true)
    private List<FileEntity> fileEntities = new ArrayList<>();

    @ManyToMany(mappedBy = "favoriteMotels")
    private List<UserEntity> likedByUsers = new ArrayList<>();
}
