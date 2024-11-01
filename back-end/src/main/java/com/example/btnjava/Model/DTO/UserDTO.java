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
    @NotBlank(message = "full name is not null!")
    private String fullName;

    @Email(message = "email is not valid!")
    @NotBlank(message = "email is not null!")
    private String email;

    @NotBlank(message = "phone number is not null!")
    private String phoneNumber;

    @NotBlank(message = "user name is not null!")
    private String userName;

    @NotBlank(message = "password is not null!")
    private String password;

    @NotBlank(message = "retype password is not null!")
    private String retypePassword;

}
