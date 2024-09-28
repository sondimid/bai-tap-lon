package com.example.btnjava.Repository;


import com.example.btnjava.Model.Entity.MotelEntity;
import com.example.btnjava.Repository.Custom.MotelRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotelRepository extends JpaRepository<MotelEntity, Integer>, MotelRepositoryCustom {

}
