package com.example.lista_pelicula.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PeliculasNotFoundException extends RuntimeException{

    public PeliculasNotFoundException(String mensaje)
    {
        super(mensaje);
    }
}
