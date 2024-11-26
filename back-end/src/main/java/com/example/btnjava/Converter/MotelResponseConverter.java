package com.example.btnjava.Converter;

import com.example.btnjava.Model.DTO.FileDTO;
import com.example.btnjava.Model.Entity.FileEntity;
import com.example.btnjava.Model.Entity.MotelEntity;
import com.example.btnjava.Model.Response.MotelResponse;
import com.example.btnjava.Service.FileService;
import com.example.btnjava.Service.UserService;
import com.example.btnjava.Utils.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MotelResponseConverter {
    private final ModelMapper modelMapper;
    private final FileService fileService;
    private final UserResponseConverter userResponseConverter;

    public List<MotelResponse> toMotelResponse(List<MotelEntity> motelEntities) throws MalformedURLException {
        List<MotelResponse> result = new ArrayList<>();
        for(MotelEntity motelEntity : motelEntities){
            MotelResponse motelResponse = modelMapper.map(motelEntity, MotelResponse.class);
            List<FileDTO> filesDTO = new ArrayList<>();
            List<FileEntity> fileEntities = fileService.findByMotelId(motelEntity.getId());
            for(FileEntity fileEntity : fileEntities){
                FileDTO fileDTO = FileDTO
                        .builder()
                        .id(fileEntity.getId())
                        .name(fileEntity.getName())
                        .fileId(fileEntity.getFileId())
                        .fileUrl(fileEntity.getFileUrl())
                        .build();
                filesDTO.add(fileDTO);
            }
            motelResponse.setFilesDTO(filesDTO);
            if(motelEntity.getStatus() == 1){
                motelResponse.setStatus("Đã Được Duyệt");
            }
            else motelResponse.setStatus("Chưa Được Duyệt");

            result.add(motelResponse);
        }
        Collections.sort(result);
        return result;
    }
    public MotelResponse toMotelResponse(MotelEntity motelEntity) throws MalformedURLException {
            MotelResponse motelResponse = modelMapper.map(motelEntity, MotelResponse.class);
            List<FileDTO> filesDTO = new ArrayList<>();
            List<FileEntity> fileEntities = fileService.findByMotelId(motelEntity.getId());
            for(FileEntity fileEntity : fileEntities){
                FileDTO fileDTO = FileDTO
                        .builder()
                        .id(fileEntity.getId())
                        .name(fileEntity.getName())
                        .fileId(fileEntity.getFileId())
                        .fileUrl(fileEntity.getFileUrl())
                        .build();
                filesDTO.add(fileDTO);
            }
            motelResponse.setFilesDTO(filesDTO);
            if(motelEntity.getStatus() == 1){
                motelResponse.setStatus("Đã Được Duyệt");
            }
            else motelResponse.setStatus("Đang Chờ Duyệt");
            motelResponse.setOwner(userResponseConverter.toUserResponse(motelEntity.getUser()));
            return motelResponse;
    }
    public List<MotelResponse> toMotelResponseByStatus(List<MotelEntity> motelEntities) throws MalformedURLException {
        List<MotelResponse> result = new ArrayList<>();
        for(MotelEntity motelEntity : motelEntities){
            MotelResponse motelResponse = modelMapper.map(motelEntity, MotelResponse.class);
            List<FileDTO> filesDTO = new ArrayList<>();
            List<FileEntity> fileEntities = fileService.findByMotelId(motelEntity.getId());
            for(FileEntity fileEntity : fileEntities){
                FileDTO fileDTO = FileDTO
                        .builder()
                        .id(fileEntity.getId())
                        .name(fileEntity.getName())
                        .fileId(fileEntity.getFileId())
                        .fileUrl(fileEntity.getFileUrl())
                        .build();
                filesDTO.add(fileDTO);
            }
            motelResponse.setFilesDTO(filesDTO);
            if(motelEntity.getStatus() == 1){
                motelResponse.setStatus("Đã Được Duyệt");
                result.add(motelResponse);
            }

        }
        Collections.sort(result);
        return result;
    }
    public List<MotelResponse> toMotelResponseByNonStatus(List<MotelEntity> motelEntities) throws MalformedURLException {
        List<MotelResponse> result = new ArrayList<>();
        for(MotelEntity motelEntity : motelEntities){
            MotelResponse motelResponse = modelMapper.map(motelEntity, MotelResponse.class);
            List<FileDTO> filesDTO = new ArrayList<>();
            List<FileEntity> fileEntities = fileService.findByMotelId(motelEntity.getId());
            for(FileEntity fileEntity : fileEntities){
                FileDTO fileDTO = FileDTO
                        .builder()
                        .id(fileEntity.getId())
                        .name(fileEntity.getName())
                        .fileId(fileEntity.getFileId())
                        .fileUrl(fileEntity.getFileUrl())
                        .build();
                filesDTO.add(fileDTO);
            }
            motelResponse.setFilesDTO(filesDTO);
            if(motelEntity.getStatus() == 0){
                motelResponse.setStatus("Đang Chờ Duyệt");
                result.add(motelResponse);
            }
        }
        Collections.sort(result);
        return result;
    }
}
