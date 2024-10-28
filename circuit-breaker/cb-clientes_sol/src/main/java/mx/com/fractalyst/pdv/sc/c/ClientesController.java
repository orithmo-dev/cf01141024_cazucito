package mx.com.fractalyst.pdv.sc.c;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import mx.com.fractalyst.pdv.sc.m.Cliente;
import mx.com.fractalyst.pdv.sc.m.ClientesRepository;
import mx.com.fractalyst.pdv.sc.m.Cuenta;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ClientesRepository clienteRepo;

	@PostMapping
	public Cliente altaCliente(@RequestBody Cliente cliente) {
		return clienteRepo.add(cliente);
	}

	@PutMapping
	public Cliente actualizaCliente(@RequestBody Cliente cliente) {
		return clienteRepo.update(cliente);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> obtenClientePorId(@PathVariable("id") Long id) {
		return new ResponseEntity<Cliente>(clienteRepo.findById(id), HttpStatus.OK);
	}

	@GetMapping("/conCuentas/{id}")
	@CircuitBreaker(name = "servicio-de-clientes", fallbackMethod = "obtenClientePorIdConCuentasFallback")
	public ResponseEntity<Cliente> obtenClientePorIdConCuentas(@PathVariable("id") Long id) {
		LoggerFactory.getLogger(getClass())
				.info("--- IMPORTANTE: clientes/conCuentas/" + id + " -> cuentas/cliente/" + id + " ---");
		Cuenta[] accounts = restTemplate.getForObject("http://servicio-de-cuentas/cuentas/cliente/{cliente-id}",
				Cuenta[].class, id);
		Cliente c = clienteRepo.findById(id);
		c.setCuentas(Arrays.stream(accounts).collect(Collectors.toList()));
		return new ResponseEntity<Cliente>(c, HttpStatus.OK);
	}

	public ResponseEntity<String> obtenClientePorIdConCuentasFallback(@PathVariable("id") Long id, Exception e) {
		LoggerFactory.getLogger(getClass()).info("--- IMPORTANTE: fallback ---");
		return new ResponseEntity<String>("servicio-de-cuentas no responde. Flujo alterno \n", HttpStatus.OK);
	}

	@PostMapping("/ids")
	public List<Cliente> obtenClientes(@RequestBody List<Long> ids) {
		return clienteRepo.find(ids);
	}

	@DeleteMapping("/{id}")
	public void eliminaCliente(@PathVariable("id") Long id) {
		clienteRepo.delete(id);
	}
}
