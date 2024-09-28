package com.example.btnjava.Model.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MotelResponse implements Comparable<MotelResponse>{

    private Integer id;

    private String title;

    private String houseNumber;

    private String ward;

    private String district;

    private String province;

    private Integer area;

    private Integer price;

    private String interior;

    private String type;

    private String detail;

    private String managerName;

    private String phoneNumber;

    private String address;

    private String status;

    @Override
    public int compareTo(MotelResponse o) {
        return o.status.compareTo(this.status);
    }
}
