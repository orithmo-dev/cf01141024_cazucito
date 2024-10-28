package mx.com.fractalyst.pdv.sc.c;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mx.com.fractalyst.pdv.sc.m.Cliente;
import mx.com.fractalyst.pdv.sc.m.ClientesRepository;

@RestController
public class ClientesController {

	@Autowired
	ClientesRepository clienteRepo;

	@PostMapping
	public Cliente altaCliente(@RequestBody Cliente cliente) {
		return clienteRepo.add(cliente);
	}

	@DeleteMapping("/{id}")
	public void eliminaCliente(@PathVariable("id") Long id) {
		clienteRepo.delete(id);
	}	

	@PutMapping
	public Cliente actualizaCliente(@RequestBody Cliente cliente) {
		return clienteRepo.update(cliente);
	}

	@GetMapping("/{id-cliente}")
	public Cliente obtenClientePorId(@PathVariable("id-cliente") Long idCliente) {
		return clienteRepo.findById(idCliente);
	}


	@PostMapping("/ids")
	public List<Cliente> obtenClientes(@RequestBody List<Long> ids) {
		return clienteRepo.find(ids);
	}

	@GetMapping
	public List<Cliente> obtenClientes() {
		return clienteRepo.findAll();
	}

}