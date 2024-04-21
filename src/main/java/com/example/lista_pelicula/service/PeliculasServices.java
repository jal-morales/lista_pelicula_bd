package com.example.lista_pelicula.service;

import java.util.List;
import java.util.Optional;

import com.example.lista_pelicula.model.Pelicula;

public interface PeliculasServices {
    List<Pelicula> getAllPeliculas();
    Optional <Pelicula> getPeliculasById(Long id_peliculas);

/*CREAR*/

Pelicula createPelicula(Pelicula peliculas);
Pelicula  modificarPelicula(Long id, Pelicula pelicula);
 void eliminarPelicula(Long id);



}





