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
public class FileEntity extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "file_url")
    private String fileUrl;

    @Column(name = "motelid")
    private Integer motelId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motelid", insertable = false, updatable = false)
    private MotelEntity motelEntity = new MotelEntity();
}
