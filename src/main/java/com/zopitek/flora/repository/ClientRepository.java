package com.zopitek.flora.repository;

import com.zopitek.flora.entity.Client;
import com.zopitek.flora.model.projection.ClientBasicResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    @Query(value = "select c.id as id, c.com_name as name, t.name as town " +
            "from t_client as c, t_town as t " +
            "where c.id_town = t.id order by t.name ASC", nativeQuery = true)
    public List<ClientBasicResponse> findBasicList();

    @Query(value = "select c.id as id, c.com_name as name, t.name as town from t_client as c, t_town as t " +
            "where c.id_town = t.id and " +
            " UPPER(c.com_name) LIKE UPPER(CONCAT('%',:name, '%')) " +
            "order by t.name ASC", nativeQuery = true)
    public List<ClientBasicResponse> findBasicListByName(@Param("name")String name);

    @Query(value = "select c.id as id, c.com_name as name, t.name as town, c.fiscal_name as fiscal, c.phone as phone, c.address as address, p.name as province, r.name as region from t_client c, t_town t, t_province  p, t_region r" +
            " where c.id_town = t.id " +
            " and t.id = p.id and p.id = r.id" +
            " order by t.name ASC", nativeQuery = true)
    public List<ClientBasicResponse> findClientList();
}
