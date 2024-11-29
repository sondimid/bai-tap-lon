package com.example.btnjava.Service;

import java.io.IOException;

public interface SmsService {
    String sendSMS(String to, String content, int type, String sender) throws IOException;
}
