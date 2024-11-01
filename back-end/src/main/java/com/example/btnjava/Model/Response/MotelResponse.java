package com.example.btnjava.Model.Response;

import com.example.btnjava.Model.DTO.FileDTO;
import com.example.btnjava.Model.Entity.FileEntity;
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

    List<FileDTO> filesDTO;


    @Override
    public int compareTo(MotelResponse o) {
        return o.status.compareTo(this.status);
    }
}
