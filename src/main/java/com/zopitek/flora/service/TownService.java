package com.zopitek.flora.service;

import com.zopitek.flora.model.projection.BasicResponse;
import com.zopitek.flora.model.projection.TownResponse;

import java.util.List;

public interface TownService {

    public List<TownResponse> getTownByProvince(Integer id) throws Exception;
}
