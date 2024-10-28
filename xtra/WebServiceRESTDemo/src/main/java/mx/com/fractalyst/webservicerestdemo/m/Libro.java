package mx.com.fractalyst.webservicerestdemo.m;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fractalyst
 */
@XmlRootElement
public class Libro implements Serializable {

    private int id;
    private String autor;
    private String titulo;

    public Libro() {
    }

    public Libro(int id, String autor, String titulo) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;
        if (obj instanceof Libro) {
            if (((Libro) obj).getId() == this.getId()) {
                eq = true;
            }
        }
        return eq;
    }

}
