package com.example.btnjava.Model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDTO {
    @NotBlank(message = "user name is not blank")
    private String userName;

    @NotBlank(message = "password is not blank")
    private String password;
}
