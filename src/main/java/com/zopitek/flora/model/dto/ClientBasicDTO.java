package com.zopitek.flora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ClientBasicDTO {

    private Long id;
    private String name;
    private String town;
}
