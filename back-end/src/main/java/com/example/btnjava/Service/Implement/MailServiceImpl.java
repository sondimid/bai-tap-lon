package com.example.btnjava.Service.Implement;

import com.example.btnjava.Model.Email.MailStructure;
import com.example.btnjava.Service.MailService;
import com.example.btnjava.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final JavaMailSender mailSender;
    private final UserService userService;

    public void sendEmail(String mail) throws Exception {

        String resetToken = generateResetToken();
        userService.saveResetToken(mail, resetToken);

        String resetLink = "http://localhost:8080/reset-password?token=" + resetToken;

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("daongocson12022004@gmail.com");
        simpleMailMessage.setSubject("Reset Password");
        simpleMailMessage.setText("Click vào link sau để đặt lại mật khẩu: \n" + resetLink);
        simpleMailMessage.setTo(mail);

        mailSender.send(simpleMailMessage);
    }

    private String generateResetToken() {
        return UUID.randomUUID().toString();
    }


}
