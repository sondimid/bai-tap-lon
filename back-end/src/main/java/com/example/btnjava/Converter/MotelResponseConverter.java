package com.example.btnjava.Converter;

import com.example.btnjava.Model.DTO.FileDTO;
import com.example.btnjava.Model.Entity.FileEntity;
import com.example.btnjava.Model.Entity.MotelEntity;
import com.example.btnjava.Model.Response.MotelResponse;
import com.example.btnjava.Service.FileService;
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


    public List<MotelResponse> toMotelResponse(List<MotelEntity> motelEntities) throws MalformedURLException {
        List<MotelResponse> result = new ArrayList<>();
        for(MotelEntity motelEntity : motelEntities){
            MotelResponse motelResponse = modelMapper.map(motelEntity, MotelResponse.class);
            List<FileDTO> filesDTO = new ArrayList<>();
            List<FileEntity> fileEntities = fileService.findByMotelId(motelEntity.getId());
            for(FileEntity fileEntity : fileEntities){
                FileDTO fileDTO = FileDTO
                        .builder()
                        .name(fileEntity.getName())
                        .fileId(fileEntity.getFileId())
                        .fileUrl(fileEntity.getFileUrl())
                        .build();
                filesDTO.add(fileDTO);
            }
            motelResponse.setFilesDTO(filesDTO);
            motelResponse.setAddress("số " + motelEntity.getHouseNumber() + " đường " + motelEntity.getStreet() + " phường "
                                        + motelEntity.getWard() + " quận " + motelEntity.getDistrict() + " thành phố " + motelEntity.getProvince());
            if(motelEntity.getStatus() == 1){
                motelResponse.setStatus("đã duyệt");
            }
            else motelResponse.setStatus("chưa duyệt");

            result.add(motelResponse);
        }
        Collections.sort(result);
        return result;
    }
}
