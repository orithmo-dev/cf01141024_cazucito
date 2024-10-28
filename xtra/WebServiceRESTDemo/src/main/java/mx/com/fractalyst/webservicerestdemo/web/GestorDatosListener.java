package mx.com.fractalyst.webservicerestdemo.web;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import mx.com.fractalyst.webservicerestdemo.m.Libro;
import mx.com.fractalyst.webservicerestdemo.m.datos.LibroDAO;

/**
 * Web application lifecycle listener.
 *
 * @author fractalyst
 */
public class GestorDatosListener implements ServletContextListener {

    private List<Libro> librosDB;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        librosDB = new ArrayList<>();
        librosDB.add(new Libro(1, "Autor1", "Título1"));
        librosDB.add(new Libro(2, "Autor2", "Título2"));
        librosDB.add(new Libro(3, "Autor3", "Título3"));
        librosDB.add(new Libro(4, "Autor4", "Título4"));
        librosDB.add(new Libro(5, "Autor5", "Título5"));
        LibroDAO dao = new LibroDAO(librosDB);
        sce.getServletContext().setAttribute("libroDAO", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
