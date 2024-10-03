package com.example.btnjava.Service;

import com.example.btnjava.Model.DTO.UserDTO;
import com.example.btnjava.Model.Response.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers(Integer page);
    ResponseEntity<?> createUser(UserDTO user) throws Exception;
    String login(String username, String password) throws Exception;
}
