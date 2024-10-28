package mx.com.fractalyst.pdv.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import mx.com.fractalyst.pdv.sc.m.PedidosRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class BalancerLbPedidosApplication {

    public static void main(String[] args) {
        SpringApplication.run(BalancerLbPedidosApplication.class, args);
    }

    @Bean
    PedidosRepository repository() {
        return new PedidosRepository();
    }
}