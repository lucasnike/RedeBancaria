import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Scanner;
import java.time.LocalDate;
/**
 * CorrespondenteBancario
 */

public class CorrespondenteBancario implements OperacoesBancarias{
    Scanner tec = new Scanner(System.in);

    private DayOfWeek[] diasDaSemana;
    private LocalTime horaAbertura;
    private LocalTime horaFechamento;

    public CorrespondenteBancario(DayOfWeek[] diasDaSemana, LocalTime horaAbertura, LocalTime horaFechamento) {
        this.diasDaSemana = diasDaSemana;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
    }

    @Override
    public void sacar(double valor, ContaBancaria conta) {
        for (DayOfWeek v : this.diasDaSemana) {
            if (LocalDate.now().getDayOfWeek().equals(v)) {
                break;
            }
            System.out.println("!!! Hoje não é um dia de funcionamento !!!");
            return;
        }
        if (LocalTime.now().getHour() >= horaAbertura.getHour() && LocalTime.now().getHour() <= horaFechamento.getHour()) {
            if (conta.getSaldo() - valor >= 0) {
                conta.setSaldo(conta.getSaldo() - valor);
            } 
        }else{
            System.out.println("!!! FORA DO HORARIO DE FUNCIONAMENTO !!!");
        }
    }

    public void sacar(double valor, ContaCorrente conta) {
        for (DayOfWeek v : this.diasDaSemana) {
            if (LocalDate.now().getDayOfWeek().equals(v)) {
                break;
            }
            System.out.println("!!! Hoje não é um dia de funcionamento !!!");
            return;
        }
        if (LocalTime.now().getHour() >= horaAbertura.getHour() && LocalTime.now().getHour() <= horaFechamento.getHour()) {
            if (conta.getSaldo() - valor >= -conta.getSaldoExtra()) {
                conta.setSaldo(conta.getSaldo() - valor);
            }else {
                System.err.println("!!! VOCE ESTRAPOLOU O SEU SALDO + O SALDO EXTRA");
            }
        }
    }

    @Override
    public void depositar(double valor, ContaBancaria conta) {
        for (DayOfWeek v : this.diasDaSemana) {
            if (LocalDate.now().getDayOfWeek().equals(v)) {
                break;
            }
            System.out.println("!!! Hoje não é um dia de funcionamento !!!");
            return;
        }
        if (LocalTime.now().getHour() >= horaAbertura.getHour() && LocalTime.now().getHour() <= horaFechamento.getHour()) {
            conta.setSaldo(conta.getSaldo() + valor);
        }
    }

    @Override
    public void transferir(double valor, ContaBancaria contaOrigem, ContaBancaria contaDestino) {
        for (DayOfWeek v : this.diasDaSemana) {
            if (LocalDate.now().getDayOfWeek().equals(v)) {
                break;
            }
            System.out.println("!!! Hoje não é um dia de funcionamento !!!");
            return;
        }
        if (LocalTime.now().getHour() >= horaAbertura.getHour() && LocalTime.now().getHour() <= horaFechamento.getHour()) {
            if (contaDestino != contaOrigem) {
                if (contaOrigem.getSaldo() - valor >= 0) {
                    contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
                    depositar(valor, contaDestino);
                }else{
                    System.out.println("!!! A CONTA ORIGEM NÃO TEM A QUANTIA DE DINHEIRO !!!");
                }
            }else{
                System.err.println("!!! AS CONTAS SÃO AS MESMAS !!!");
            }
        }
    }
    @Override
    public double verSaldo(ContaBancaria conta) {
        return conta.getSaldo();
    }

    public DayOfWeek[] getDiasDaSemana() {
        return diasDaSemana;
    }

    public void setDiasDaSemana(DayOfWeek[] diasDaSemana) {
        this.diasDaSemana = diasDaSemana;
    }

    public LocalTime getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(LocalTime horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public LocalTime getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(LocalTime horaFechamento) {
        this.horaFechamento = horaFechamento;
    }
}