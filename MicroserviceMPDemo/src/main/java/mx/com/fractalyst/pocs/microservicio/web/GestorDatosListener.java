package mx.com.fractalyst.pocs.microservicio.web;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import mx.com.fractalyst.pocs.microservicio.model.Libro;
import mx.com.fractalyst.pocs.microservicio.model.LibroDAO;

/**
 * Web application lifecycle listener.
 *
 * @author
 */
@WebListener
public class GestorDatosListener implements ServletContextListener {

    private List<Libro> librosDB;
    
    // NOT PRODUCTION CODE
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        librosDB = new ArrayList<>();
        librosDB.add(new Libro(1, "John Carnell", "Spring Microservices in Action"));
        librosDB.add(new Libro(2, "Chris Richardson", "Microservices Patterns: With examples in Java"));
        librosDB.add(new Libro(3, "Magnus Larsson", "Building Microservices with Spring Boot and Spring Cloud"));
        librosDB.add(new Libro(4, "Martin Kleppmann", "Designing Data-Intensive Applications"));
        librosDB.add(new Libro(5, "Sourabh Sharma", "Mastering Microservices with Java 11"));
        LibroDAO dao = new LibroDAO(librosDB);
        sce.getServletContext().setAttribute("libroDAO", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
    
    
    
}
