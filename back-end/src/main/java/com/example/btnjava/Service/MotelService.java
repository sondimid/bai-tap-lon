package com.example.btnjava.Service;

import com.example.btnjava.Model.DTO.MotelDTO;
import com.example.btnjava.Model.PageResponse.PageResponse;
import com.example.btnjava.Model.Response.MotelResponse;
import com.example.btnjava.Model.Search.MotelSearchBuilder;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.query.Page;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface MotelService {
    PageResponse findAll(MotelSearchBuilder motelSearchBuilder) throws MalformedURLException;
    void save(MotelDTO motelDTO, String token) throws IOException;
    List<MotelResponse> findAll() throws MalformedURLException;
    List<MotelResponse> findByStatus() throws MalformedURLException;
    List<MotelResponse> findByNonStatus() throws MalformedURLException;
    void markById(List<Integer> Id, Integer status);
    List<MotelResponse> findAndPagination(Integer page) throws MalformedURLException;
    List<MotelResponse> findByUserName(String name) throws MalformedURLException;
    MotelResponse findById(Integer Id) throws MalformedURLException;
    List<MotelResponse> adminFindByUserId(Integer userId) throws MalformedURLException;
    String deleteMotels(Integer userId, List<Integer> ids) throws MalformedURLException;
    String deleteOrUnpublishMotel(List<Integer> ids, Boolean isDelete);
    List<MotelResponse> findByRadius(String destination,Integer radius) throws MalformedURLException;
    List<MotelResponse> getFavorite(String token) throws MalformedURLException;
}
