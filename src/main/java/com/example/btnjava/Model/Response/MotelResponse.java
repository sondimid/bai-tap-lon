package com.example.btnjava.Model.Response;

import com.example.btnjava.Model.Entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    private UserEntity owner;

    private String address;

    private String status;

    List<MultipartFile> files;

    private String urlFiles;

    @Override
    public int compareTo(MotelResponse o) {
        return o.status.compareTo(this.status);
    }
}
