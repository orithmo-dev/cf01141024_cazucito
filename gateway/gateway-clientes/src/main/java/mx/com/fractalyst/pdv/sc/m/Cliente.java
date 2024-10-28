package mx.com.fractalyst.pdv.sc.m;


import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private Long id;
	private String nombre;
	private TipoDeCliente tipoCliente;
	private List<Cuenta> cuentas = new ArrayList<>();
	
	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Cliente(Long id, String nombre, TipoDeCliente tipoCliente) {
		this.id = id;
		this.nombre = nombre;
		this.tipoCliente = tipoCliente;
	}

	public Cliente(String nombre, TipoDeCliente tipoCliente) {
		this.nombre = nombre;
		this.tipoCliente = tipoCliente;
	}
	public Cliente(Long id, String nombre, TipoDeCliente tipoCliente, Cuenta cuenta) {
		this.id = id;
		this.nombre = nombre;
		this.tipoCliente = tipoCliente;
		this.cuentas.add(cuenta);
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoDeCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoDeCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Cliente() {

	}
}