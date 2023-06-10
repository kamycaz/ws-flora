package com.zopitek.flora.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.zopitek.flora.entity.location.Town;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "t_client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "com_name")
    private String name;

    @Column(name = "fis_name")
    private String fiscal;

    @Column(name = "CIF")
    private String cif;

    @Column(name = "address")
    private String address;

    @Column(name = "CP")
    private String CP;

    @ManyToOne
    @JoinColumn(name="id_town")
    private Town town;

    @Column(name = "phone")
    private String phone;

    @Column(name = "create_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createAt;


    @PrePersist
    public void prePersist() {
        createAt = LocalDate.now();
    }


}