package com.campusbike.campusbike.modelo.application.service;

import java.util.List;
import java.util.Optional;

import com.campusbike.campusbike.modelo.domain.entity.Modelo;

public interface IModeloService {
    Modelo save(Modelo modelo);

    String deleteById(Long id);

    List<Modelo> findAll();

    Optional<Modelo> findByNombre(String nombre);

    Optional<Modelo> findById(Long id);

    Optional<Modelo> updateById(Long id, Modelo modelo);
}
