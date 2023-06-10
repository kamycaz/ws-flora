package com.zopitek.flora.repository;

import com.zopitek.flora.entity.Sale;
import com.zopitek.flora.entity.SaleLine;
import com.zopitek.flora.model.projection.ClientBasicResponse;
import com.zopitek.flora.model.projection.SaleLineResponse;
import com.zopitek.flora.model.projection.SaleResponse;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SaleRepository extends CrudRepository<Sale, Long> {

    @Query(value = "select s.id as id, s.create_at as createAt, s.main_amount as mainAmount, s.tax_amount as taxAmount, s.total_amount as totalAmount, s.id_client as idClient, c.com_name as name, s.cod_invoice as codInvoice, s.paid as paid" +
            " from t_sale s, t_client c" +
            " where s.id_client = :id" +
            " and s.id_client = c.id " +
            " order by s.create_at DESC", nativeQuery = true)
    public List<SaleResponse> findSalesClient(@Param("id") Integer id);

    @Query(value = "select s.id as id, s.create_at as createAt, s.main_amount as mainAmount, s.tax_amount as taxAmount, s.total_amount as totalAmount, s.id_client as idClient, c.com_name as name, s.cod_invoice as codInvoice, s.paid as paid" +
            " from t_sale s, t_client c" +
            " where s.id_client = c.id " +
            " order by s.create_at DESC", nativeQuery = true)
    public List<SaleResponse> findSales();

    @Query(value = "select sl.id as id, p.name as name, sl.prize as prize, sl.quantity as quantity, sl.iva as iva, sl.total_amount as totalAmount" +
            " from t_sale_line sl, t_product p" +
            " where sl.id_sale = :id" +
            " and sl.id_product = p.id ", nativeQuery = true)
    public List<SaleLineResponse> findSalesLine(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "update t_sale set paid = true where id = :id", nativeQuery = true)
    public void setPaid(@Param("id") Integer id);


}
