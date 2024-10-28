package mx.com.fractalyst.webservicerestdemo.m;

import java.util.List;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import mx.com.fractalyst.webservicerestdemo.m.datos.LibroDAO;
import mx.com.fractalyst.webservicerestdemo.web.RespuestaWeb;

/**
 * REST Web Service
 *
 * @author fractalyst
 */
@Path("libros")
public class LibrosREST {

    @Context
    private UriInfo context;
    @javax.ws.rs.core.Context
    ServletContext servletContext;

    /**
     * Creates a new instance of LibrosREST
     */
    public LibrosREST() {

    }

    // C
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Libro creaLibro(final Libro libro) {
        LibroDAO dao = (LibroDAO) servletContext.getAttribute("libroDAO");
        return dao.creaLibro(libro);
    }

    // R
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Libro obtenLibro(@PathParam("id") final int id) {
        LibroDAO dao = (LibroDAO) servletContext.getAttribute("libroDAO");
        return dao.obtenLibro(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Libro> obtenLibros() {
        LibroDAO dao = (LibroDAO) servletContext.getAttribute("libroDAO");
        return dao.obtenLibros();
    }

    // U
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Libro actualizaLibro(final Libro libro) {
        LibroDAO dao = (LibroDAO) servletContext.getAttribute("libroDAO");
        return dao.actualizaLibro(libro);
    }
    
    // D
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWeb eliminaLibro(@PathParam("id") final int id) {
        LibroDAO dao = (LibroDAO) servletContext.getAttribute("libroDAO");
        RespuestaWeb respuestaWeb = new RespuestaWeb(500, "Problema en la eliminación");
        boolean borradoExitoso = dao.eliminaLibro(id);
        if(borradoExitoso) {
            respuestaWeb = new RespuestaWeb(200, "Eliminaciòn Exitosa");
        }
        return respuestaWeb;
    }
}
