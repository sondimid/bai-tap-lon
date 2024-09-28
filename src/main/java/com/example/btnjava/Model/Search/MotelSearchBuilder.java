package com.example.btnjava.Model.Search;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MotelSearchBuilder {

    private String description;

    private Integer houseNumber;

    private  String ward;

    private String district;

    private String province;

    private Integer areaFrom;

    private Integer areaTo;

    private Integer priceFrom;

    private Integer priceTo;

    private String interior;

    private String type;

    private String detailDescription;

    private String managerName;

    private String phoneNumber;

    private Integer page = 1;

    private Integer maxPageItems = 4;

}
