package com.example.btnjava.Repository.Custom;

import com.example.btnjava.Model.Entity.MotelEntity;
import com.example.btnjava.Model.Search.MotelSearchBuilder;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MotelRepositoryCustom {
    List<MotelEntity> searchByMotelSearchBuilder(MotelSearchBuilder motelSearchBuilder, Pageable pageable);
    List<MotelEntity> searchByMotelSearchBuilder(MotelSearchBuilder motelSearchBuilder);
}
