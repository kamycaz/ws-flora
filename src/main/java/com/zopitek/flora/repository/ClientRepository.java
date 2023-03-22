package com.zopitek.flora.repository;

import com.zopitek.flora.entity.Client;
import com.zopitek.flora.model.projection.ClientBasicResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {

    @Query(value = "select id, com_name from t_client", nativeQuery = true)
    public List<ClientBasicResponse> findBasicList();
}
