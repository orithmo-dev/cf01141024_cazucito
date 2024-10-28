package mx.com.fractalyst.pdv.sc.c;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import mx.com.fractalyst.pdv.sc.m.Cliente;

@FeignClient(name = "servicio-de-clientes-openfeign")
public interface ClienteOpenFeign {

    @GetMapping("/{id-cliente}")
    Cliente obtenCliente(@PathVariable("id-cliente") Long idCliente);

}
