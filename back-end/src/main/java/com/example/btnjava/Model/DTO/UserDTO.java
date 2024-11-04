package com.example.btnjava.Model.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class UserDTO {
    private String fullName;

    private String email;

    private String phoneNumber;

    private String userName;

    private String password;

    private String retypePassword;

}
