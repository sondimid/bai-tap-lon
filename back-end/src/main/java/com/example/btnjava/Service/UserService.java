package com.example.btnjava.Service;

import com.example.btnjava.Model.DTO.UserDTO;
import com.example.btnjava.Model.Entity.UserEntity;
import com.example.btnjava.Model.Response.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponse> getAllUsers(Integer page);
    ResponseEntity<?> createUser(UserDTO user) throws Exception;
    String login(String username, String password) throws Exception;
    Optional<UserEntity> findByUserName(String username);
    Optional<UserEntity> findById(Integer id);
    UserResponse getUserDetail(String token);
}
