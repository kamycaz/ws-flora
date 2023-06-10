package com.zopitek.flora.model.projection;

import java.math.BigDecimal;

public interface ProductResponse {

    public Integer getId();
       public String getName();
       public String getDescription();

       public BigDecimal getPrize();

       public Integer getIva();
}
