package com.example.btnjava.Converter;

import com.example.btnjava.Model.Entity.MotelEntity;
import com.example.btnjava.Model.Response.MotelResponse;
import com.example.btnjava.Utils.GetFiles;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MotelResponseConverter {

    private final GetFiles getFiles;
    private final ModelMapper modelMapper;

    public List<MotelResponse> toMotelResponse(List<MotelEntity> motelEntities) throws MalformedURLException {
        List<MotelResponse> result = new ArrayList<>();
        for(MotelEntity motelEntity : motelEntities){
            MotelResponse motelResponse = modelMapper.map(motelEntity, MotelResponse.class);
            motelResponse.setFiles(getFiles.fromUrlFiles(motelResponse.getUrlFiles().split(", ")));
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
