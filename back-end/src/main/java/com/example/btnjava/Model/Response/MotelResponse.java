package com.example.btnjava.Model.Response;

import com.example.btnjava.Model.DTO.FileDTO;
import com.example.btnjava.Model.Entity.FileEntity;
import com.example.btnjava.Model.Entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class MotelResponse implements Comparable<MotelResponse>{

    private Integer id;

    private String title;

    private Integer houseNumber;

    private Integer maxPeople;

    private String ward;

    private String district;

    private Integer area;

    private Integer price;

    private String type;

    private String detail;

    private UserResponse owner;

    private String address;

    private String status;

    List<FileDTO> filesDTO;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Override
    public int compareTo(MotelResponse o) {
        return o.status.compareTo(this.status);
    }
}
