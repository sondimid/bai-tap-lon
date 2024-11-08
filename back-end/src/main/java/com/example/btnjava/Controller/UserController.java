package com.example.btnjava.Controller;

import com.example.btnjava.CustomException.NotNullException;
import com.example.btnjava.Model.DTO.ChangePasswordDTO;
import com.example.btnjava.Model.DTO.MotelDTO;
import com.example.btnjava.Model.DTO.UserDTO;
import com.example.btnjava.Model.DTO.UserLoginDTO;
import com.example.btnjava.Model.Response.MotelResponse;
import com.example.btnjava.Model.Search.MotelSearchBuilder;
import com.example.btnjava.Service.MotelService;
import com.example.btnjava.Service.UserService;
import com.example.btnjava.Utils.JwtTokenUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class UserController {
    private final MotelService motelService;
    private final UserService userService;
    private final JwtTokenUtils jwtTokenUtils;

    @GetMapping("/search")
    public ResponseEntity<?>searchByMotelSearchBuilder( MotelSearchBuilder motelSearchBuilder) throws MalformedURLException {
        return ResponseEntity.ok().body(motelService.findAll(motelSearchBuilder));
    }
    @GetMapping("/get-all-motels")
    public ResponseEntity<?> getAll() throws MalformedURLException {
        List<MotelResponse> motelResponses = motelService.findAll();
        return ResponseEntity.ok().body(motelResponses);
    }
    @GetMapping("/motel/{id}")
    public ResponseEntity<?> getMotel(@PathVariable Integer id) throws MalformedURLException {
        MotelResponse motelResponses = motelService.findById(id);
        return ResponseEntity.ok().body(motelResponses);
    }
    @PostMapping("/create")
    public ResponseEntity<String> addMotel(MotelDTO motelDTO, @RequestHeader("authorization") String token) throws IOException {

        try{
            motelService.save(motelDTO, token);
            return ResponseEntity.status(HttpStatus.CREATED).body("Success");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value="/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){
        try{
            userService.createUser(userDTO);
            return ResponseEntity.accepted().body("Success");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value="/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginDTO userDTO){
        try{
            String token = userService.login(userDTO.getUserName(), userDTO.getPassword());
            return ResponseEntity.ok(token);
        }
        catch (Exception e){
                return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("{userName}/added-buildings")
    @PreAuthorize("#userName == authentication.name")
    public ResponseEntity<?> searchByUserId(@PathVariable("userName") String userName, @RequestHeader("authorization") String token) {
        if(userName == null) throw new NotNullException("User not exist");
        if(jwtTokenUtils.isTokenUserNameValid(token.substring(7), userName)) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        try{
            return ResponseEntity.ok().body(motelService.findByUserName(userName));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/get-infor")
    public ResponseEntity<?> getUserDetail(@RequestHeader("Authorization") String authorization) throws MalformedURLException {
        String token = authorization.replace("Bearer ", "");
        return ResponseEntity.ok(userService.getUserDetail(token));
    }
    @PostMapping("/upload-avatar/{id}")
    public ResponseEntity<?> uploadAvatar(@PathVariable Integer id,@RequestParam("file") MultipartFile file) throws Exception {
        return ResponseEntity.accepted().body(userService.uploadAvatar(id, file));
    }
    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO,
                                            @RequestHeader("Authorization") String authorization) throws MalformedURLException {
        String token = authorization.replace("Bearer ", "");
        try{
            userService.changePassword(changePasswordDTO,token);
            return ResponseEntity.accepted().body("Success");
        }catch (Exception e){
                return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
