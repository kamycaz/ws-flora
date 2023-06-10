package com.zopitek.flora.service.imp;

import com.zopitek.flora.entity.location.Province;
import com.zopitek.flora.model.dto.BasicDTO;
import com.zopitek.flora.model.projection.BasicResponse;
import com.zopitek.flora.repository.ProvinceRepository;
import com.zopitek.flora.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvinceServiceImp implements ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;
    @Override
    public ArrayList<Province> get() throws Exception {
        try {
            return (ArrayList<Province>) provinceRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<BasicResponse> getByRegion(Integer id) throws Exception {
        try {
            return provinceRepository.findProvincesByIdRegion(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
