package com.example.btnjava.Service.Implement;

import com.cloudinary.Cloudinary;
import com.example.btnjava.Service.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService {
    private final Cloudinary cloudinary;
    @Override
    public Map uploadFiles(MultipartFile file) throws IOException {
        Map result = cloudinary.uploader().upload(file.getBytes(), Map.of());
        return result;
    }
}
