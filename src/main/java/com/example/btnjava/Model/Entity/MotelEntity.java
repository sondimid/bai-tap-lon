package com.example.btnjava.Model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "motel")
public class MotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "housenumber")
    private String houseNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "ward")
    private  String ward;

    @Column(name = "district")
    private String district;

    @Column(name = "province")
    private String province;

    @Column(name = "area")
    private Integer area;

    @Column(name = "price")
    private Integer price;

    @Column(name = "interior")
    private String interior;

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
    private UserEntity user;
}
