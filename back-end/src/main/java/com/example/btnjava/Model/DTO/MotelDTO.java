package com.example.btnjava.Model.DTO;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class MotelDTO {
    private Integer id;

    private Integer maxPeople;

    private String title;

    private Integer houseNumber;

    private String street;

    private String ward;

    private String district;

    private String province;

    private Integer area;

    private Integer price;

    private String detail;

    private String type;

    private List<Integer> listFileId;

    private String address;

    private List<MultipartFile> files;
}
