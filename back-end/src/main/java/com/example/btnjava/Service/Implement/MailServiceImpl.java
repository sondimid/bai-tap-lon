package com.example.btnjava.Service.Implement;

import com.example.btnjava.Model.Email.MailStructure;
import com.example.btnjava.Service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final JavaMailSender mailSender;

    public void sendEmail(String mail, MailStructure mailStructure) {

        // Tạo reset token ngẫu nhiên và lưu vào database
//        String resetToken = generateResetToken();
//        saveResetToken(mail, resetToken); // Lưu token và email vào DB

        // Tạo reset link
        String resetLink = "http://localhost:8081/dashboard";

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("daongocson12022004@gmail.com");
        simpleMailMessage.setSubject("Reset Password");
        simpleMailMessage.setText("Click vào link sau để đặt lại mật khẩu: \n" + resetLink);
        simpleMailMessage.setTo(mail);

        mailSender.send(simpleMailMessage);
    }

//    private String generateResetToken() {
//        // Tạo token ngẫu nhiên, có thể dùng UUID
//        return UUID.randomUUID().toString();
//    }


}
