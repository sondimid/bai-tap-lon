package com.example.btnjava.Controller;

import com.example.btnjava.Service.MotelService;
import com.example.btnjava.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final MotelService motelService;
    private final UserService userService;

    @GetMapping("/pagination/review")
    public ResponseEntity<Object> findAllReviews (@RequestParam (name = "page", defaultValue = "1") Integer page) throws IOException {
        return ResponseEntity.ok().body(motelService.findAndPagination(page));
    }

    @PostMapping("/markMotel/{ids}")
    public ResponseEntity<?> markMotel(@PathVariable List<Integer> ids){
        return motelService.markMotelByIds(ids);
    }

    @GetMapping("/list-user")
    public ResponseEntity<?> findAllUsers (@RequestParam(name = "page", defaultValue = "1") Integer page) throws Exception {
        return ResponseEntity.ok().body(userService.getAllUsers(page));
    }

    @PostMapping("/mark-user/{ids}")
    public ResponseEntity<?> markUser(@PathVariable List<Integer> ids){
        return userService.markByIds(ids);
    }
}
