package com.example.btnjava.Controller;


import com.example.btnjava.Model.DTO.ChangePasswordDTO;
import com.example.btnjava.Model.DTO.MotelDTO;
import com.example.btnjava.Model.DTO.UserDTO;
import com.example.btnjava.Model.DTO.UserLoginDTO;
import com.example.btnjava.Model.Response.MotelResponse;
import com.example.btnjava.Model.Search.MotelSearchBuilder;
import com.example.btnjava.Service.ChatRoomService;
import com.example.btnjava.Service.MotelService;
import com.example.btnjava.Service.UserService;
import com.example.btnjava.Utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.net.MalformedURLException;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class UserController {
    private static final String UPLOAD_DIR = "D:/uploads/";
    private final MotelService motelService;
    private final UserService userService;
    private final JwtTokenUtils jwtTokenUtils;
    private final ChatRoomService chatRoomService;

    @GetMapping("/search")
    public ResponseEntity<?> searchByMotelSearchBuilder(MotelSearchBuilder motelSearchBuilder) throws MalformedURLException {
        return ResponseEntity.ok().body(motelService.findAll(motelSearchBuilder));

    }

    @GetMapping("/get-all-motels")
    public ResponseEntity<?> getAll(@RequestParam("currentPage") Integer currentPage) throws MalformedURLException {
        MotelSearchBuilder motelSearchBuilder = new MotelSearchBuilder();
        motelSearchBuilder.setPage(currentPage);
        return ResponseEntity.ok().body(motelService.findAll(motelSearchBuilder));
    }

    @GetMapping("/motel/{id}")
    public ResponseEntity<?> getMotel(@PathVariable Integer id) throws MalformedURLException {
        MotelResponse motelResponses = motelService.findById(id);
        return ResponseEntity.ok().body(motelResponses);
    }

    @PostMapping("/create")
    public ResponseEntity<?> addMotel(MotelDTO motelDTO, @RequestHeader("Authorization") String authorization) throws IOException {

        try {
            String token = authorization.replace("Bearer ", "");
            motelService.save(motelDTO, token);
            return ResponseEntity.status(HttpStatus.CREATED).body("Đăng Bài Thành Công, Chờ Admin Duyệt");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
            userService.createUser(userDTO);
            return ResponseEntity.accepted().body("Success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginDTO userDTO) {
        try {
            String token = userService.login(userDTO.getUserName(), userDTO.getPassword());
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/my-motel")
    public ResponseEntity<?> searchByUserId(@RequestHeader("Authorization") String authorization) throws MalformedURLException {
        String token = authorization.replace("Bearer ", "");
        try {
            return ResponseEntity.ok().body(motelService.findByUserName(jwtTokenUtils.extractUsername(token)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get-infor")
    public ResponseEntity<?> getUserDetail(@RequestHeader("Authorization") String authorization) throws MalformedURLException {
        String token = authorization.replace("Bearer ", "");
        return ResponseEntity.ok(userService.getUserDetail(token));
    }

    @PostMapping("/upload-avatar/{id}")
    public ResponseEntity<?> uploadAvatar(@PathVariable Integer id, @RequestParam("file") MultipartFile file) throws Exception {
        return ResponseEntity.accepted().body(userService.uploadAvatar(id, file));
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO,
                                            @RequestHeader("Authorization") String authorization) throws MalformedURLException {
        String token = authorization.replace("Bearer ", "");
        try {
            userService.changePassword(changePasswordDTO, token);
            return ResponseEntity.accepted().body("Success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get-motels-by-user/{id}")
    public ResponseEntity<?> getMotelsByUser(@PathVariable(name = "id") Integer id) throws MalformedURLException {
        return ResponseEntity.ok().body(motelService.adminFindByUserId(id));
    }

    @GetMapping("/user/list-user")
    public ResponseEntity<Object> findAllUsers(@RequestHeader("Authorization") String authorization, List<Integer> recipientIds) throws Exception {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/get-all-ids")
    public ResponseEntity<?> findAllChatMessages(@RequestHeader("Authorization") String authorization) throws MalformedURLException {
        String token = authorization.substring(7);
        Integer id = jwtTokenUtils.extractUserId(token);
        return ResponseEntity.ok().body(userService.getByIds(chatRoomService.getRecipientIdsBySenderId(id), id));
    }

    @DeleteMapping("/delete-motels")
    public ResponseEntity<?> deleteMotel(@RequestHeader("Authorization") String authorization,
                                         @RequestParam("selectedMotels") List<Integer> ids) throws MalformedURLException {
        Integer userId = jwtTokenUtils.extractUserId(authorization.substring(7));
        return ResponseEntity.ok().body(motelService.deleteMotels(userId, ids));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestParam("token") String token,
                                           @RequestParam("newPassword") String newPassword) {
        try {
            userService.resetPassword(token, newPassword);
            return ResponseEntity.ok().body("Success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/find-by-radius")
    public ResponseEntity<?> findByDistance(@RequestParam("destination") String destination,
                                            @RequestParam("radius") Double radius) throws MalformedURLException {
        return ResponseEntity.ok().body(motelService.findByRadius(destination, (int) (radius * 1000)));
    }

    @PostMapping("/favorites")
    public ResponseEntity<?> favorite(@RequestParam("ids") List<Integer> ids, @RequestHeader("Authorization") String authorization) throws MalformedURLException {
        return ResponseEntity.ok().body(userService.favoriteMotels(ids, authorization.substring(7)));
    }

    @GetMapping("/get-favorites")
    public ResponseEntity<?> favorite(@RequestHeader("Authorization") String authorization) throws MalformedURLException {
        return ResponseEntity.ok().body(motelService.getFavorite(authorization.substring(7)));
    }
}

