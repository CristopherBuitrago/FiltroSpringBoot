package com.campusbike.campusbike.pais.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusbike.campusbike.pais.application.service.IPaisServicio;
import com.campusbike.campusbike.pais.domain.entity.Pais;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class PaisAdaptador implements IPaisServicio{
    
    @Autowired
    private PaisRepositorio paisRepositorio;

    @Override
    @Valid
    @Transactional
    public Pais save(Pais pais) {
        Pais paisGuardado = paisRepositorio.save(pais);
        return paisGuardado;
    }

    @Override
    public List<Pais> findAll() {
        return paisRepositorio.findAll();
    }

    @Override
    public Optional<Pais> findById(Long id) {
        Optional<Pais> paisEncontrado = paisRepositorio.findById(id);

        if (!paisEncontrado.isPresent()) {
            return Optional.empty();
        } else {
            return paisEncontrado;
        }
    }

    @Override
    public Optional<Pais> findByNombre(String nombre) {
        Optional<Pais> paisEncontrado = paisRepositorio.findByNombre(nombre);

        if (!paisEncontrado.isPresent()) {
            return Optional.empty();
        } else {
            return paisEncontrado;
        }
    }

    @Override
    @Transactional
    @Valid
    public String deleteById(Long id) {
        Optional<Pais> paisEliminado = paisRepositorio.findById(id);
        
        if(!paisEliminado.isPresent()) {
            return "pais no encontrado con id: "+id;
        } else {
            paisRepositorio.deleteById(id);
            return "Pais eliminado exitosamente.";
        }
    }

    @Override
    public Optional<Pais> updateById(Long id, Pais pais) {
        Optional<Pais> paisOriginal = paisRepositorio.findById(id);

        if (!paisOriginal.isPresent()) {
            return Optional.empty();
        } else {
            Pais paisActualizado = paisOriginal.get();

            paisActualizado.setNombre(pais.getNombre());

            return Optional.of(paisRepositorio.save(paisActualizado));
        }
        
    }
}
