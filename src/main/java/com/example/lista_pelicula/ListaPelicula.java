package com.example.lista_pelicula;

public class ListaPelicula {
    
    private int id;
    private String titulo;
    private int anio;
    private String director;
    private String genero;
    private String sinopsis;


    public ListaPelicula(int id,String titulo,int anio,String director,String genero,String sinopsis)
    {
        this.id=id;
        this.titulo=titulo;
        this.anio=anio;
        this.director=director;
        this.genero=genero;
        this.sinopsis=sinopsis;

    }

    public int getId() {
        return this.id;
    }

    
    public String getTitulo() {
        return this.titulo;
    }

    

    public int getAnio() {
        return this.anio;
    }

    

    public String getDirector() {
        return this.director;
    }

    

    public String getGenero() {
        return this.genero;
    }

    
    public String getSinopsis() {
        return this.sinopsis;
    }

}

    

    
