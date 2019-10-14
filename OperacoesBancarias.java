public interface OperacoesBancarias {
    public void sacar(double valor, ContaBancaria conta);
    public void depositar(double valor, ContaBancaria conta);
    public void transferir(double valor, ContaBancaria contaOrigem, ContaBancaria contaDestino);
    public double verSaldo(ContaBancaria conta);
}