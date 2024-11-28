package com.example.btnjava.Utils;

import com.example.btnjava.Service.MotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetPageSize {
    private final MotelService motelService;
    public Integer pageSize(Integer size) {
        return null;
    }
}
