package com.campusbike.campusbike.pais.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campusbike.campusbike.pais.domain.entity.Pais;

@Repository
public interface PaisRepositorio extends JpaRepository<Pais, Long>{
    Optional<Pais> findByNombre(String nombre);
}
