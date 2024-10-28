package mx.com.fractalyst.pdv.sc.m;

import java.util.List;

public class Pedido {

	private Long id;
	private EstatusPedido estatusPedido;
	private int precio;
	private Long idCliente;
	private Long idCuenta;
	private List<Long> idsProductos;

	public Pedido() {
	}

	public Pedido(Long id, EstatusPedido estatusPedido, int precio, Long idCliente, Long idCuenta,
			List<Long> idsProductos) {
		super();
		this.id = id;
		this.estatusPedido = estatusPedido;
		this.precio = precio;
		this.idCliente = idCliente;
		this.idCuenta = idCuenta;
		this.idsProductos = idsProductos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EstatusPedido getEstatusPedido() {
		return estatusPedido;
	}

	public void setEstatusPedido(EstatusPedido estatusPedido) {
		this.estatusPedido = estatusPedido;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}

	public List<Long> getIdsProductos() {
		return idsProductos;
	}

	public void setIdsProductos(List<Long> idsProductos) {
		this.idsProductos = idsProductos;
	}

}
