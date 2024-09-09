package com.campusbike.campusbike.modelo.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusbike.campusbike.modelo.application.service.IModeloService;
import com.campusbike.campusbike.modelo.domain.entity.Modelo;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class ModeloAdaptador implements IModeloService{
    @Autowired
    private ModeloRepositorio modeloRepositorio;

    @Override
    @Valid
    @Transactional
    public Modelo save(Modelo modelo) {
        Modelo modeloGuardado = modeloRepositorio.save(modelo);
        return modeloGuardado;
    }

    @Override
    public String deleteById(Long id) {
        Optional<Modelo> modeloEliminado = modeloRepositorio.findById(id);
        
        if(!modeloEliminado.isPresent()) {
            return "Modelo no encontrado con id: "+id;
        } else {
            modeloRepositorio.deleteById(id);
            return "Modelo eliminado exitosamente.";
        }
    }

    @Override
    public Optional<Modelo> findByNombre(String nombre) {
        Optional<Modelo> modeloEncontrado = modeloRepositorio.findByNombre(nombre);
        
        if (!modeloEncontrado.isPresent()) {
            return Optional.empty();
        } else {
            return modeloEncontrado;
        }
    }

    @Override
    public Optional<Modelo> findById(Long id) {
        Optional<Modelo> modeloEncontrado = modeloRepositorio.findById(id);
        
        if (!modeloEncontrado.isPresent()) {
            return Optional.empty();
        } else {
            return modeloEncontrado;
        }
    }

    @Override
    @Valid
    @Transactional
    public Optional<Modelo> updateById(Long id, Modelo modelo) {
        Optional<Modelo> modeloOriginal = modeloRepositorio.findById(id);

        if (!modeloOriginal.isPresent()) {
            return Optional.empty();
        } else {
            Modelo modeloActualizado = modeloOriginal.get();

            modeloActualizado.setNombre(modelo.getNombre());
            modeloActualizado.setDescripcion(modelo.getDescripcion());

            return Optional.of(modeloRepositorio.save(modeloActualizado));
        }
    }

    @Override
    public List<Modelo> findAll() {
        return modeloRepositorio.findAll();
    }


}
