package com.example.btnjava.Converter;

import com.example.btnjava.Model.Entity.MotelEntity;
import com.example.btnjava.Model.Response.MotelResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MotelResponseConverter {

    private final ModelMapper modelMapper;

    public List<MotelResponse> toMotelResponse(List<MotelEntity> motelEntities) throws IOException {
        List<MotelResponse> result = new ArrayList<>();
        for(MotelEntity motelEntity : motelEntities){
            MotelResponse motelResponse = modelMapper.map(motelEntity, MotelResponse.class);
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
