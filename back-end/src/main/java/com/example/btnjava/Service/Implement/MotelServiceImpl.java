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
import com.example.btnjava.Service.FileService;
import com.example.btnjava.Service.MotelService;
import com.example.btnjava.Service.UserService;
import com.example.btnjava.Utils.JwtTokenUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
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
    private final FileService fileService;

    @Override
    public List<MotelResponse> findAll(MotelSearchBuilder motelSearchBuilder) throws MalformedURLException {
        Pageable pageable = PageRequest.of(motelSearchBuilder.getPage()-1, motelSearchBuilder.getMaxPageItems() + 10);
        List<MotelEntity> motelEntities = motelRepository.searchByMotelSearchBuilder(motelSearchBuilder, pageable);
        return motelResponseConverter.toMotelResponse(motelEntities);
    }

    @Override
    public void save(MotelDTO motelDTO, String token) throws IOException {
        if(motelDTO.getId() != null){
            MotelEntity motelEntity = motelRepository.findById(motelDTO.getId()).get();
            motelEntity.setTitle(motelDTO.getTitle());
            motelEntity.setArea(motelDTO.getArea());
            motelEntity.setPrice(motelDTO.getPrice());
            motelEntity.setMaxPeople(motelDTO.getMaxPeople());
            motelEntity.setType(motelDTO.getType());
            motelEntity.setDetail(motelDTO.getDetail());
            motelRepository.save(motelEntity);
            List<Integer> listFileId = motelDTO.getListFileId();
            if(listFileId != null){
                for(Integer fileId : listFileId){
                    FileEntity fileEntity = fileService.findById(fileId);
                    motelEntity.getFileEntities().remove(fileEntity);
                    fileEntity.setMotelEntity(null);
                    fileService.deleteById(fileId);
                }
            }
            List<MultipartFile> files = motelDTO.getFiles();
            if(files != null && !files.isEmpty()) {
                for(MultipartFile file : files) {
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
            }
            motelRepository.save(motelEntity);
        }
        else{
            Integer id = jwtTokenUtils.extractUserId(token);
            Optional<UserEntity> userEntityOptional = userService.findById(id);
            if(userEntityOptional.isEmpty()) throw new NotFoundException("User not found");
            MotelEntity motelEntity = modelMapper.map(motelDTO, MotelEntity.class);
            motelEntity.setUserId(id);
            motelEntity.setUser(userEntityOptional.get());
            motelRepository.save(motelEntity);

            List<MultipartFile> files = motelDTO.getFiles();
            if(files != null && !files.isEmpty()) {
                for(MultipartFile file : files) {
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
            }
            motelRepository.save(motelEntity);
        }
    }

    @Override
    public List<MotelResponse> findAll() throws MalformedURLException {
//        List<MotelEntity> motelEntities = motelRepository.findAll(Sort.by("created_at").descending().and(Sort.by("updated_at").descending().and(Sort.by("status").ascending())));

        return motelResponseConverter.toMotelResponse(motelRepository.findAll());
    }

    @Override
    public List<MotelResponse> findByStatus() throws MalformedURLException {
        List<MotelEntity> motelEntities = motelRepository.findAll();
        return motelResponseConverter.toMotelResponseByStatus(motelEntities);
    }

    @Override
    public List<MotelResponse> findByNonStatus() throws MalformedURLException {
        List<MotelEntity> motelEntities = motelRepository.findAll();
        return motelResponseConverter.toMotelResponseByNonStatus(motelEntities);
    }

    @Override
    public void markById(List<Integer> ids, Integer status) {
        for(Integer id: ids){
            if(status == 1){
                MotelEntity motelEntity = motelRepository.findById(id).get();
                motelEntity.setStatus(status);
                motelRepository.save(motelEntity);
            }
            else{
                motelRepository.deleteById(id);
            }
        }
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

    @Override
    public MotelResponse findById(Integer Id) throws MalformedURLException {
        MotelEntity motelEntity = motelRepository.findById(Id).get();
        return motelResponseConverter.toMotelResponse(motelEntity);
    }

    @Override
    public List<MotelResponse> adminFindByUserId(Integer userId) throws MalformedURLException {
        UserEntity user = userService.findById(userId).get();
        return motelResponseConverter.toMotelResponse(user.getMotelEntities());
    }

    @Override
    @Transactional
    public String deleteMotels(Integer userId, List<Integer> ids) throws MalformedURLException {
        UserEntity user = userService.findById(userId).get();

        for(Integer id: ids) {
            Optional<MotelEntity> motelOpt = motelRepository.findById(id);
            if(!motelOpt.isPresent()) {
                return "Không Tồn Tại Nhà Trọ Id: " + id;
            }

            MotelEntity motel = motelOpt.get();
            if(!motel.getUserId().equals(userId)) {
                return "Không Có Quyền Xóa Nhà Trọ Id: " + id;
            }

            user.getMotelEntities().remove(motel);
            motel.setUser(null);

            motelRepository.delete(motel);
        }

        return "Xóa Nhà Trọ Thành Công";
    }

    @Override
    public String deleteOrUnpublishMotel(List<Integer> ids, Boolean isDelete) {
        if(isDelete){
            for(Integer id: ids) {
                Optional<MotelEntity> motelOpt = motelRepository.findById(id);
                if(!motelOpt.isPresent()) {
                    return "Không Tồn Tại Nhà Trọ Id: " + id;
                }
                MotelEntity motel = motelOpt.get();
                UserEntity user = userService.findById(motel.getUserId()).get();
                user.getMotelEntities().remove(motel);
                motel.setUser(null);

                motelRepository.delete(motel);
            }
            return "Xóa Nhà Trọ Thành Công";
        }
        for(Integer id: ids) {
            MotelEntity motelEntity = motelRepository.findById(id).get();
            motelEntity.setStatus(0);
            motelRepository.save(motelEntity);
        }
        return "Gỡ Bài Đăng Thành Công";
    }
}
