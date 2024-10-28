package mx.com.fractalyst.pdv.sc.m;


import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private Long id;
    private String nombre;
    private TipoCliente tipoCliente;
    private List<Cuenta> cuentas = new ArrayList<>();

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Cliente(Long id, String nombre, TipoCliente tipoCliente) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
    }

    public Cliente(String nombre, TipoCliente tipoCliente) {
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Cliente() {

    }

}