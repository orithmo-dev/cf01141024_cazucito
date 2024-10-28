package mx.com.fractalyst.webservicesoapdemo.m;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import mx.com.fractalyst.webservicesoapdemo.m.datos.GestorDatosEJB;

/**
 *
 * @author fractalyst
 */
@WebService(serviceName = "LibroWS")
@Stateless()
public class LibroWS {

    @EJB
    private GestorDatosEJB gestorDatosEJB;

    //C
    @WebMethod(operationName = "creaLibro")
    public Libro creaLibro(final int id, final String autor, final String titulo) {
        Libro l = gestorDatosEJB.creaLibro(id, autor, titulo);
        return l;
    }

    // R
    @WebMethod(operationName = "obtenLibro")
    public Libro obtenLibro(@WebParam(name = "id") int id) {
        return gestorDatosEJB.getLibro(id);
    }

    @WebMethod(operationName = "obtenLibros")
    public List<Libro> obtenLibros() {
        return gestorDatosEJB.getLibros();
    }

    //U
    @WebMethod(operationName = "actualizaLibro")
    public Libro actualizaLibro(final int id, final String autor, final String titulo) {
        return gestorDatosEJB.actualizaLibro(id, autor, titulo);
    }

    //D
    @WebMethod(operationName = "eliminaLibro")
    public boolean eliminaLibro(final int id) {
        return gestorDatosEJB.eliminaLibro(id);
    }
}
