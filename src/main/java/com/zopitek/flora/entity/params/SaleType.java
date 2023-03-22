package com.zopitek.flora.entity.params;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "t_sale_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cod")
    private String cod;

    @Column(name = "description")
    private String description;


}
