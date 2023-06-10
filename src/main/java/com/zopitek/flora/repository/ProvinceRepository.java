package com.zopitek.flora.repository;

import com.zopitek.flora.entity.Product;
import com.zopitek.flora.entity.location.Province;
import com.zopitek.flora.model.dto.BasicDTO;
import com.zopitek.flora.model.projection.BasicResponse;
import com.zopitek.flora.model.projection.ClientBasicResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProvinceRepository extends CrudRepository<Province, Long> {

    @Query(value = "select p.id as id, p.name as name " +
            "from t_province as p, t_region as r " +
            "where p.id_region = r.id and r.id = :id " +
            "  order by p.name ASC", nativeQuery = true)
    public List<BasicResponse> findProvincesByIdRegion(@Param("id") Integer id);


}
