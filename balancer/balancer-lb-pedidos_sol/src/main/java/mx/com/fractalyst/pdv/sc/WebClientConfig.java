package mx.com.fractalyst.pdv.sc;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@LoadBalancerClients({ @LoadBalancerClient("servicio-de-productos"), @LoadBalancerClient("servicio-de-clientes"),
		@LoadBalancerClient("servicio-de-cuentas") })
public class WebClientConfig {

	@LoadBalanced
	@Bean
	WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}

}
