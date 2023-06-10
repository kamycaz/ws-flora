package com.zopitek.flora.model.projection;

import java.math.BigDecimal;

public interface SaleResponse {

    public Integer getId();

    public String getCreateAt();

    public BigDecimal getMainAmount();

    public BigDecimal getTaxAmount();

    public BigDecimal getTotalAmount();

    public Integer getIdClient();

    public String getName();

    public String getCodInvoice();

    public Boolean getPaid();
}
