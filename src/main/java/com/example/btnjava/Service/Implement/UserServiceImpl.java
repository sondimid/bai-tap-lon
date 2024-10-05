package com.example.btnjava.Service.Implement;

import com.example.btnjava.Converter.UserResponseConverter;
import com.example.btnjava.CustomException.InvalidParamException;
import com.example.btnjava.Model.DTO.UserDTO;
import com.example.btnjava.Model.Entity.RoleEntity;
import com.example.btnjava.Model.Entity.UserEntity;
import com.example.btnjava.Model.Response.UserResponse;
import com.example.btnjava.Repository.RoleRepository;
import com.example.btnjava.Repository.UserRepository;
import com.example.btnjava.Service.UserService;
import com.example.btnjava.Utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserResponseConverter userResponseConverter;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtils jwtTokenUtils;

    @Override
    public List<UserResponse> getAllUsers(Integer page) {
        Page<UserEntity> users= userRepository.findAll(PageRequest.of(page-1, 3));
        return userResponseConverter.toUserResponse(users.getContent());
    }

    @Override
    public ResponseEntity<?> createUser(UserDTO user) {
        if(userRepository.existsByPhoneNumber(user.getPhoneNumber())) {
            throw new DataIntegrityViolationException("Phone number already exists");
        }

        if(userRepository.existsByUserName(user.getUserName())){
            throw new DataIntegrityViolationException("User name already exists");
        }

        if(userRepository.existsByEmail(user.getEmail())){
            throw new DataIntegrityViolationException("Email already exists");
        }

        if(!user.getPassword().equals(user.getRetypePassword())){
            throw new DataIntegrityViolationException("Password does not match");
        }
        RoleEntity roleEntity = roleRepository.findByRole("USER");
        UserEntity userEntity = UserEntity.builder().
                userName(user.getUserName())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .passWord(passwordEncoder.encode(user.getPassword()))
                .phoneNumber(user.getPhoneNumber())
                .build();
        userEntity.setRoleEntity(roleEntity);
        return ResponseEntity.ok(userRepository.save(userEntity));
    }

    @Override
    public String   login(String username, String password) throws Exception {
        Optional<UserEntity> user = userRepository.findByUserName(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("Wrong username or password");
        }
        UserEntity userEntity = user.get();
        if(!passwordEncoder.matches(password, userEntity.getPassword())){
            throw new BadCredentialsException("Wrong username or password");
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(username, password, userEntity.getAuthorities());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        return jwtTokenUtils.generateToken(userEntity);

    }
}
