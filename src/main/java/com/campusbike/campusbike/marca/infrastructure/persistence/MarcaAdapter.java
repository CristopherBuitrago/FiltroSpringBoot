package com.campusbike.campusbike.marca.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusbike.campusbike.marca.application.service.IMarcaService;
import com.campusbike.campusbike.marca.domain.entity.Marca;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class MarcaAdapter implements IMarcaService{
    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    @Valid
    @Transactional
    public Marca save(Marca marca) {
        Marca marcaGuardado = marcaRepository.save(marca);
        return marcaGuardado;
    }

    @Override
    public String deleteById(Long id) {
        Optional<Marca> marcaEncontrada = marcaRepository.findById(id);

        if (!marcaEncontrada.isPresent()) {
            return "Marca no encontrada con id: "+id;
        } else {
            marcaRepository.deleteById(id);
            return "Marca eliminada exitosamente!";
        }
    }

    @Override
    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    @Override
    public Optional<Marca> findByNombre(String nombre) {
        Optional<Marca> marcaEncontrada = marcaRepository.findByNombre(nombre);
        
        if (!marcaEncontrada.isPresent()) {
            return Optional.empty();
        } else {
            return marcaEncontrada;
        }
    }

    @Override
    public Optional<Marca> findById(Long id) {
        Optional<Marca> marcaEncontrada = marcaRepository.findById(id);
        
        if (!marcaEncontrada.isPresent()) {
            return Optional.empty();
        } else {
            return marcaEncontrada;
        }
    }

    @Override
    @Transactional
    @Valid
    public Optional<Marca> updateById(Long id, Marca marca) {
        
        Optional<Marca> marcaOriginal = marcaRepository.findById(id);

        if (!marcaOriginal.isPresent()) {
            return Optional.empty();
        } else {
            Marca marcaActualizada = marcaOriginal.get();

            marcaActualizada.setNombre(marca.getNombre());

            return Optional.of(marcaRepository.save(marcaActualizada));
        }
    }


}
