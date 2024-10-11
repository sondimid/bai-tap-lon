package com.example.btnjava.Service.Implement;

import com.example.btnjava.Converter.MotelResponseConverter;
import com.example.btnjava.CustomException.NotFoundException;
import com.example.btnjava.Model.DTO.MotelDTO;
import com.example.btnjava.Model.Entity.FileEntity;
import com.example.btnjava.Model.Entity.MotelEntity;
import com.example.btnjava.Model.Entity.UserEntity;
import com.example.btnjava.Repository.MotelRepository;
import com.example.btnjava.Model.Response.MotelResponse;
import com.example.btnjava.Model.Search.MotelSearchBuilder;
import com.example.btnjava.Service.CloudinaryService;
import com.example.btnjava.Service.MotelService;
import com.example.btnjava.Service.UserService;
import com.example.btnjava.Utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MotelServiceImpl implements MotelService {
    private final MotelRepository motelRepository;
    private final MotelResponseConverter motelResponseConverter;
    private final ModelMapper modelMapper;
    private final CloudinaryService cloudinaryService;
    private final UserService userService;
    private final JwtTokenUtils jwtTokenUtils;

    @Override
    public List<MotelResponse> findAll(MotelSearchBuilder motelSearchBuilder) throws MalformedURLException {
        Pageable pageable = PageRequest.of(motelSearchBuilder.getPage()-1, motelSearchBuilder.getMaxPageItems() + 10);
        List<MotelEntity> motelEntities = motelRepository.searchByMotelSearchBuilder(motelSearchBuilder, pageable);
        return motelResponseConverter.toMotelResponse(motelEntities);
    }

    @Override
    public void save(MotelDTO motelDTO, String token) throws IOException {
        Optional<UserEntity> userEntityOptional = userService.findById(motelDTO.getUserId());
        if(userEntityOptional.isEmpty()) throw new NotFoundException("User not found");
        if(!jwtTokenUtils.isTokenUserNameValid(token.substring(7), userEntityOptional.get().getUsername())){
            throw new NotFoundException("Unauthorized");
        }
        MotelEntity motelEntity = modelMapper.map(motelDTO, MotelEntity.class);
        motelEntity.setUserId(motelDTO.getUserId());
        motelEntity.setUser(userEntityOptional.get());
        motelRepository.save(motelEntity);

        List<MultipartFile> files = motelDTO.getFiles();
        for(MultipartFile file : files){
            Map result = cloudinaryService.uploadFile(file);
            FileEntity fileEntity = FileEntity
                    .builder()
                    .name(result.get("original_filename").toString())
                    .fileUrl(result.get("url").toString())
                    .fileId(result.get("public_id").toString())
                    .motelId(motelEntity.getId())
                    .motelEntity(motelEntity)
                    .build();
            motelEntity.getFileEntities().add(fileEntity);
        }
        motelRepository.save(motelEntity);
    }

    @Override
    public List<MotelResponse> findAll() throws MalformedURLException {
        List<MotelEntity> motelEntities = motelRepository.findAll(Sort.by("created_at").descending().and(Sort.by("updated_at").descending().and(Sort.by("status").ascending())));
        return motelResponseConverter.toMotelResponse(motelEntities);
    }

    @Override
    public void markById(Integer Id) {
        MotelEntity motelEntity = motelRepository.findById(Id).get();
        motelEntity.setStatus(1-motelEntity.getStatus());
        motelRepository.save(motelEntity);
    }

    @Override
    public List<MotelResponse> findAndPagination(Integer page) throws MalformedURLException {
        Page<MotelEntity> motelResponses = motelRepository.findAll(PageRequest.of(page-1, 4, Sort.by("created_at").descending().and(Sort.by("updated_at").descending().and(Sort.by("status").ascending()))));
        return motelResponseConverter.toMotelResponse(motelResponses.getContent());
    }

    @Override
    public List<MotelResponse> findByUserName(String name) throws MalformedURLException {
        Optional<UserEntity> user = userService.findByUserName(name);
        if(user.isEmpty()) throw new NotFoundException("User not found");
        Optional<List<MotelEntity>> motelEntities = motelRepository.findByUserId(user.get().getId());
        if(motelEntities.isEmpty()) throw new NotFoundException("Empty");
        return motelResponseConverter.toMotelResponse(motelEntities.get());
    }
}
