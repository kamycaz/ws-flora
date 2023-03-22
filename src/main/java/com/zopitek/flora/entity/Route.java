package com.zopitek.flora.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.zopitek.flora.controller.shared.ClientController;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "t_route")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_sale", referencedColumnName = "id")
    @Column(name = "lines")
    private List<SaleLine> lines = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "t_route_client",
            joinColumns = @JoinColumn(name = "id_route", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"))
    private Set<Client> clients = new HashSet<Client>();

    @Column(name = "create_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createAt;


    @PrePersist
    public void prePersist() {
        createAt = LocalDate.now();
    }


}