package mx.com.fractalyst.webservicerestdemo.web;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fractalyst
 */
@XmlRootElement
public class RespuestaWeb {
    private int codigo;
    private String mensaje;

    public RespuestaWeb() {
    }

    public RespuestaWeb(int codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
