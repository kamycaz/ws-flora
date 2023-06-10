package com.zopitek.flora.service;

import com.zopitek.flora.entity.location.Province;
import com.zopitek.flora.model.dto.BasicDTO;
import com.zopitek.flora.model.projection.BasicResponse;

import java.util.ArrayList;
import java.util.List;

public interface ProvinceService {

    public ArrayList<Province> get() throws Exception;

    public List<BasicResponse> getByRegion(Integer id) throws Exception;
}
