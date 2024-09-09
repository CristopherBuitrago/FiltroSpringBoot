package com.campusbike.campusbike.bicicleta.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.campusbike.campusbike.bicicleta.domain.entity.Bicicleta;

@Repository
public interface BicicletaRepositorio extends JpaRepository<Bicicleta, Long>{
    @Query("SELECT b FROM Bicicleta b WHERE b.marca.nombre =:nombreMarca")
    List<Bicicleta> findByMarca(@Param(value = "nombreMarca") String nombre);

    @Query("SELECT b FROM Bicicleta b WHERE b.modelo.nombre =:nombreModelo")
    List<Bicicleta> findByModelo(@Param(value = "nombreModelo") String nombre);

    @Query("SELECT b FROM Bicicleta b WHERE b.marca.nombre =:nombreMarca AND b.modelo.nombre =:nombreModelo")
    List<Bicicleta> findByModeloAndMarca(@Param(value = "nombreModelo") String nombreModelo, @Param(value = "nombreMarca") String nombreMarca);
}
