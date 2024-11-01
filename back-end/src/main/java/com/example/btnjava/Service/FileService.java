package com.example.btnjava.Service;

import com.example.btnjava.Model.Entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface FileService {
    void save(Map result);
    List<FileEntity> findByMotelId(Integer id);
}
