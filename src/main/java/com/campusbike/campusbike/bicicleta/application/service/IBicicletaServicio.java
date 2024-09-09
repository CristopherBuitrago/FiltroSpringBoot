package com.campusbike.campusbike.bicicleta.application.service;

import java.util.List;
import java.util.Optional;

import com.campusbike.campusbike.bicicleta.domain.entity.Bicicleta;

public interface IBicicletaServicio {
    Bicicleta save(Bicicleta bicicleta);

    Optional<Bicicleta> findById(Long id);
    List<Bicicleta> findByMarca(String nombre);
    List<Bicicleta> findByModelo(String nombre);
    List<Bicicleta> findByModeloAndMarca(String modeloNombre, String marcaNombre);
    List<Bicicleta> findAll();

    String deleteById(Long id);

    Optional<Bicicleta> updateById(Long id, Bicicleta bicicleta);
}
