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
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_invoice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cod")
    private BigDecimal cod;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @Column(name = "main_amount")
    private BigDecimal mainAmount;

    @Column(name = "iva_amount")
    private BigDecimal taxAmount;

    @Column(name = "re")
    private BigDecimal rE;

    @Column(name = "re_amount")
    private BigDecimal rE_amount;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_invoice", referencedColumnName = "id")
    @Column(name = "sales")
    private List<Sale> sales = new ArrayList<>();


    @Column(name = "create_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createAt;


    @PrePersist
    public void prePersist() {
        createAt = LocalDate.now();
    }


}
