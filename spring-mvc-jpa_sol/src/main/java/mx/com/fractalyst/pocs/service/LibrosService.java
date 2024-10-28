package mx.com.fractalyst.pocs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.fractalyst.pocs.model.Libro;
import mx.com.fractalyst.pocs.model.LibrosRepository;

// Lógica de negocio
@Service
public class LibrosService {
    @Autowired
    LibrosRepository librosRepository;

    // Recuperación de todos los libros mediante findaAll() de CrudRepository
    public List<Libro> consultaLibros() {
        List<Libro> libros = new ArrayList<>();
        librosRepository.findAll().forEach(libro -> libros.add(libro));
        return libros;
    }

    // Recuperación de un libro mediante findById() de CrudRepository
    public Libro consultaLibroPorId(int id) {
        Optional<Libro> optLibro = librosRepository.findById(id);
        if (optLibro.isPresent()) {
            return optLibro.get();
        }
        return null;
    }

    // Guardar un libro mediante save() de CrudRepository
    public void altaLibro(Libro libro) {
        librosRepository.save(libro);
    }

    // Elimina un libro mediante deleteById() de CrudRepository
    public void bajaLibro(int id) {
        librosRepository.deleteById(id);
    }

    // Actualiza un libro mediante save() de CrudRepository
    public void cambioLibro(Libro libro, int idLibro) {
        libro.setIdLibro(idLibro);
        librosRepository.save(libro);
    }
}