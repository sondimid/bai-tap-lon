package com.example.btnjava.Model.Search;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MotelSearchBuilder {

    private String title;

    private Integer houseNumber;

    private String ward;

    private String district;

    private Integer areaFrom;

    private Integer areaTo;

    private Integer priceFrom;

    private Integer priceTo;

    private Integer maxPeople;

    private String detail;

    private String type;

    private String managerName;

    private String phoneNumber;

    private Integer page = 1;

    private Integer maxPageItems = 3;

}
