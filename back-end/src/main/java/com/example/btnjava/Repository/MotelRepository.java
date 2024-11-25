package com.example.btnjava.Repository;


import com.example.btnjava.Model.Entity.MotelEntity;
import com.example.btnjava.Repository.Custom.MotelRepositoryCustom;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface MotelRepository extends JpaRepository<MotelEntity, Integer>, MotelRepositoryCustom, PagingAndSortingRepository<MotelEntity, Integer> {
    Optional<List<MotelEntity>> findByUserId(Integer id);
    void deleteById(Integer id);
}
