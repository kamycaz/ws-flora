package com.zopitek.flora.repository;

import com.zopitek.flora.entity.params.CodInvoice;
import com.zopitek.flora.model.projection.ClientBasicResponse;
import com.zopitek.flora.model.projection.CodInvoiceResponse;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CodInvoiceRepository extends CrudRepository<CodInvoice, Integer> {

    @Query(value = "select id as id, cod_year as year, cod_count as count " +
            "from t_cod_invoice " +
            "where cod_year = :year", nativeQuery = true)
    public CodInvoiceResponse findByYear(@Param("year") Integer year);


    @Transactional
    @Modifying
    @Query(value = "update t_cod_invoice set cod_count = :count where cod_year = :year", nativeQuery = true)
    public void sumCount(@Param("year") Integer year,@Param("count") Integer count);

}
