package com.example.btnjava.Service;

import com.example.btnjava.Model.DTO.ChangePasswordDTO;
import com.example.btnjava.Model.DTO.UserDTO;
import com.example.btnjava.Model.Entity.UserEntity;
import com.example.btnjava.Model.Response.MotelResponse;
import com.example.btnjava.Model.Response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponse> getAllUsers(Integer page);
    List<UserResponse> getAllUsers();
    ResponseEntity<?> createUser(UserDTO user) throws Exception;
    String login(String username, String password) throws Exception;
    Optional<UserEntity> findByUserName(String username);
    Optional<UserEntity> findById(Integer id);
    UserResponse getUserDetail(String token) throws MalformedURLException;
    String uploadAvatar(Integer id, MultipartFile file) throws Exception;
    void changePassword(ChangePasswordDTO changePasswordDTO, String token);
    List<UserResponse> getByIds(List<Integer> ids, Integer senderId) throws MalformedURLException;
    void saveResetToken(String email, String resetToken) throws Exception;
    String favoriteMotels(List<Integer> ids, String token) throws MalformedURLException;
    void resetPassword(String token, String newPassword) throws Exception;
}
