package com.example.btnjava.Controller;

import com.example.btnjava.Model.Email.MailStructure;
import com.example.btnjava.Service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    @PostMapping("/forgot-password/{email}")
    public ResponseEntity<?> sendEmail(@PathVariable String email) throws Exception {
       try{
           mailService.sendEmail(email);
           return ResponseEntity.ok().body("Yêu cầu đặt lại mật khẩu đã được gửi. Vui lòng kiểm tra email của bạn.");
       }
       catch (Exception e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
}
