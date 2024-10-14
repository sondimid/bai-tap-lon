package com.example.btnjava.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "file")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileEntity extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "url")
    private String url;

    @Column(name = "name")
    private String name;

    @Column(name = "motelid")
    private Integer motelId;

    @ManyToOne
    @JoinColumn(name = "motelid", insertable = false, updatable = false)
    private MotelEntity motelEntity = new MotelEntity();
}
