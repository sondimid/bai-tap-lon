package com.example.btnjava.Controller;

import com.example.btnjava.Service.MotelService;
import com.example.btnjava.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final MotelService motelService;
    private final UserService userService;

    @GetMapping("/pagination/review")
    public ResponseEntity<Object> findAllReviews(@RequestParam (name = "page", defaultValue = "1") Integer page) throws MalformedURLException {
        return ResponseEntity.ok().body(motelService.findAndPagination(page));
    }

    @PostMapping("/markMotel/{id}")
    public ResponseEntity<String> markMotel(@PathVariable Integer id){
        motelService.markById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Thêm thành công!");
    }

    @GetMapping("/list-user")
    public ResponseEntity<Object> findAllUsers(@RequestParam(name = "page", defaultValue = "1") Integer page) throws Exception {
        return ResponseEntity.ok().body(userService.getAllUsers(page));
    }
}
