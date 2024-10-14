package com.example.btnjava.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CloudinaryService {
    Map uploadFiles(MultipartFile files) throws IOException;
}
