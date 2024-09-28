package com.example.btnjava.Api.Admin;

import com.example.btnjava.Service.MotelService;
import com.example.btnjava.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminAPI {
    @Autowired
    private MotelService motelService;

    @Autowired
    private UserService userService;
    @GetMapping("/pagination/review")
    public ResponseEntity<Object> findAllReviews (@RequestParam (name = "page", defaultValue = "1") Integer page) {
        return new ResponseEntity<>(motelService.findAndPagination(page), HttpStatus.OK);
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<String> addMotel(@PathVariable Integer id){
        motelService.markById(id);
        return new ResponseEntity<>("SUCCESS", HttpStatus.ACCEPTED);
    }

    @GetMapping("/list-user")
    public ResponseEntity<Object> findAllUsers (@RequestParam(name = "page", defaultValue = "1") Integer page) {
        return new ResponseEntity<>(userService.getAllUsers(page), HttpStatus.OK);
    }
}
