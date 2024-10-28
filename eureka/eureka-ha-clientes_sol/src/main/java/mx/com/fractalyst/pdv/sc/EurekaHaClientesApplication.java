package mx.com.fractalyst.pdv.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaHaClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaHaClientesApplication.class, args);
	}

}
