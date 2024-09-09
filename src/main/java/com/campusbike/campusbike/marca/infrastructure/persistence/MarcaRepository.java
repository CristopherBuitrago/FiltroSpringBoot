package com.campusbike.campusbike.marca.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campusbike.campusbike.marca.domain.entity.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>{
    Optional<Marca> findByNombre(String name);
}
