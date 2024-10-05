package com.example.btnjava.Model.Response;


import com.example.btnjava.Model.Entity.RoleEntity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponse {

    private String fullName;

    private String phoneNumber;

    private String userName;

    private String email;

    private List<MotelResponse> motelResponses;

    private String role;
}
