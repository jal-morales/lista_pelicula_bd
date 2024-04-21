package com.example.lista_pelicula.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lista_pelicula.model.Pelicula;
import com.example.lista_pelicula.repository.PeliculasRepository;




@Service
public class PeliculasServicesImpl implements PeliculasServices{
    @Autowired
    private  PeliculasRepository peliculasRepository;

    @Override
    public List<Pelicula> getAllPeliculas(){
        return peliculasRepository.findAll();
    }

   @Override
   public Optional<Pelicula> getPeliculasById(Long id_peliculas){

    return peliculasRepository.findById(id_peliculas);
   }

@Override
public Pelicula createPelicula(Pelicula peliculas)
{

    return peliculasRepository.save(peliculas);
}
@Override
public Pelicula  modificarPelicula(Long id, Pelicula pelicula){
    if(peliculasRepository.existsById(id)){
        pelicula.setId_pelicula(id);
        return peliculasRepository.save(pelicula);
    }
    else{
        return null;
    }
    
}

@Override
public void eliminarPelicula(Long id){
 peliculasRepository.deleteById(id);
 
}

}



