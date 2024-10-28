package mx.com.fractalyst.pdv.sc.m;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PedidosRepository {

    private List<Pedido> pedidos = new ArrayList<>();

    public Pedido add(Pedido pedido) {
        pedido.setId((long) (pedidos.size() + 1));
        pedidos.add(pedido);
        return pedido;
    }

    public Pedido update(Pedido pedido) {
        pedidos.set(pedido.getId().intValue() - 1, pedido);
        return pedido;
    }

    public Pedido findById(Long id) {
        Optional<Pedido> pedido = pedidos.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (pedido.isPresent())
            return pedido.get();
        else
            return null;
    }

    public void delete(Long id) {
        pedidos.remove(id.intValue());
    }

    public List<Pedido> find(List<Long> ids) {
        return pedidos.stream().filter(p -> ids.contains(p.getId())).collect(Collectors.toList());
    }

    public int countByCustomerId(Long idCliente) {
        return (int) pedidos.stream().filter(p -> p.getIdCliente().equals(idCliente)).count();
    }
}
