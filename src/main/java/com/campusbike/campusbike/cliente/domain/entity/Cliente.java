package com.campusbike.campusbike.cliente.domain.entity;

import com.campusbike.campusbike.ciudad.domain.entity.Ciudad;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "El campo no puede estar vacío!")
    private String nombre;

    @Column
    @Email
    @NotBlank(message = "El campo no puede estar vacío!")
    private String email;

    @Column
    @NotBlank(message = "El campo no puede estar vacío!")
    private String telefono;

    @Column
    @NotBlank(message = "El campo no puede estar vacío!")
    private String contrasenia;

    @ManyToOne(targetEntity = Ciudad.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;
}
