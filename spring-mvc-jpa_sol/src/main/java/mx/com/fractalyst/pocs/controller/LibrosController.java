package mx.com.fractalyst.pocs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mx.com.fractalyst.pocs.model.Libro;
import mx.com.fractalyst.pocs.service.LibrosService;

@Controller
public class LibrosController {
	//
	@Autowired
	LibrosService librosService;

	// URL para consultar todos los libros
	@GetMapping("/index.do")
	private String consultaLibros(Model model) {
		List<Libro> libros = librosService.consultaLibros();
		model.addAttribute("libros", libros);
		return "index";
	}

	// URL para el borrado de un libro
	@GetMapping("/baja.do/{id-libro}")
	private String bajaLibro(@PathVariable("id-libro") int idLibro) {
		librosService.bajaLibro(idLibro);
		return "redirect:/index.do";
	}

	// URL para alta libro formulario
	@GetMapping("/alta.do")
	private String altaLibro(Model model) {
		model.addAttribute("libro", new Libro());
		return "/alta-libro";
	}

	// URL para alta libro
	@PostMapping("/alta.do")
	private String altaLibro(Libro libro) {
		librosService.altaLibro(libro);
		return "redirect:/index.do";
	}

	// URL para cambio libro formulario
	@GetMapping("/cambio.do/{id-libro}")
	private String cambioLibro(@PathVariable("id-libro") int idLibro, Model model) {
		Libro libro = librosService.consultaLibroPorId(idLibro);
		model.addAttribute("libro", libro);
		return "/cambio-libro";
	}

	// URL para cambio libro
	@PostMapping("/cambio.do/{id-libro}")
	private String cambioLibro(Libro libro, @PathVariable("id-libro") int idLibro) {
		librosService.cambioLibro(libro, idLibro);
		return "redirect:/index.do";
	}

}