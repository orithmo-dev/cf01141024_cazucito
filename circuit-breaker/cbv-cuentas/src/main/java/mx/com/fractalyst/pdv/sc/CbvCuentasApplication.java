package mx.com.fractalyst.pdv.sc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import mx.com.fractalyst.pdv.sc.m.Cuenta;
import mx.com.fractalyst.pdv.sc.m.CuentasRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class CbvCuentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbvCuentasApplication.class, args);
	}
	
	/**
	 * Creación de datos en memoria (cuentas)
	 * @return
	 */
	@Bean
	CuentasRepository repository() {
		CuentasRepository repository = new CuentasRepository();
		repository.add(new Cuenta("1234567890", 5000, 1L));
		repository.add(new Cuenta("1234567891", 5000, 1L));
		repository.add(new Cuenta("1234567892", 0, 1L));
		repository.add(new Cuenta("1234567893", 5000, 2L));
		repository.add(new Cuenta("1234567894", 0, 2L));
		repository.add(new Cuenta("1234567895", 5000, 2L));
		repository.add(new Cuenta("1234567896", 0, 3L));
		repository.add(new Cuenta("1234567897", 5000, 3L));
		repository.add(new Cuenta("1234567898", 5000, 3L));
		return repository;
	}
	
}
