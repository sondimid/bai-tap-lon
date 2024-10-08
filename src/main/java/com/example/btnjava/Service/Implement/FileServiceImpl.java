package com.example.btnjava.Service.Implement;

import com.example.btnjava.CustomException.StorageException;
import com.example.btnjava.Model.Entity.FileEntity;
import com.example.btnjava.Repository.FileRepository;
import com.example.btnjava.Service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;


@Service
@RequiredArgsConstructor
public class StorageServiceImpl  implements StorageService {
    private final FileRepository fileRepository;
    private final Path rootLocation = Paths.get("src/main/resources/static/uploads");

    @Override
    public void store(MultipartFile file) throws IOException {
        FileEntity fileEntity = FileEntity
                .builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .data(file.getBytes())
                .build();
        fileRepository.save(fileEntity);
    }
}
