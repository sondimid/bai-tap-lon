package com.example.btnjava.Service.Implement;

import com.example.btnjava.Converter.MotelResponseConverter;
import com.example.btnjava.Model.DTO.MotelDTO;
import com.example.btnjava.Model.Entity.MotelEntity;
import com.example.btnjava.Repository.MotelRepository;
import com.example.btnjava.Model.Response.MotelResponse;
import com.example.btnjava.Model.Search.MotelSearchBuilder;
import com.example.btnjava.Service.MotelService;
import com.example.btnjava.Service.StorageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MotelServiceImpl implements MotelService {
    @Autowired
    private MotelRepository motelRepository;

    @Autowired
    private MotelResponseConverter motelResponseConverter;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StorageService storageService;

    @Override
    public List<MotelResponse> findAll(MotelSearchBuilder motelSearchBuilder) {
        Pageable pageable = PageRequest.of(motelSearchBuilder.getPage()-1, motelSearchBuilder.getMaxPageItems());
        List<MotelEntity> hostalEntities = motelRepository.searchByHostalSearchBuilder(motelSearchBuilder, pageable);
        return motelResponseConverter.toMotelResponse(hostalEntities);
    }

    @Override
    public void save(MotelDTO motelDTO) {
        MotelEntity motelEntity = modelMapper.map(motelDTO, MotelEntity.class);
        List<MultipartFile> files = motelDTO.getFiles();
        for (MultipartFile file : files) {
            storageService.store(file);
        }
        motelEntity.setUrlFiles(files.stream()
                .map(MultipartFile::getOriginalFilename)
                .collect(Collectors.joining(", ")));
        motelRepository.save(motelEntity);
    }

    @Override
    public List<MotelResponse> findAll() {
        List<MotelEntity> motelEntities = motelRepository.findAll();
        return motelResponseConverter.toMotelResponse(motelEntities);
    }

    @Override
    public void markById(Integer Id) {
        MotelEntity motelEntity = motelRepository.findById(Id).get();
        motelEntity.setStatus(1-motelEntity.getStatus());
        motelRepository.save(motelEntity);
    }

    @Override
    public List<MotelResponse> findAndPagination(Integer page) {
        Page<MotelEntity> motelResponses = motelRepository.findAll(PageRequest.of(page-1, 3));
        return motelResponseConverter.toMotelResponse(motelResponses.getContent());
    }
}
