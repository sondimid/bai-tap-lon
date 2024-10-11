package com.example.btnjava.Service.Implement;

import com.example.btnjava.Model.Entity.FileEntity;
import com.example.btnjava.Repository.FileRepository;
import com.example.btnjava.Service.FileService;
import com.example.btnjava.Utils.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    @Override
    public void save(Map result)  {
        FileEntity fileEntity = FileEntity
                .builder()
                .name(result.get("original_filename").toString())
                .fileUrl(result.get("url").toString())
                .fileId(result.get("public_id").toString())
                .build();
        fileRepository.save(fileEntity);
    }

    @Override
    public List<FileEntity> findByMotelId(Integer id) {
        return fileRepository.findByMotelId(id);
    }
}
