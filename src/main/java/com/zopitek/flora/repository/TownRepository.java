package com.zopitek.flora.repository;

import com.zopitek.flora.entity.Client;
import com.zopitek.flora.entity.location.Town;
import com.zopitek.flora.model.projection.BasicResponse;
import com.zopitek.flora.model.projection.TownResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TownRepository extends CrudRepository<Town, Long> {

    @Query(value = "select t.id as id, t.name as name, t.cp as cp " +
            "from t_town as t, t_province as p " +
            " where t.id_province = p.id and p.id = :id " +
            "  order by p.name ASC", nativeQuery = true)
    public List<TownResponse> findTownByIdProvince(@Param("id") Integer id);

}
