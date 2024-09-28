package com.example.btnjava.Converter;

import com.example.btnjava.Model.Entity.MotelEntity;
import com.example.btnjava.Model.Response.MotelResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class MotelResponseConverter {

    @Autowired
    private ModelMapper modelMapper;

    public List<MotelResponse> toHostalResponse(List<MotelEntity> hostalEntities){
        List<MotelResponse> result = new ArrayList<>();
        for(MotelEntity motelEntity : hostalEntities){
            MotelResponse motelResponse = modelMapper.map(motelEntity, MotelResponse.class);
            motelResponse.setManagerName(motelEntity.getUser().getName());
            motelResponse.setPhoneNumber(motelEntity.getUser().getPhoneNumber());
            motelResponse.setAddress("số " + motelEntity.getHouseNumber() + " đường " + motelEntity.getStreet() + " phường "
                                        + motelEntity.getWard() + " quận " + motelEntity.getDistrict() + " thành phố " + motelEntity.getProvince());
            if(motelEntity.getStatus() == 1){
                motelResponse.setStatus("đã duyệt");
            }
            else motelResponse.setStatus("chưa duyệt");
            result.add(motelResponse);
        }
        Collections.sort(result);
        return result;
    }
}
