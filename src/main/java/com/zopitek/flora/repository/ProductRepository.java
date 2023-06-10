package com.zopitek.flora.repository;

import com.zopitek.flora.entity.Product;
import com.zopitek.flora.model.projection.ClientBasicResponse;
import com.zopitek.flora.model.projection.ProductResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "select p.id as id, p.name as name, p.description as description, p.prize as prize, p.iva as iva " +
            "from t_product p " +
            "where UPPER(p.name) LIKE UPPER(CONCAT('%',:name, '%')) " +
            "order by p.name ASC", nativeQuery = true)
    public List<ProductResponse> findBasicListByName(@Param("name")String name);


}
