package com.example.btnjava.Service;

import com.example.btnjava.Model.Email.MailStructure;

public interface MailService {
    void sendEmail(String mail, MailStructure mailStructure);
}
