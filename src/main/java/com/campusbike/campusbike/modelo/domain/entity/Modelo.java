package com.campusbike.campusbike.modelo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "El cmapo no puede estar vacío!")
    private String nombre;

    @Column(columnDefinition = "text")
    @NotBlank(message = "El campo no puede estar vacío!")
    private String descripcion;
}
