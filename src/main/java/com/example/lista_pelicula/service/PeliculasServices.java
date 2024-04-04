package com.example.lista_pelicula.service;

import java.util.List;
import java.util.Optional;

import com.example.lista_pelicula.model.Peliculas;

public interface PeliculasServices {
    List<Peliculas> getAllPeliculas();
    Optional <Peliculas> getPeliculasById(Long id_peliculas);

/*CREAR*/

Peliculas createPelicula(Peliculas peliculas);
Peliculas  modificarPelicula(Long id, Peliculas pelicula);
 void eliminarPelicula(Long id);



}





