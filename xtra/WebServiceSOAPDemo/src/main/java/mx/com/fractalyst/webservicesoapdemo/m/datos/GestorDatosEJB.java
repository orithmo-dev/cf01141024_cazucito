package mx.com.fractalyst.webservicesoapdemo.m.datos;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import mx.com.fractalyst.webservicesoapdemo.m.Libro;

/**
 *
 * @author
 */
@Singleton
@Startup
public class GestorDatosEJB {

    private List<Libro> librosDB;

    public void businessMethod() {
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PostConstruct
    public void initialize() {

        librosDB = new ArrayList<>();
        librosDB.add(new Libro(1, "Autor1", "Tìtulo1"));
        librosDB.add(new Libro(2, "Autor2", "Tìtulo2"));
        librosDB.add(new Libro(3, "Autor3", "Tìtulo3"));
        librosDB.add(new Libro(4, "Autor4", "Tìtulo4"));
        librosDB.add(new Libro(5, "Autor5", "Tìtulo5"));
    }

    //C
    public Libro creaLibro(final int id, final String autor, final String titulo) {
        Libro l = new Libro(id, autor, titulo);
        librosDB.add(l);
        return l;
    }

    //R
    public Libro getLibro(final int id) {
        return librosDB.stream().filter(l -> l.getId() == id).findFirst().get();
    }

    public List<Libro> getLibros() {
        return librosDB;
    }

    //U
    public Libro actualizaLibro(final int id, final String autor, final String titulo) {
        Libro ldatosNuevos = new Libro(id, autor, titulo);
        boolean libroFueEliminado = librosDB.removeIf(l -> l.getId() == id);
        librosDB.add(ldatosNuevos);
        return ldatosNuevos;
    }
    
    //D
    public boolean eliminaLibro(final int id) {
        boolean libroFueEliminado = librosDB.removeIf(l -> l.getId() == id);
        return libroFueEliminado;
    }

}
