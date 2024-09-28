package com.example.btnjava.Service.Implement;

import com.example.btnjava.Converter.MotelResponseConverter;
import com.example.btnjava.Model.DTO.HostalDTO;
import com.example.btnjava.Model.Entity.MotelEntity;
import com.example.btnjava.Repository.MotelRepository;
import com.example.btnjava.Model.Response.MotelResponse;
import com.example.btnjava.Model.Search.MotelSearchBuilder;
import com.example.btnjava.Service.MotelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotelServiceImpl implements MotelService {
    @Autowired
    private MotelRepository motelRepository;

    @Autowired
    private MotelResponseConverter motelResponseConverter;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<MotelResponse> findAll(MotelSearchBuilder motelSearchBuilder) {
        Pageable pageable = PageRequest.of(motelSearchBuilder.getPage()-1, motelSearchBuilder.getMaxPageItems());
        List<MotelEntity> hostalEntities = motelRepository.searchByHostalSearchBuilder(motelSearchBuilder, pageable);
        return motelResponseConverter.toHostalResponse(hostalEntities);
    }

    @Override
    public void save(HostalDTO hostalDTO) {
        MotelEntity motelEntity = modelMapper.map(hostalDTO, MotelEntity.class);
        motelRepository.save(motelEntity);
    }

    @Override
    public List<MotelResponse> findAll() {
        List<MotelEntity> motelEntities = motelRepository.findAll();
        return motelResponseConverter.toHostalResponse(motelEntities);
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
        return motelResponseConverter.toHostalResponse(motelResponses.getContent());
    }
}
