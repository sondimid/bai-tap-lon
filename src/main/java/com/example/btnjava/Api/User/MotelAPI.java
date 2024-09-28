package com.example.btnjava.Api.User;

import com.example.btnjava.Model.DTO.HostalDTO;
import com.example.btnjava.Model.Response.MotelResponse;
import com.example.btnjava.Model.Search.MotelSearchBuilder;
import com.example.btnjava.Service.MotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motel")
public class MotelAPI {
    @Autowired
    private MotelService motelService;

    @GetMapping("/search")
    public ResponseEntity<Object>searchByMotelSearchBuilder(@RequestBody MotelSearchBuilder motelSearchBuilder) {
        return new ResponseEntity<>(motelService.findAll(motelSearchBuilder), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMotel(@RequestBody HostalDTO hostalDTO){
        motelService.save(hostalDTO);
        return new ResponseEntity<String>("Thêm tòa nhà thành công", HttpStatus.CREATED);
    }
}
