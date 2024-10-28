package mx.com.fractalyst.pdv.sc.c;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.fractalyst.pdv.sc.m.Cuenta;
import mx.com.fractalyst.pdv.sc.m.CuentasRepository;

@RestController
@RequestMapping("/cuentas")
public class CuentasController {

	@Autowired
	CuentasRepository cuentaRepo;

	@PostMapping
	public Cuenta altaCuenta(@RequestBody Cuenta cuenta) {
		return cuentaRepo.add(cuenta);
	}

	@PutMapping
	public Cuenta actualizaCuenta(@RequestBody Cuenta cuenta) {
		return cuentaRepo.update(cuenta);
	}

	// IMPLEMENTACIÓN PARA INSTRUCCIÓN
	@PutMapping("/retiro/{id}/{cantidad}")
	public Cuenta retiro(@PathVariable("id") Long id, @PathVariable("cantidad") int cantidad) {
		LoggerFactory.getLogger(getClass()).info("--- IMPORTANTE: /cuentas/retiro/" + id + "/" + cantidad + " ---");
		Cuenta cuenta = cuentaRepo.findById(id);
		cuenta.setBalance(cuenta.getBalance() - cantidad);
		return cuentaRepo.update(cuenta);
	}

	@GetMapping("/{id}")
	public Cuenta obtenCuentaPorId(@PathVariable("id") Long id) {
		return cuentaRepo.findById(id);
	}

	@GetMapping("/cliente/{cliente-id}")
	public List<Cuenta> obtenCuentasPorIdCliente(@PathVariable("cliente-id") Long clienteId) {
		LoggerFactory.getLogger(getClass()).info("--- IMPORTANTE: cuentas/cliente/" + clienteId + " ---");
		return cuentaRepo.findByCliente(clienteId);
	}

	@PostMapping("/ids")
	public List<Cuenta> obtenCuentas(@RequestBody List<Long> ids) {
		return cuentaRepo.find(ids);
	}

	@DeleteMapping("/{id}")
	public void eliminaCuenta(@PathVariable("id") Long id) {
		cuentaRepo.delete(id);
	}
}