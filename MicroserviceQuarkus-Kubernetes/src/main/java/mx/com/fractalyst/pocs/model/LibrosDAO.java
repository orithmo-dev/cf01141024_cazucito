package mx.com.fractalyst.pocs.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class LibrosDAO {

    // NOT PRODUCTION CODE
    private static final LibrosDAO librosDAO = new LibrosDAO();
    private static List<Libro> librosDB;

    static {
            List<Libro> librosDB = new ArrayList<>();
            librosDB.add(new Libro(1, "John Carnell", "Spring Microservices in Action"));
            librosDB.add(new Libro(2, "Chris Richardson", "Microservices Patterns: With examples in Java"));
            librosDB.add(new Libro(3, "Magnus Larsson", "Building Microservices with Spring Boot and Spring Cloud"));
            librosDB.add(new Libro(4, "Martin Kleppmann", "Designing Data-Intensive Applications"));
            librosDB.add(new Libro(5, "Sourabh Sharma", "Mastering Microservices with Java 11"));
            LibrosDAO.librosDB = librosDB;
   
    }

    public static LibrosDAO getSingleton(){
        return librosDAO;
    }

    private LibrosDAO() {
    }

    //C
    public Libro creaLibro(final int id, final String autor, final String titulo) {
        Libro l = new Libro(id, autor, titulo);
        librosDB.add(l);
        return l;
    }
    //C
    public Libro creaLibro(Libro libro) {
        librosDB.add(libro);
        return libro;
    }
    //R
    public Libro obtenLibro(final int id) {
        return librosDB.stream().filter(l -> l.getId() == id).findFirst().get();
    }

    public List<Libro> obtenLibros() {
        return librosDB;
    }

    //U
    public Libro actualizaLibro(final int id, final String autor, final String titulo) {
        Libro ldatosNuevos = new Libro(id, autor, titulo);
        boolean libroFueEliminado = librosDB.removeIf(l -> l.getId() == id);
        librosDB.add(ldatosNuevos);
        return ldatosNuevos;
    }
    public Libro actualizaLibro(final Libro libro) {
        boolean libroFueEliminado = librosDB.removeIf(l -> l.getId() == libro.getId());
        librosDB.add(libro);
        return libro;
    }
    //D
    public boolean eliminaLibro(final int id) {
        boolean libroFueEliminado = librosDB.removeIf(l -> l.getId() == id);
        return libroFueEliminado;
    }
}
