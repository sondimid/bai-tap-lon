package com.example.btnjava.Controller;

import com.example.btnjava.Model.Response.MotelResponse;
import com.example.btnjava.Service.MotelService;
import com.example.btnjava.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class AdminController {
    private final MotelService motelService;
    private final UserService userService;

    @GetMapping("/pagination/review")
    public ResponseEntity<Object> findAllReviews(@RequestParam (name = "page", defaultValue = "1") Integer page) throws MalformedURLException {
        return ResponseEntity.ok().body(motelService.findAndPagination(page));
    }

    @PostMapping("/admin/markMotel")
    public ResponseEntity<String> markMotel(@RequestHeader("Authorization") String authorization,
                                            @RequestParam("selectedMotels") List<Integer> ids) {
        motelService.markById(ids);
        return ResponseEntity.status(HttpStatus.CREATED).body("Thêm thành công!");
    }

    @GetMapping("/admin/get-all-motels-non-status")
    public ResponseEntity<?> getByNonStatus(@RequestHeader("Authorization") String authorization) throws MalformedURLException {
        List<MotelResponse> motelResponses = motelService.findByNonStatus();
        return ResponseEntity.ok().body(motelResponses);
    }
    @GetMapping("/admin/list-user")
    public ResponseEntity<Object> findAllUsers(@RequestHeader("Authorization") String authorization) throws Exception {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }
    @GetMapping("/admin/get-motels-by-user/{id}")
    public ResponseEntity<?> getMotelsByUser(@RequestHeader("Authorization") String authorization,@PathVariable(name = "id") Integer id) throws MalformedURLException {
        return ResponseEntity.ok().body(motelService.adminFindByUserId(id));
    }
}
