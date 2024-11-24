package com.example.btnjava.Model.Response;


import com.example.btnjava.Model.Entity.RoleEntity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UserResponse implements Comparable<UserResponse> {
    private Integer id;

    private String fullName;

    private String phoneNumber;

    private String userName;

    private String email;

    private String fileUrl;

    private String role;

    private LocalDateTime timestamp;

    private String content;

    @Override
    public int compareTo(UserResponse o) {
        return -timestamp.compareTo(o.getTimestamp());
    }
}
