package com.example.btnjava.Config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "diciiz6j4");
        config.put("api_key", "152653983847719");
        config.put("api_secret", "4T78J8m9PuhKZAeWU643DcrfSAY");
        return new Cloudinary(config);
    }
}
