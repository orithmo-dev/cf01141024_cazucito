package mx.com.fractalyst.pdv.sc.m;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



public class ClientesRepository {

    private List<Cliente> clientes = new ArrayList<>();

    public Cliente add(Cliente cliente) {
        cliente.setId((long) (clientes.size()+1));
        clientes.add(cliente);
        return cliente;
    }

    public Cliente update(Cliente cliente) {
        clientes.set(cliente.getId().intValue() - 1, cliente);
        return cliente;
    }

    public Cliente findById(Long id) {
        Optional<Cliente> cliente = clientes.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (cliente.isPresent())
            return cliente.get();
        else
            return null;
    }

    public void delete(Long id) {
        clientes.remove(id.intValue());
    }

    public List<Cliente> find(List<Long> ids) {
        return clientes.stream().filter(p -> ids.contains(p.getId())).collect(Collectors.toList());
    }

}
