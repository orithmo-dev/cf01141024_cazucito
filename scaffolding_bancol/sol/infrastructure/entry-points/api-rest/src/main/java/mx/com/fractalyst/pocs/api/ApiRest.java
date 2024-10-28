package mx.com.fractalyst.pocs.api;

import mx.com.fractalyst.pocs.model.producto.Producto;
import mx.com.fractalyst.pocs.usecase.producto.ProductoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final ProductoUseCase useCase;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiRest.class);

    @GetMapping("/ping")
    public String ping (@RequestParam(name="mensaje", required = false) String mensaje) {
        if(mensaje==null) mensaje = "pong";
        return useCase.ping(mensaje);
    }

    @GetMapping(path = "/productos")
    public List<Producto> getProductos () {
        return useCase.getProductos();
    }

    @GetMapping(path = "/productos/{id}")
    public Producto getProducto (@PathVariable(name="id") String id) {
        return useCase.getProducto(id);
    }

    @GetMapping(path ="/productos/{id}/precio")
    public BigDecimal getProductoPrecio (@PathVariable(name="id") String id) {
        return useCase.getProductoPrecio(id);
    }

    @PostMapping("/productos")
    public boolean addProducto (@RequestBody Producto producto) {
        LOGGER.info("::: P/P ::: {} / {}", producto.getNombre(), producto.getPrecio());
        return useCase.addProducto(producto);
    }
}