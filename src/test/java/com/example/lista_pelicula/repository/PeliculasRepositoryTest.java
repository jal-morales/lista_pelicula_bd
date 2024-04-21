package com.example.lista_pelicula.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.lista_pelicula.model.Pelicula;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculasRepositoryTest {
    @Autowired
    private PeliculasRepository peliculasRepository;

    /*Realizaremos una prueva de almacenar pelicula */ 
    @Test
    public void createPelicula() {
       /*Aca creamos un objeto pelicula  */ 
        Pelicula peliculas = new Pelicula();
        /*Aca seteamos el nombre de la pelicula  */
        peliculas.setNombre("TITANIC");
        peliculas.setAnio("2024");
        peliculas.setDirector("Javier Lopez");
        peliculas.setGenero("Familiar");
        peliculas.setSinopsis("es una película épica de romance");

        /*Aca hacemos una variable de tipo Pelicula donde donde almacenaremos la pelicula creada llamada TITANIC */
        Pelicula resultado = peliculasRepository.save(peliculas);

        /*Aca estamos usando una clase de Junit donde estamos validando que el ID de la pelicula no sea nulo */
        assertNotNull(resultado.getId_pelicula());
        /*Aca estamos pasando el valor que esperamos, usamos el get de la variable resultado para obtener el dato del objeto */
        assertEquals("TITANIC", resultado.getNombre());
    }

    

}
