package mx.com.fractalyst.pdv.sc.c;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import mx.com.fractalyst.pdv.sc.m.Cliente;

@RestController
public class OpenFeignController {

    @Autowired
    ClienteOpenFeign clienteOpenFeign;

    @GetMapping("/{id-cliente}")
    public Cliente obtenClientePorId(@PathVariable("id-cliente") Long idCliente) {
        return clienteOpenFeign.obtenCliente(idCliente);
    }

}
