package com.campusbike.campusbike.modelo.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campusbike.campusbike.modelo.domain.entity.Modelo;

@Repository
public interface ModeloRepositorio extends JpaRepository<Modelo, Long> {
    Optional<Modelo> findByNombre(String nombre);
}
