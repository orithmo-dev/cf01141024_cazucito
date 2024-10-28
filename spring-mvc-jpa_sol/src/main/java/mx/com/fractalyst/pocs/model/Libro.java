package mx.com.fractalyst.pocs.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Clase de entidad
@Entity
// Nombre de la tabla
@Table
public class Libro {
	// Llave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int idLibro;

	@Column
	private String nombre;
	@Column
	private String autor;
	@Column
	private int precio;

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, idLibro, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(autor, other.autor) && idLibro == other.idLibro && Objects.equals(nombre, other.nombre)
				&& precio == other.precio;
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", nombre=" + nombre + ", autor=" + autor + ", precio=" + precio + "]";
	}

}