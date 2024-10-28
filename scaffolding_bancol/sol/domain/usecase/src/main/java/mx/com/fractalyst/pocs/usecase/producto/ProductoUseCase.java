package mx.com.fractalyst.pocs.usecase.producto;

import mx.com.fractalyst.pocs.model.producto.Producto;
import mx.com.fractalyst.pocs.model.producto.gateways.ProductoRepository;

import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductoUseCase {
    private final ProductoRepository service;

    public Producto getProducto (String id) {
        return service.getProducto(id);
    }

    public List<Producto> getProductos () {
        return service.getProductos();
    }

    public BigDecimal getProductoPrecio (String id) {
        return service.getProductoPrecio(id);
    }

    public boolean addProducto (Producto producto) {
        return service.addProducto(producto);
    }
 
    public String ping (String mensaje) {
        return service.ping(mensaje);
    }
}
