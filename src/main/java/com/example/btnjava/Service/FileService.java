package com.example.btnjava.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {
    void store (MultipartFile file) throws IOException;
}
