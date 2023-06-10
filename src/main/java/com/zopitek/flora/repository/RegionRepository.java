package com.zopitek.flora.repository;

import com.zopitek.flora.entity.Product;
import com.zopitek.flora.entity.location.Region;
import org.springframework.data.repository.CrudRepository;

public interface RegionRepository extends CrudRepository<Region, Long> {
}
