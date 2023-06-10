package com.zopitek.flora.model.forms;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SaleForm {
    private int id;
    private ArrayList<SaleLineForm> lines;
}
