/**
 * ContaBancaria
 */
public abstract class ContaBancaria {
    private int numero;
    private String cliente;
    private double saldo;

    public ContaBancaria(String cliente, int numero) {
        this.cliente = cliente;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
}