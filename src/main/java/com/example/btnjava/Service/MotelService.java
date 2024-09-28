package com.example.btnjava.Service;

import com.example.btnjava.Model.DTO.HostalDTO;
import com.example.btnjava.Model.Response.MotelResponse;
import com.example.btnjava.Model.Search.MotelSearchBuilder;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface MotelService {
    List<MotelResponse> findAll(MotelSearchBuilder motelSearchBuilder);
    void save(HostalDTO hostalDTO);
    List<MotelResponse> findAll();
    void markById(Integer Id);
    List<MotelResponse> findAndPagination(Integer page);
}
