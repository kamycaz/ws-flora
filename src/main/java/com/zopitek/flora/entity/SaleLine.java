package com.zopitek.flora.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zopitek.flora.entity.params.SaleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "t_sale_line")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SaleLine implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "prize")
    private BigDecimal prize;

    @Column(name = "IVA")
    private int iva;

    @Column(name = "discount")
    private int discount;

    @Column(name = "totalAmount")
    private BigDecimal totalAmount;


    @Column(name = "create_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createAt;


    @PrePersist
    public void prePersist() {
        createAt = LocalDate.now();
    }


}
