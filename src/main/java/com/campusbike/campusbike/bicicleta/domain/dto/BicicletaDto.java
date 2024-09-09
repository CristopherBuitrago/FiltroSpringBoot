package com.campusbike.campusbike.bicicleta.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BicicletaDto {
    private Long id;
    private int modeloId;
    private int marcaId;
    private double precio;
    private int stock;
}
