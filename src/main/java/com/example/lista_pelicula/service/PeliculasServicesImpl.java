package com.example.lista_pelicula.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lista_pelicula.model.Peliculas;
import com.example.lista_pelicula.repository.PeliculasRepository;




@Service
public class PeliculasServicesImpl implements PeliculasServices{
    @Autowired
    private  PeliculasRepository peliculasRepository;

    @Override
    public List<Peliculas> getAllPeliculas(){
        return peliculasRepository.findAll();
    }

   @Override
   public Optional<Peliculas> getPeliculasById(Long id_peliculas){

    return peliculasRepository.findById(id_peliculas);
   }

@Override
public Peliculas createPelicula(Peliculas peliculas)
{

    return peliculasRepository.save(peliculas);
}
@Override
public Peliculas  modificarPelicula(Long id, Peliculas pelicula){
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



