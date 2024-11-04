package com.example.btnjava.Service.Implement;

import com.example.btnjava.Converter.UserResponseConverter;
import com.example.btnjava.Model.DTO.UserDTO;
import com.example.btnjava.Model.Entity.RoleEntity;
import com.example.btnjava.Model.Entity.UserEntity;
import com.example.btnjava.Model.Response.UserResponse;
import com.example.btnjava.Repository.RoleRepository;
import com.example.btnjava.Repository.UserRepository;
import com.example.btnjava.Service.UserService;
import com.example.btnjava.Utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        Page<UserEntity> users = userRepository.findAll(PageRequest.of(page - 1, 3,
                Sort.by("created_at").descending().and(Sort.by("updated_at").descending()
                .and(Sort.by("username").ascending()))));
        return userResponseConverter.toUserResponse(users.getContent());
    }

    @Override
    public ResponseEntity<?> createUser(UserDTO user) {
        if (userRepository.existsByPhoneNumber(user.getPhoneNumber())) {
            throw new DataIntegrityViolationException("Số Điện Thoại Đã Tồn Tại");
        }

        if (userRepository.existsByUserName(user.getUserName())) {
            throw new DataIntegrityViolationException("Tên Đăng Nhập Đã Tồn Tại");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DataIntegrityViolationException("Email Đã Tồn Tại");
        }

        if (!user.getPassword().equals(user.getRetypePassword())) {
            throw new DataIntegrityViolationException("Mật Khẩu Không Khớp");
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
        userRepository.save(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created user");
    }

    @Override
    public String login(String username, String password) throws Exception {
        Optional<UserEntity> user = userRepository.findByUserName(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Sai Tên Đăng Nhập Hoặc Mật Khẩu");
        }
        UserEntity userEntity = user.get();
        if (!passwordEncoder.matches(password, userEntity.getPassword())) {
            throw new BadCredentialsException("Sai Tên Đăng Nhập Hoặc Mật Khẩu");
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(username, password, userEntity.getAuthorities());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        return jwtTokenUtils.generateToken(userEntity);

    }

    @Override
    public Optional<UserEntity> findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public Optional<UserEntity> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public UserResponse getUserDetail(String token) {
        Integer id = jwtTokenUtils.extractUserId(token);
        UserEntity userEntity = userRepository.findById(id).get();
        return userResponseConverter.toUserResponse(userEntity);
    }
}
