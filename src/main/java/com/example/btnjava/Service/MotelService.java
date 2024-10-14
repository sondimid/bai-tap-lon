package com.example.btnjava.Service;

import com.example.btnjava.Model.DTO.MotelDTO;
import com.example.btnjava.Model.Response.MotelResponse;
import com.example.btnjava.Model.Search.MotelSearchBuilder;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface MotelService {
    List<MotelResponse> findAll(MotelSearchBuilder motelSearchBuilder) throws IOException;
    ResponseEntity<?> save(MotelDTO motelDTO, String token) throws IOException;
    List<MotelResponse> findAll() throws IOException;
    ResponseEntity<?> markMotelByIds(List<Integer> ids);
    List<MotelResponse> findAndPagination(Integer page) throws IOException;

}
