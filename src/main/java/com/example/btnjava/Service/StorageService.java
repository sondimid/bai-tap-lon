package com.example.btnjava.Service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    void store (MultipartFile file);
}
