package com.example.lista_pelicula.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.lista_pelicula.model.Peliculas;
import com.example.lista_pelicula.service.PeliculasServices;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController

@RequestMapping("/Peliculas")
public class PeliculasController {
@Autowired
private PeliculasServices peliculasServices;

@GetMapping
public List<Peliculas> getAllPeliculas() {
    return peliculasServices.getAllPeliculas();
}

@GetMapping("/{id_peliculas}")
public Optional<Peliculas>  getPeliculasById(@PathVariable Long id_peliculas) {
    return peliculasServices.getPeliculasById(id_peliculas);
}


@PostMapping
public Peliculas createPelicula(@RequestBody Peliculas peliculas){
    return peliculasServices.createPelicula(peliculas);
}

@PutMapping("/{id}")
public Peliculas modificarPelicula(@PathVariable Long id, @RequestBody Peliculas peliculas) {
    
    
    return peliculasServices.modificarPelicula(id, peliculas);
}


@DeleteMapping("/{id}")
public void eliminarPelicula(@PathVariable Long id){
    try {
        peliculasServices.eliminarPelicula(id);
        new ResponseEntity<>("Pelicula Eliminada Correctamente",HttpStatus.OK);     
    } catch (Exception e) {
        new ResponseEntity<>("Error al eliminar la pelicula id:"+id,HttpStatus.CONFLICT);  
    }     
}



}
