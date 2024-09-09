package com.campusbike.campusbike.ciudad.domain.entity;

import com.campusbike.campusbike.pais.domain.entity.Pais;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "El cmapo no peude estar vacío!")
    private String nombre;

    @ManyToOne(targetEntity = Pais.class)
    @JoinColumn(name = "pais_id")
    private Pais pais;
}
