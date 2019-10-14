import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.LocalDate;
/**
 * ATM
 */
public class ATM extends CorrespondenteBancario {

    public ATM(DayOfWeek[] diasDaSemana, LocalTime horaAbertura, LocalTime horaFechamento) {
        super(diasDaSemana, horaAbertura, horaFechamento);
    }
    @Override
    public void sacar(double valor, ContaBancaria conta){
        for (DayOfWeek v : super.getDiasDaSemana()) {
            if (LocalDate.now().getDayOfWeek().equals(v)) {
                break;
            }
            System.out.println("!!! Hoje não é um dia de funcionamento !!!");
            return;
        }
        if (valor <= 600 && valor % 2 == 0) {
            if (LocalTime.now().getHour() >= super.getHoraAbertura().getHour() && LocalTime.now().getHour() <=      super.getHoraFechamento().getHour()) {
                if (conta.getSaldo() - valor >= 0) {
                    conta.setSaldo(conta.getSaldo() - valor);
                } 
            }
        }else{
            System.err.println("!!! VALOR MAIOR DO QUE O ACEITADO NO ATM OU VALOR NÃO MULTIPLO DE 2 !!!");
        }
    }
    @Override
    public void sacar(double valor, ContaCorrente conta) {
        for (DayOfWeek v : super.getDiasDaSemana()) {
            if (LocalDate.now().getDayOfWeek().equals(v)) {
                break;
            }
            System.out.println("!!! Hoje não é um dia de funcionamento !!!");
            return;
        }
        if (valor <= 600 && valor % 2 == 0) {
            if (LocalTime.now().getHour() >= super.getHoraAbertura().getHour() && LocalTime.now().getHour() <= super.getHoraFechamento().getHour()) {
                if (conta.getSaldo() - valor >= -conta.getSaldoExtra()) {
                    conta.setSaldo(conta.getSaldo() - valor);
                }else {
                    System.err.println("!!! VOCE ESTRAPOLOU O SEU SALDO + O SALDO EXTRA");
                }
            }
        }else{
            System.err.println("!!! VALOR MAIOR DO QUE O ACEITADO NO ATM OU VALOR NÃO MULTIPLO DE 2 !!!");
        }
    }
}