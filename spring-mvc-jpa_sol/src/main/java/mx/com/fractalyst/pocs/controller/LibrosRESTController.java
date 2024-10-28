package mx.com.fractalyst.pocs.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import mx.com.fractalyst.pocs.model.Libro;
import mx.com.fractalyst.pocs.service.LibrosService;

//
@RestController
@RequestMapping("/rest")
public class LibrosRESTController {
	// autowire al servicio
	@Autowired
	LibrosService librosService;

	// URL para consultar todos los libros
	@GetMapping("/libros")
	private List<Libro> consultaLibros() {
		return librosService.consultaLibros();
	}

	// URL para consultar un libro
	@GetMapping("/libros/{id-libro}")
	private Libro consultaLibro(@PathVariable("id-libro") int idLibro) {

		Libro libro = librosService.consultaLibroPorId(idLibro);

		if (libro == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado");
		}

		return libro;
	}

	// URL para el borrado de un libro
	@DeleteMapping("/libros/{id-libro}")
	private void bajaLibro(@PathVariable("id-libro") int idLibro) {
		librosService.bajaLibro(idLibro);
	}

	// URL para alta libro
	@PostMapping("/libros")
	private int altaLibro(@RequestBody Libro libro) {
		librosService.altaLibro(libro);
		return libro.getIdLibro();
	}

	// URL para cambio libro
	@PutMapping("/libros/{id-libro}")
	private Libro cambioLibro(@PathVariable("id-libro") int idLibro, @RequestBody Libro libro) {
		librosService.cambioLibro(libro, idLibro);
		return libro;
	}

}