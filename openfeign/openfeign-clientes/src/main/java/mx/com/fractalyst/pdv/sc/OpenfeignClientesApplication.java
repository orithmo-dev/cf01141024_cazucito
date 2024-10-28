package mx.com.fractalyst.pdv.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import mx.com.fractalyst.pdv.sc.m.Cliente;
import mx.com.fractalyst.pdv.sc.m.ClientesRepository;
import mx.com.fractalyst.pdv.sc.m.Cuenta;
import mx.com.fractalyst.pdv.sc.m.TipoDeCliente;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients
public class OpenfeignClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenfeignClientesApplication.class, args);
	}
	
	@Bean
	ClientesRepository repository() {
		// NO FOR PRODUCTION
		ClientesRepository repository = new ClientesRepository();
		repository.add(new Cliente(1L, "Juan López", TipoDeCliente.NUEVO, new Cuenta(1L, "111111", 1000)));
		repository.add(new Cliente(2L, "Jose Pérez", TipoDeCliente.REGULAR, new Cuenta(2L, "222222", 000)));
		repository.add(new Cliente(3L, "Ana Hernández", TipoDeCliente.VIP, new Cuenta(3L, "333333", 1000)));
		return repository;
	}
}
