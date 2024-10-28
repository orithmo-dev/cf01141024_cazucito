package mx.com.fractalyst.pdv.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import mx.com.fractalyst.pdv.sc.m.Producto;
import mx.com.fractalyst.pdv.sc.m.ProductosRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayProductosApplication.class, args);
	}
	

	@Bean
	ProductosRepository repository() {
		ProductosRepository productoRepo = new ProductosRepository();
		productoRepo.add(new Producto("Producto 1", 100));
		productoRepo.add(new Producto("Producto 2", 200));
		productoRepo.add(new Producto("Producto 3", 300));
		productoRepo.add(new Producto("Producto 4", 400));
		productoRepo.add(new Producto("Producto 5", 500));
		return productoRepo;
	}
}
