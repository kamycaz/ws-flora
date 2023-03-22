package com.zopitek.flora.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ErrorResponseDTO {
    private String description;

    public ErrorResponseDTO(String description) {
        this.description = description;

    }
}


