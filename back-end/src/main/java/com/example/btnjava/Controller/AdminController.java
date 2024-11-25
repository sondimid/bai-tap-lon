package com.example.btnjava.Controller;

import com.example.btnjava.Model.Response.MotelResponse;
import com.example.btnjava.Service.MotelService;
import com.example.btnjava.Service.UserService;
import com.example.btnjava.Utils.JwtTokenUtils;
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
    private final JwtTokenUtils jwtTokenUtils;

    @GetMapping("/pagination/review")
    public ResponseEntity<Object> findAllReviews(@RequestParam(name = "page", defaultValue = "1") Integer page) throws MalformedURLException {
        return ResponseEntity.ok().body(motelService.findAndPagination(page));
    }

    @PostMapping("/admin/markMotel")
    public ResponseEntity<String> markMotel(@RequestHeader("Authorization") String authorization,
                                            @RequestParam("selectedMotels") List<Integer> ids,
                                            @RequestParam("status") Integer status) throws MalformedURLException {
            motelService.markById(ids, status);
        return ResponseEntity.status(HttpStatus.CREATED).body("Đã xác nhận thành công!");
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

    @DeleteMapping("/admin/delete-motels")
    public ResponseEntity<?> deleteMotel(@RequestHeader("Authorization") String authorization,
                                         @RequestParam("selectedMotels") List<Integer> ids,
                                         @RequestParam("isDelete") Boolean isDelete) throws MalformedURLException {
        Integer userId = jwtTokenUtils.extractUserId(authorization.substring(7));
        return ResponseEntity.ok().body(motelService.deleteOrUnpublishMotel(ids, isDelete));
    }
}
