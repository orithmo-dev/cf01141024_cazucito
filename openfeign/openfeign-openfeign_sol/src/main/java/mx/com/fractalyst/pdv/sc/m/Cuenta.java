package mx.com.fractalyst.pdv.sc.m;

public class Cuenta {

    private Long id;
    private String numeroCuenta;
    private int balance;

    public Cuenta() {

    }

    public Cuenta(Long id, String numeroCuenta, int balance) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
