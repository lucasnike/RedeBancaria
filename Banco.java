/**
 * Banco
 */
public interface Banco extends OperacoesBancarias{
    public ContaBancaria criarConta(String cliente);
    public void encerrarConta(ContaBancaria conta);
}