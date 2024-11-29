package com.example.btnjava.Service.Implement;

import com.example.btnjava.Converter.UserResponseConverter;
import com.example.btnjava.Model.DTO.ChangePasswordDTO;
import com.example.btnjava.Model.DTO.UserDTO;
import com.example.btnjava.Model.Entity.MotelEntity;
import com.example.btnjava.Model.Entity.RoleEntity;
import com.example.btnjava.Model.Entity.UserEntity;
import com.example.btnjava.Model.Response.MotelResponse;
import com.example.btnjava.Model.Response.UserResponse;
import com.example.btnjava.Repository.MotelRepository;
import com.example.btnjava.Repository.RoleRepository;
import com.example.btnjava.Repository.UserRepository;
import com.example.btnjava.Service.ChatMessageService;
import com.example.btnjava.Service.MotelService;
import com.example.btnjava.Service.UserService;
import com.example.btnjava.Utils.JwtTokenUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserResponseConverter userResponseConverter;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtils jwtTokenUtils;
    private final ChatMessageService chatMessageService;
    private final MotelRepository motelRepository;
    private static final String UPLOAD_DIR = "D:/uploads/";

    @Override
    public List<UserResponse> getAllUsers(Integer page) {
        Page<UserEntity> users = userRepository.findAll(PageRequest.of(page - 1, 3,
                Sort.by("created_at").descending().and(Sort.by("updated_at").descending()
                .and(Sort.by("username").ascending()))));
        return userResponseConverter.toUserResponse(users.getContent());
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userResponseConverter.toUserResponse(userRepository.findAll());
    }

    @Override
    public ResponseEntity<?> createUser(UserDTO user) throws IOException {
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

        // sinh token
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
    public UserResponse getUserDetail(String token) throws MalformedURLException {
        Integer id = jwtTokenUtils.extractUserId(token);
        UserEntity userEntity = userRepository.findById(id).get();
        return userResponseConverter.toUserResponse(userEntity);
    }

    @Override
    public String uploadAvatar(Integer id, MultipartFile file ) throws Exception {
        UserEntity user = userRepository.findById(id).get();
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String originalFileName = String.valueOf(System.currentTimeMillis());
        String filePath = UPLOAD_DIR + originalFileName;
        String fileUrl = String.format("http://localhost:8081/uploads/%s", originalFileName);
        file.transferTo(new File(filePath));
        user.setFileUrl(fileUrl);
        userRepository.save(user);
        return fileUrl;
    }

    @Override
    public void changePassword(ChangePasswordDTO changePasswordDTO, String token) {
        Integer id = jwtTokenUtils.extractUserId(token);
        UserEntity user = userRepository.findById(id).get();
        if(!passwordEncoder.matches(changePasswordDTO.getCurrentPassword(), user.getPassword())){
            throw new DataIntegrityViolationException("Mật Khẩu Không Chính Xác");
        }
        if(!changePasswordDTO.getNewPassword().equals(changePasswordDTO.getRetypePassword())){
            throw new DataIntegrityViolationException("Mật Khẩu Không Khớp");
        }
        user.setPassWord(passwordEncoder.encode(changePasswordDTO.getNewPassword()));
        userRepository.save(user);
    }

    @Override
    public List<UserResponse> getByIds(List<Integer> ids, Integer senderId) throws MalformedURLException {
        List<UserResponse> userResponses = new ArrayList<>();
        for (Integer id : ids) {
            UserEntity userEntity = userRepository.findById(id).get();
            UserResponse user = userResponseConverter.toUserResponse(userEntity);
            user.setTimestamp(chatMessageService.getLeastTime(senderId, id));
            user.setContent(chatMessageService.getLeastMessage(senderId, id));
            userResponses.add(user);
        }
        Collections.sort(userResponses);
        return userResponses;
    }

    @Override
    public void saveResetToken(String email, String resetToken) throws Exception {
        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(email);
        if(!userEntityOptional.isPresent()){
            throw new Exception("Email không tồn tại");
        }
        else{
            UserEntity userEntity = userEntityOptional.get();
            userEntity.setResetToken(resetToken);
            userEntity.setTokenExpiryDate(LocalDateTime.now().plusMinutes(30));
            userRepository.save(userEntity);
        }

    }

    @Override
    public void resetPassword(String token, String newPassword) throws Exception {
        Optional<UserEntity> userEntityOptional = userRepository.findByResetToken(token);
        if(!userEntityOptional.isPresent()){
            throw new UsernameNotFoundException("Không tìm thấy tài khoản");
        }
        else{
            UserEntity userEntity = userEntityOptional.get();
            LocalDateTime now = LocalDateTime.now();
            if(now.isBefore(userEntity.getTokenExpiryDate())){
                userEntity.setPassWord(passwordEncoder.encode(newPassword));
                userEntity.setTokenExpiryDate(now);
                userRepository.save(userEntity);
            }
            else{
                throw new Exception("Token đã hết hạn. Vui lòng yêu cầu gửi lại email.");
            }

        }
    }



    @Override
    public String favoriteMotels(List<Integer> ids, String token) throws MalformedURLException {
        Integer id = jwtTokenUtils.extractUserId(token);
        UserEntity user = userRepository.findById(id).get();
        user.getFavoriteMotels().clear();
        for(Integer motelId: ids) {
            MotelEntity motel = motelRepository.findById(motelId).get();
            user.getFavoriteMotels().add(motel);
        }
        userRepository.save(user);
        return "SUCCESS";

    }

}
