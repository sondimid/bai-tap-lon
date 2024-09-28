package com.example.btnjava.Service.Implement;

import com.example.btnjava.Converter.UserResponseConverter;
import com.example.btnjava.Model.Entity.UserEntity;
import com.example.btnjava.Model.Response.UserResponse;
import com.example.btnjava.Repository.UserRepository;
import com.example.btnjava.Service.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserResponseConverter userResponseConverter;

    @Override
    public List<UserResponse> getAllUsers(Integer page) {
        Page<UserEntity> users= userRepository.findAll(PageRequest.of(page-1, 3));
        return userResponseConverter.toUserResponse(users.getContent());
    }
}
