package com.example.btnjava.Converter;

import com.example.btnjava.Model.Entity.UserEntity;
import com.example.btnjava.Model.Response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@RequiredArgsConstructor
public class UserResponseConverter {
    private final ModelMapper modelMapper;

    public List<UserResponse> toUserResponse(List<UserEntity> list){
        List<UserResponse> result = new ArrayList<>();
        for(UserEntity user : list){
            UserResponse userResponse = modelMapper.map(user, UserResponse.class);
            userResponse.setRole(user.getRoleEntity().getRole());
            result.add(userResponse);
        }
        return result;
    }
}
