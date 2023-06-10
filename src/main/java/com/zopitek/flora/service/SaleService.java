package com.zopitek.flora.service;

import com.zopitek.flora.entity.Sale;
import com.zopitek.flora.entity.SaleLine;
import com.zopitek.flora.model.forms.SaleForm;
import com.zopitek.flora.model.projection.SaleLineResponse;
import com.zopitek.flora.model.projection.SaleResponse;

import java.util.ArrayList;
import java.util.List;

public interface SaleService {

    public List<SaleLineResponse> getSaleLines( Integer id) throws Exception;

    public int save(SaleForm saleForm) throws Exception;

    public List<SaleResponse> getSaleList(Integer id) throws Exception;

    public List<SaleResponse> getSales() throws Exception;

    public void setPaid(Integer id) throws Exception;

}
