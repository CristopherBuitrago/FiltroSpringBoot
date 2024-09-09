package com.campusbike.campusbike.marca.application.service;

import java.util.List;
import java.util.Optional;

import com.campusbike.campusbike.marca.domain.entity.Marca;

public interface IMarcaService {
    Marca save(Marca marca);

    String deleteById(Long id);

    List<Marca> findAll();

    Optional<Marca> findByNombre(String nombre);

    Optional<Marca> findById(Long id);

    Optional<Marca> updateById(Long id, Marca marca);
}
