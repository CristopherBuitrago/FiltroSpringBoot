package com.campusbike.campusbike.bicicleta.domain.entity;

import com.campusbike.campusbike.marca.domain.entity.Marca;
import com.campusbike.campusbike.modelo.domain.entity.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Bicicleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(targetEntity = Modelo.class)
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

    @ManyToOne(targetEntity = Marca.class)
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @Column
    @NotNull(message = "El campo no puede ser nulo!")
    private double precio;

    @Column
    @NotNull(message = "El campo no puede ser nulo!")
    private int stock;
}
