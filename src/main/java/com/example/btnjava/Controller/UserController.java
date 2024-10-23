package com.example.btnjava.Controller;

import com.example.btnjava.CustomException.NotNullException;
import com.example.btnjava.Model.DTO.MotelDTO;
import com.example.btnjava.Model.DTO.UserDTO;
import com.example.btnjava.Model.DTO.UserLoginDTO;
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

import java.io.IOException;
import java.net.MalformedURLException;


@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final MotelService motelService;
    private final UserService userService;
    private final JwtTokenUtils jwtTokenUtils;

    @GetMapping("/search")
    public ResponseEntity<Object>searchByMotelSearchBuilder(@RequestBody MotelSearchBuilder motelSearchBuilder) throws MalformedURLException {
        return ResponseEntity.ok().body(motelService.findAll(motelSearchBuilder));
    }

    @PostMapping("/create")
    public ResponseEntity<String> addMotel(@ModelAttribute MotelDTO motelDTO, @RequestHeader("authorization") String token) throws IOException {

        try{
            motelService.save(motelDTO, token);
            return ResponseEntity.status(HttpStatus.CREATED).body("Success");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value="/register")
    public String registerUser(@Valid @ModelAttribute("userRegister") UserDTO userDTO,
                                                BindingResult result, Model model){
        try{
            if(result.hasErrors()){
                return "signup";
            }
            userService.createUser(userDTO);
            model.addAttribute("successMessage", "Đăng Ký Thành Công");
            return "signup";
        }
        catch (Exception e){
            model.addAttribute("errorMessage", e.getMessage());
            return "signup";
        }
    }

    @PostMapping(value="/login")
    public String loginUser(@Valid @ModelAttribute UserLoginDTO userDTO, Model model){
        try{
            String token = userService.login(userDTO.getUserName(), userDTO.getPassword());
            ResponseEntity.ok().body(token);
            return "index";
        }
        catch (Exception e){
            model.addAttribute("errorMessage", e.getMessage());
            return "login";
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
}
