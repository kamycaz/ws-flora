package com.zopitek.flora.service.imp;

import com.zopitek.flora.entity.location.Region;
import com.zopitek.flora.repository.RegionRepository;
import com.zopitek.flora.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImp implements RegionService {

@Autowired
private RegionRepository regionRepository;
    @Override
    public List<Region> get() throws Exception {
        try {
            return (List<Region>) regionRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
