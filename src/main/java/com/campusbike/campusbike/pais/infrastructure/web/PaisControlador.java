package com.campusbike.campusbike.pais.infrastructure.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusbike.campusbike.pais.application.service.IPaisServicio;
import com.campusbike.campusbike.pais.domain.entity.Pais;
import com.campusbike.campusbike.validation.campo.FieldEmptyException;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/paises")
public class PaisControlador {

    @Autowired
    private IPaisServicio paisServicio;

    // save
    @PostMapping("/create")
    public ResponseEntity<?> crearPais(@Valid @RequestBody Pais pais, BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(FieldEmptyException.getError(result));
        } else {
            Pais paisGuardado = paisServicio.save(pais);
            return ResponseEntity.ok(paisGuardado);
        }
    
    }

    // get all
    @GetMapping("/all")
    public ResponseEntity<List<Pais>> findAll(@RequestParam String param) {
        List<Pais> paises =  paisServicio.findAll();
        return ResponseEntity.ok(paises);
    }
    
    
}
