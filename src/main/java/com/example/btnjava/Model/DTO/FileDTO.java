package com.example.btnjava.Model.DTO;

import com.example.btnjava.Model.Entity.MotelEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.http.MediaType;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class FileDTO {

    private String name;

    private String fileUrl;

    private String fileId;

}
