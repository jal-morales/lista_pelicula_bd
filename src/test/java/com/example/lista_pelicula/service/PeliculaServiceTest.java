package com.example.lista_pelicula.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.lista_pelicula.model.Pelicula;
import com.example.lista_pelicula.repository.PeliculasRepository;

@ExtendWith(MockitoExtension.class)
public class PeliculaServiceTest {

    

    @InjectMocks
    private PeliculasServicesImpl peliculasServiceImpl;

    @Mock
    private PeliculasRepository peliculasRepositoryMock;

    @Test
    public void guardarPeliculaTest() {

        Pelicula pelicula = new Pelicula();
        pelicula.setNombre("mipelicula");

        when(peliculasRepositoryMock.save(any())).thenReturn(pelicula);

        Pelicula resultado = peliculasServiceImpl.createPelicula(pelicula);

        assertEquals("mipelicula", resultado.getNombre());
    }
}
