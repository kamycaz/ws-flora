package com.zopitek.flora.service.imp;


import com.zopitek.flora.model.projection.BasicResponse;
import com.zopitek.flora.model.projection.TownResponse;
import com.zopitek.flora.repository.TownRepository;
import com.zopitek.flora.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TownServiceImp implements TownService {

    @Autowired
    private TownRepository townRepository;

    @Override
    public List<TownResponse> getTownByProvince(Integer id) throws Exception {
        try {
            return (List<TownResponse>) townRepository.findTownByIdProvince(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
