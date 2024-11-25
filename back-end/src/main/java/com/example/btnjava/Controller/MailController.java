package com.example.btnjava.Controller;

import com.example.btnjava.Model.Email.MailStructure;
import com.example.btnjava.Service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    @PostMapping("/send-email/{email}")
    public String sendEmail(@PathVariable String email, @RequestBody MailStructure mailStructure) {
        mailService.sendEmail(email, mailStructure);
        return "success";
    }
}
