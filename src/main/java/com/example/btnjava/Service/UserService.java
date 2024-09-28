package com.example.btnjava.Service;

import com.example.btnjava.Model.Response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers(Integer page);
}
