package com.zopitek.flora.model.projection;

import java.math.BigDecimal;

public interface SaleLineResponse {

    public Integer getId();

    public String getName();

    public BigDecimal getPrize();

    public Integer getQuantity();

    public Integer getIva();

    public BigDecimal getTotalAmount();
}
