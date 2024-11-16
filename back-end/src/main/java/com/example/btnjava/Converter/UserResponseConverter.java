package com.example.btnjava.Converter;

import com.example.btnjava.Model.Entity.UserEntity;
import com.example.btnjava.Model.Response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
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
            userResponse.setUserName(user.getUsername());
            result.add(userResponse);
        }
        return result;
    }
    public UserResponse toUserResponse(UserEntity userEntity) throws MalformedURLException {
        UserResponse userResponse = modelMapper.map(userEntity, UserResponse.class);
        userResponse.setRole(userEntity.getRoleEntity().getRole());
        userResponse.setUserName(userEntity.getUsername());
        return userResponse;
    }
}
