package com.example.btnjava.Repository;

import com.example.btnjava.Model.Entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, Integer>, PagingAndSortingRepository<FileEntity, Integer> {
    List<FileEntity> findByMotelId(Integer id);
}
