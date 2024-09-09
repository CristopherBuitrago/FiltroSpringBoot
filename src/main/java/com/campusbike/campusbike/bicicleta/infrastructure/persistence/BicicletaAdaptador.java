package com.campusbike.campusbike.bicicleta.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusbike.campusbike.bicicleta.application.service.IBicicletaServicio;
import com.campusbike.campusbike.bicicleta.domain.entity.Bicicleta;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class BicicletaAdaptador implements IBicicletaServicio{
    @Autowired
    private BicicletaRepositorio bicicletaRepositorio;

    @Override
    @Transactional
    @Valid
    public Bicicleta save(Bicicleta bicicleta) {
        Bicicleta bicicletaGuardada = bicicletaRepositorio.save(bicicleta);
        return bicicletaGuardada;
    }

    @Override
    public Optional<Bicicleta> findById(Long id) {
        Optional<Bicicleta> bicicletaEncontrada = bicicletaRepositorio.findById(id);

        if (!bicicletaEncontrada.isPresent()) {
            return Optional.empty();
        } else {
            return bicicletaEncontrada;
        }
    }

    @Override
    public List<Bicicleta> findByMarca(String nombre) {
        List<Bicicleta> bicicletasEncontradas = bicicletaRepositorio.findByMarca(nombre);

        return bicicletasEncontradas;
     
    }

    @Override
    public List<Bicicleta> findByModelo(String nombre) {
        List<Bicicleta> bicicletasEncontradas = bicicletaRepositorio.findByModelo(nombre);

        return bicicletasEncontradas;
    }

    @Override
    public List<Bicicleta> findByModeloAndMarca(String modeloNombre, String marcaNombre) {
        List<Bicicleta> bicicletasEncontradas = bicicletaRepositorio.findByModeloAndMarca(modeloNombre, marcaNombre);

        return bicicletasEncontradas;
    }

    @Override
    public List<Bicicleta> findAll() {
        return bicicletaRepositorio.findAll();
    }

    @Override
    public String deleteById(Long id) {
        Optional<Bicicleta> bicicletaEncontrada = bicicletaRepositorio.findById(id);

        if (!bicicletaEncontrada.isPresent()) {
            return "Bicicleta no encontrada con id: "+id;
        } else {
            bicicletaRepositorio.deleteById(id);
            return "Bicicleta eliminada exitosamente!";
        }
    }

    @Override
    @Transactional
    @Valid
    public Optional<Bicicleta> updateById(Long id, BicicletaDto bicicleta) {
        Optional<Bicicleta> bicicletaEncontrada = bicicletaRepositorio.findById(id);

        if (!bicicletaEncontrada.isPresent()) {
            return Optional.empty();
        } else {
            Bicicleta bicicletaActualizada = bicicletaEncontrada.get();

            bicicletaActualizada.setMarca();
        }
    }
}
