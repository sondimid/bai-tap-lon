package com.example.btnjava.Service.Implement;

import com.example.btnjava.Converter.MotelResponseConverter;
import com.example.btnjava.Filter.JwtTokenFilter;
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
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public List<MotelResponse> findAll(MotelSearchBuilder motelSearchBuilder) throws IOException {
        Pageable pageable = PageRequest.of(motelSearchBuilder.getPage()-1, motelSearchBuilder.getMaxPageItems());
        List<MotelEntity> motelEntities = motelRepository.searchByHostalSearchBuilder(motelSearchBuilder, pageable);
        return motelResponseConverter.toMotelResponse(motelEntities);
    }

    @Override
    public ResponseEntity<?> save(MotelDTO motelDTO, String token) throws IOException {
        String userName = jwtTokenUtils.extractUsername(token);
        Optional<UserEntity> userOptional = userService.findById(motelDTO.getId());
        if(userOptional.isEmpty()) throw new UsernameNotFoundException("User not found");
        if(!userOptional.get().getUsername().equals(userName))
            return ResponseEntity.badRequest().body("Unauthorized");
        MotelEntity motelEntity = modelMapper.map(motelDTO, MotelEntity.class);
        motelRepository.save(motelEntity);
        List<MultipartFile> files = motelDTO.getFiles();
        for (MultipartFile file : files) {
            Map result = cloudinaryService.uploadFiles(file);
            FileEntity fileEntity = FileEntity
                    .builder()
                    .url(result.get("url").toString())
                    .motelEntity(motelEntity)
                    .motelId(motelEntity.getId())
                    .name(result.get("original_filename").toString())
                    .build();
            motelEntity.getFileEntities().add(fileEntity);
        }
        UserEntity userEntity = userOptional.get();
        motelEntity.setUserEntity(userEntity);
        motelRepository.save(motelEntity);
        return ResponseEntity.accepted().body("Created!");
    }

    @Override
    public List<MotelResponse> findAll() throws IOException {
        List<MotelEntity> motelEntities = motelRepository.findAll();
        return motelResponseConverter.toMotelResponse(motelEntities);
    }

    @Override
    public ResponseEntity<?> markMotelByIds(List<Integer> ids) {
        for(Integer id : ids) {
            Optional<MotelEntity> motelOptional = motelRepository.findById(id);
            if(motelOptional.isEmpty()) return ResponseEntity.badRequest().body(String.format("id %d not found", id));
            MotelEntity motelEntity = motelOptional.get();
            motelEntity.setStatus(1-motelEntity.getStatus());
            motelRepository.save(motelEntity);
        }
        return ResponseEntity.ok().body("Add Success");
    }

    @Override
    public List<MotelResponse> findAndPagination(Integer page) throws IOException {
        Page<MotelEntity> motelResponses = motelRepository.findAll(PageRequest.of(page-1, 3));
        return motelResponseConverter.toMotelResponse(motelResponses.getContent());
    }
}
