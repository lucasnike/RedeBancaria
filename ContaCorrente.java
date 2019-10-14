/**
 * ContaCorrente
 */
public class ContaCorrente extends ContaBancaria{

    private double saldoExtra;

    public ContaCorrente(String cliente, int numero, double saldoExtra) {
        super(cliente, numero);
        this.saldoExtra = saldoExtra;
    }

    public double getSaldoExtra() {
        return saldoExtra;
    }

    public void setSaldoExtra(double saldoExtra) {
        this.saldoExtra = saldoExtra;
    }
}