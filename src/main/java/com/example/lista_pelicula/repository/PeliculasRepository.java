package com.example.lista_pelicula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lista_pelicula.model.Peliculas;


public interface PeliculasRepository extends JpaRepository<Peliculas, Long>{
    
}
