package com.campusbike.campusbike.pais.application.service;

import java.util.List;
import java.util.Optional;

import com.campusbike.campusbike.pais.domain.entity.Pais;

public interface IPaisServicio {
    Pais save(Pais pais);

    List<Pais> findAll();
    Optional<Pais> findById(Long id);
    Optional<Pais> findByNombre(String nombre);

    String deleteById(Long id);

    Optional<Pais> updateById(Long id, Pais pais);
}
