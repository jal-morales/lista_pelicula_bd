package com.example.lista_pelicula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.lista_pelicula.model.Pelicula;
import com.example.lista_pelicula.service.PeliculasServices;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




@RestController

@RequestMapping("/Peliculas")
public class PeliculasController {

    private static final Logger log = LoggerFactory.getLogger(PeliculasController.class);
@Autowired
private PeliculasServices peliculasServices;

@GetMapping
/* 
public List<Peliculas> getAllPeliculas() {
    return peliculasServices.getAllPeliculas();
}*/

/*profe no se qpor que me da error el el este metodo me podria ayudar */
public CollectionModel<EntityModel<Pelicula>> getAllPeliculas() {
    List<Pelicula> peliculas = peliculasServices.getAllPeliculas();
    log.info("GET /Peliculas");
    log.info("Retornando todos las peliculas");

    List<EntityModel<Pelicula>> peliculasResources = peliculas.stream()
            .map(pelicula -> EntityModel.of(pelicula, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass())
                    .getPeliculasById(pelicula.getId_pelicula())).withSelfRel()))
            .collect(Collectors.toList());

    WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPeliculas());
    CollectionModel<EntityModel<Pelicula>> resources = CollectionModel.of(peliculasResources, linkTo.withRel("peliculas"));

    return resources;
}
/*List<EntityModel<Peliculas>> peliculasResources = peliculas.stream()
    .map(peliculas -> EntityModel.of(peliculas,WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).
    getPeliculasById(peliculas.getId_pelicula())).withSelfRel()
    )).collect(Collectors.toList());*/

@GetMapping("/{id_peliculas}")
public Optional<Pelicula>  getPeliculasById(@PathVariable Long id_peliculas) {
    return peliculasServices.getPeliculasById(id_peliculas);
}



@PostMapping
public Pelicula createPelicula(@RequestBody Pelicula peliculas){
    return peliculasServices.createPelicula(peliculas);
}

@PutMapping("/{id}")
public Pelicula modificarPelicula(@PathVariable Long id, @RequestBody Pelicula peliculas) {
    
    
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
