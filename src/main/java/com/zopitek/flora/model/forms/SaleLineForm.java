package com.zopitek.flora.model.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class SaleLineForm {
    private int id;
    private int quantity;
    private BigDecimal prize;
    private int iva;
    private int discount;
    private BigDecimal totalAmount;
}
