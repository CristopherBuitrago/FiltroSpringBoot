package com.campusbike.campusbike.marca.infrastructure.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusbike.campusbike.marca.application.service.IMarcaService;
import com.campusbike.campusbike.marca.domain.entity.Marca;
import com.campusbike.campusbike.validation.campo.FieldEmptyException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/marcas")
public class MarcaControlador {

    @Autowired
    private IMarcaService marcaService;

    // guardar modelo
    @PostMapping("/crear") public ResponseEntity<?> guardarMarca(@Valid @RequestBody Marca marca, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(FieldEmptyException.getError(result));
        } else {
            Marca marcaGuardado = marcaService.save(marca);
            return ResponseEntity.ok(marcaGuardado);
        }
    }

    // encontrarlos todos
    @GetMapping("/all")
    public ResponseEntity<?> ObtenerMarcas() {
        List<Marca> marcas = marcaService.findAll();

        if (marcas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron marcas.");
        } else {
            return ResponseEntity.ok(marcas);
        }
    }
}
