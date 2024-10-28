package mx.com.fractalyst.pdv.sc.c;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import mx.com.fractalyst.pdv.sc.m.Cliente;
import mx.com.fractalyst.pdv.sc.m.Cuenta;
import mx.com.fractalyst.pdv.sc.m.EstatusPedido;
import mx.com.fractalyst.pdv.sc.m.Pedido;
import mx.com.fractalyst.pdv.sc.m.PedidosRepository;
import mx.com.fractalyst.pdv.sc.m.Producto;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/pedidos")
public class PedidosController {

	private final WebClient.Builder loadBalancedWebClientBuilder;
	private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

	public PedidosController(WebClient.Builder webClientBuilder, ReactorLoadBalancerExchangeFilterFunction lbFunction) {
		this.loadBalancedWebClientBuilder = webClientBuilder;
		this.lbFunction = lbFunction;
	}

	@Autowired
	PedidosRepository pedidosRepo;

	@PostMapping
	public Pedido preparar(@RequestBody Pedido pedido) {
		LoggerFactory.getLogger(getClass())
				.info("--- IMPORTANTE: POST pedidos [" + pedido + "] -> productos y clientes ---");
		List<Producto> productos = loadBalancedWebClientBuilder.build().post()
				.uri("http://servicio-de-productos/productos/ids")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(pedido.getIdsProductos()), List.class).retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<Producto>>() {
				}).block();
		Cliente cliente = loadBalancedWebClientBuilder.build().get()
				.uri("http://servicio-de-clientes/clientes/conCuentas/" + pedido.getIdCliente()).retrieve()
				.bodyToMono(Cliente.class).block();
		//
		int precioTotal = productos.stream().mapToInt(p -> p.getPrecio()).sum();
		final int precioConDescuento = obtenPrecioConDescuento(precioTotal, cliente);
		//
		Optional<Cuenta> cuenta = cliente.getCuentas().stream().filter(a -> (a.getBalance() > precioConDescuento))
				.findFirst();
		if (cuenta.isPresent()) {
			pedido.setIdCuenta(cuenta.get().getId());
			pedido.setEstatusPedido(EstatusPedido.ACEPTADO);
			pedido.setPrecio(precioConDescuento);
		} else {
			pedido.setEstatusPedido(EstatusPedido.RECHAZADO);
		}
		return pedidosRepo.add(pedido);
	}

	@PutMapping("/{id}")
	public Pedido aceptar(@PathVariable("id") Long id) {
		LoggerFactory.getLogger(getClass())
				.info("--- IMPORTANTE: PUT pedidos/" + id + " -> cuentas/retiro/{id}/{cantidad} ---");
		final Pedido pedido = pedidosRepo.findById(id);
		Cuenta cuenta = loadBalancedWebClientBuilder.build().put()
				.uri("http://servicio-de-cuentas/cuentas/retiro/" + pedido.getIdCuenta() + "/" + pedido.getPrecio())
				.retrieve().bodyToMono(Cuenta.class).block();
		pedido.setEstatusPedido(EstatusPedido.HECHO);
		pedidosRepo.update(pedido);
		return pedido;
	}

	private int obtenPrecioConDescuento(int precio, Cliente cliente) {
		double descuento = 0;
		switch (cliente.getTipoCliente()) {
		case REGULAR:
			descuento += 0.05;
			break;
		case VIP:
			descuento += 0.1;
			break;

		default:
			break;
		}
		int cantidadPedidos = pedidosRepo.countByCustomerId(cliente.getId());
		descuento += (cantidadPedidos * 0.01);
		return (int) (precio - (precio * descuento));
	}
}
