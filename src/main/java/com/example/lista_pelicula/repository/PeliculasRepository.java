package com.example.lista_pelicula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lista_pelicula.model.Pelicula;


public interface PeliculasRepository extends JpaRepository<Pelicula, Long>{
    
}
