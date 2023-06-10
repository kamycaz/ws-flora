package com.zopitek.flora.entity.params;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_cod_invoice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodInvoice {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cod_year")
    private Integer year;

    @Column(name = "cod_count")
    private Integer count;
}
