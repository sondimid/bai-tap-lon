package com.example.btnjava.Controller;

import com.example.btnjava.Model.DTO.MotelDTO;
import com.example.btnjava.Model.DTO.UserDTO;
import com.example.btnjava.Model.DTO.UserLoginDTO;
import com.example.btnjava.Model.Search.MotelSearchBuilder;
import com.example.btnjava.Service.MotelService;
import com.example.btnjava.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final MotelService motelService;
    private final UserService userService;

    @GetMapping("/search")
    public ResponseEntity<Object>searchByMotelSearchBuilder(@RequestBody MotelSearchBuilder motelSearchBuilder) throws IOException {
        return ResponseEntity.ok().body(motelService.findAll(motelSearchBuilder));
    }

    @PostMapping("/create")
    public ResponseEntity<String> addMotel(@ModelAttribute MotelDTO motelDTO,@RequestHeader String token) throws IOException {
        motelService.save(motelDTO, token);
        return ResponseEntity.accepted().body("SUCCESS");
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDTO userDTO,
                                                BindingResult result){
        try{
            if(result.hasErrors()){
                return ResponseEntity.badRequest().body(result.getAllErrors());
            }
            return userService.createUser(userDTO);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody UserLoginDTO userDTO){
        try{
            String token = userService.login(userDTO.getUserName(), userDTO.getPassword());
            return ResponseEntity.ok().body(token);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
