package mx.com.fractalyst.pocs;

import java.util.List;

import mx.com.fractalyst.pocs.model.Libro;
import mx.com.fractalyst.pocs.model.LibrosDAO;
import mx.com.fractalyst.pocs.model.RespuestaWeb;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

/**
 * 
 *
 * @author
 */

@Path("/api/libros")
public class LibrosREST {

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
        LibrosDAO dao = (LibrosDAO) LibrosDAO.getSingleton();
        return dao.creaLibro(libro);
    }

    // R
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Libro obtenLibro(@PathParam("id") final int id) {
        LibrosDAO dao = (LibrosDAO) LibrosDAO.getSingleton();
        return dao.obtenLibro(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Libro> obtenLibros() {
        LibrosDAO dao = (LibrosDAO) LibrosDAO.getSingleton();
        return dao.obtenLibros();
    }

    // U
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Libro actualizaLibro(final Libro libro) {
        LibrosDAO dao = (LibrosDAO) LibrosDAO.getSingleton();
        return dao.actualizaLibro(libro);
    }
    
    // D
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWeb eliminaLibro(@PathParam("id") final int id) {
        LibrosDAO dao = (LibrosDAO) LibrosDAO.getSingleton();
        RespuestaWeb respuestaWeb = new RespuestaWeb(500, "Problema en la eliminación");
        boolean borradoExitoso = dao.eliminaLibro(id);
        if(borradoExitoso) {
            respuestaWeb = new RespuestaWeb(200, "Eliminaciòn Exitosa");
        }
        return respuestaWeb;
    }
}
