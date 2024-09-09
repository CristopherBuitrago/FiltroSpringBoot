package com.campusbike.campusbike.modelo.infrastructure.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusbike.campusbike.modelo.application.service.IModeloService;
import com.campusbike.campusbike.modelo.domain.entity.Modelo;
import com.campusbike.campusbike.validation.campo.FieldEmptyException;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/modelos")
public class ModeloControlador {

    @Autowired
    private IModeloService modeloService;

    // guardar modelo
    @PostMapping("/crear") 
    public ResponseEntity<?> guardarModelo(@Valid @RequestBody Modelo modelo, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(FieldEmptyException.getError(result));
        } else {
            Modelo modeloGuardado = modeloService.save(modelo);
            return ResponseEntity.ok(modeloGuardado);
        }
    }

    // encontrarlos todos
    @GetMapping("/all")
    public ResponseEntity<?> ObtenerModelos() {
        List<Modelo> modelos = modeloService.findAll();

        if (modelos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron modelos.");
        } else {
            return ResponseEntity.ok(modelos);
        }
    }
    
}
