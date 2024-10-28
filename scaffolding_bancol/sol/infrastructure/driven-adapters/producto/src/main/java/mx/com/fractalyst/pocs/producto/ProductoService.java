package mx.com.fractalyst.pocs.producto;

import mx.com.fractalyst.pocs.model.producto.Producto;
import mx.com.fractalyst.pocs.model.producto.gateways.ProductoRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductoService implements ProductoRepository {
 
    private final static List<Producto> productos = new ArrayList<>(10);  // Memoria
    private final Producto NO_PRODUCTO = Producto.builder().id(UUID.randomUUID().toString()).nombre("NO-NAME").precio(new BigDecimal(0.0)).build();

    @Override
    public Producto getProducto(String id) {
        return productos.stream()
        .filter(p -> p.getId().equalsIgnoreCase(id)).findAny()
        .orElse(NO_PRODUCTO);
    }

    @Override
    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public BigDecimal getProductoPrecio(final String id) {
        return productos.stream()
        .filter(p -> p.getId().equalsIgnoreCase(id)).map(p -> p.getPrecio()).findAny()
        .orElse(NO_PRODUCTO.getPrecio());
    }

    @Override
    public boolean addProducto(Producto producto) {
        // 
        return productos.add(producto);
    }

    @Override
    public String ping(String mensaje) {
        return mensaje;
    }
}