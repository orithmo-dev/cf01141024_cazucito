package mx.com.fractalyst.webservicerestdemo.m.datos;

import java.util.List;
import mx.com.fractalyst.webservicerestdemo.m.Libro;

/**
 *
 * @author fractalyst
 */
public class LibroDAO {

    private final List<Libro> librosDB;

    public LibroDAO(final List<Libro> libros) {
        librosDB = libros;
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
