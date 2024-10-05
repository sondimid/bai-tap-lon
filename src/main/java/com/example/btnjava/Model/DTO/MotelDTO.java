package com.example.btnjava.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class MotelDTO {

    private String title;

    private Integer houseNumber;

    private String street;

    private  String ward;

    private String district;

    private String province;

    private Integer area;

    private Integer price;

    private String interior;

    private String type;

    private String detail;

    private Integer userId;

    private List<MultipartFile> files;
}
