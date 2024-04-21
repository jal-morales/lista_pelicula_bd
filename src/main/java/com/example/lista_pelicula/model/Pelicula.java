package com.example.lista_pelicula.model;
import org.springframework.hateoas.RepresentationModel;

/*Librerias necesarias para interactuar con BD*/
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "peliculas")
public class Pelicula extends RepresentationModel<Pelicula>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Long id_pelicula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name="anio")
    private String anio;

    @Column(name = "direcctor")
    private String director;

    @Column(name = "genero")
    private String genero;

    @Column(name = "sinopsis")
    private String sinopsis;

    /*GET*/
    public Long getId_pelicula(){
        return id_pelicula;
    }

    public String getNombre(){
        return nombre;
    }

    public String getAnio(){
        return anio;
    }

    public String getDirector(){
        return director;
    }

    public String getGenero(){
        return genero;
    }

    public String getSinopsis(){
        return sinopsis;
    }
    /*SET*/
    public void setId_pelicula(Long id_pelicula){
        this.id_pelicula=id_pelicula;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setAnio(String anio){
        this.anio=anio;
    }

    public void setDirector(String director ){
        this.director=director;
    }
    
    public void setGenero(String genero){
        this.genero=genero;
    }

    public void setSinopsis(String sinopsis){
        this.sinopsis=sinopsis;
    }


}
