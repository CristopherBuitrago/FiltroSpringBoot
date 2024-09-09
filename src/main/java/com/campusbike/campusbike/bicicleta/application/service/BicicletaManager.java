package com.campusbike.campusbike.bicicleta.application.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.campusbike.campusbike.bicicleta.domain.dto.BicicletaDto;
import com.campusbike.campusbike.bicicleta.domain.entity.Bicicleta;
import com.campusbike.campusbike.marca.application.service.IMarcaService;
import com.campusbike.campusbike.marca.domain.entity.Marca;

public class BicicletaManager {

    @Autowired
    private IMarcaService marcaService;

    public static Bicicleta toEntity(BicicletaDto dto) {
        Bicicleta bicicleta = new Bicicleta();
        Marca marca = new Marca(); 
    }
}
