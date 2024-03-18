package com.example.lista_pelicula;

 import java.util.ArrayList;
import java.util.List;//con esta libreria podemos hacer uso de la coleccion de List 

//esta libreria ya la importamos anteriormente pero es para dejar visible que utilizaremos

//Se llama a esta libreria RestController  a traves de anotacion la cual nos servira para poder trabajar con api REST
/*Controlador de tipo REST */
 import org.springframework.web.bind.annotation.*;//se requiere importa esta libreria 

 @RestController 
public class ListaPeliculaController {
   //Creare una lista para almacenar peliculas
   
   private List <ListaPelicula> peliculas= new ArrayList<>();

   //crearemos el controlador donde agregaremos a cada una de las pelicula en nuestra lista "Almacenada en Memoria".@GetMapping("path")
   public ListaPeliculaController()
   {
        //Inicializar la lista con dato
        peliculas.add(new ListaPelicula(1,"El Laberinto del Fauno", 2006, "Guillermo del Toro", "Fantasía/Drama", " En la España de posguerra, una niña llamada Ofelia descubre un laberinto mágico en el que se encuentra con seres fantásticos que le revelan su verdadera identidad y le encomiendan tres tareas que debe cumplir para recuperar su lugar como princesa del reino subterráneo."));
        peliculas.add(new ListaPelicula(2, "La La Land", 2016, "Damien Chazelle", "Musical/Romance", "En Los Ángeles, un pianista de jazz y una aspirante a actriz se enamoran mientras luchan por alcanzar sus sueños en la competitiva industria del entretenimiento, enfrentando desafíos que ponen a prueba su amor y sus ambiciones."));
        peliculas.add(new ListaPelicula(3, "Origen", 2010, "Christopher Nolan", "Ciencia ficción/Thriller", "Un ladrón de ideas con habilidades para entrar en los sueños de las personas es contratado para implantar una idea en la mente de un empresario. A medida que profundiza en los intrincados laberintos de la mente humana, se enfrenta a peligrosos enemigos y descubre la verdad sobre su propia realidad."));
        peliculas.add(new ListaPelicula(4, "El Padrino", 1972, "Francis Ford Coppola", " Drama/Crimen", "Esta épica película sigue la historia de la familia Corleone, una poderosa dinastía de la mafia italiana en Estados Unidos. En medio de luchas de poder, traiciones y lealtades familiares, el patriarca Don Vito Corleone intenta mantener el control mientras su hijo Michael se ve arrastrado más profundamente al mundo del crimen organizado."));
        peliculas.add(new ListaPelicula(5, "El Resplandor", 1980, "Stanley Kubrick", "Terror/Suspenso", "Un escritor acepta un trabajo como cuidador de un hotel aislado durante el invierno con la esperanza de encontrar la tranquilidad necesaria para escribir. Sin embargo, la soledad y los oscuros secretos del lugar desencadenan una espiral de locura y violencia que pone en peligro a su familia."));

   }
   
   //crearemos el metodo que sera encargado de mostrar la lista completa de peliculas

   @GetMapping("/listadoPeliculas")//Nombre de la ruta de nuestro endpoint a consumir en REST
   //@RequestMapping(path="/listadoPeliculas",produces="application/json")
        public List<ListaPelicula> getListadoPeliculas() {
            
            return peliculas;
        }

        //crearemos el metodo que sera encargado de mostrar peliculas especificas filtradas por ID.
    @GetMapping("/listadoPeliculas/{id}")
        public ListaPelicula getListadoPeliculastById(@PathVariable int id) {
            
            for(ListaPelicula pelicula: peliculas)
            {
                if (pelicula.getId()==id) {
                    return pelicula;
                }

            }
            return null;
        }
             
}
