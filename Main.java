import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.LocalTime;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        DayOfWeek[] dias = {DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY ,DayOfWeek.FRIDAY, DayOfWeek.SATURDAY};

        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("_____________________________________________________________\nAgência:\n\n");
        Agencia agencia = new Agencia(dias, LocalTime.of(6, 0), LocalTime.of(22, 0), 1);
        ContaCorrente contaC1 = agencia.criarConta("Lucas", 400);
        ContaSalario contaS1 = agencia.criarConta("Marcos");
        ContaCorrente contaC2 = agencia.criarConta("Juvenal", 50);
        agencia.depositar(500, contaC1);
        agencia.depositar(700, contaS1);
        System.out.println("Conta corrente: " + agencia.verSaldo(contaC1) + " \n"+ "Conta salario: " + agencia.verSaldo(contaS1));
        agencia.sacar(900, contaC1);
        System.out.println("Conta corrente: " + agencia.verSaldo(contaC1));
        agencia.depositar(500, contaC1);
        System.out.println("Conta corrente:" + agencia.verSaldo(contaC1));
        agencia.encerrarConta(contaC2);
        agencia.transferir(100, contaC1, contaS1);
        System.out.println("Transferiu 100 R$ from conta corrente to conta salario");
        System.out.println("Conta salario: " + agencia.verSaldo(contaS1) + " \n" + "Conta corrente: " + agencia.verSaldo(contaC1));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("_____________________________________________________________\nCorrespondente Bancario:\n\n");
        CorrespondenteBancario correspondente = new CorrespondenteBancario(dias, LocalTime.of(8, 0), LocalTime.of(23, 0));
        correspondente.sacar(400, contaS1);
        correspondente.sacar(300, contaC1);
        System.out.println("Conta salario: " + correspondente.verSaldo(contaS1));
        System.out.println("Conta corrente: " + correspondente.verSaldo(contaC1));
        correspondente.depositar(500, contaC1);
        correspondente.depositar(600, contaS1);
        System.out.println("Conta salario: " + correspondente.verSaldo(contaS1));
        System.out.println("Conta corrente: " + correspondente.verSaldo(contaC1));
        correspondente.transferir(400, contaS1, contaC1);
        System.out.println("Conta salario: " + correspondente.verSaldo(contaS1));
        System.out.println("Conta corrente: " + correspondente.verSaldo(contaC1));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("_____________________________________________________________\nATM:\n\n");
        ATM atm = new ATM(dias, LocalTime.of(8, 0), LocalTime.of(23, 0));
        atm.sacar(250, contaC1);
        System.out.println("Conta corrente: " + atm.verSaldo(contaC1));
        atm.sacar(200, contaS1);
        System.out.println("Conta salario: " + atm.verSaldo(contaS1));
        atm.depositar(50, contaC1);
        System.out.println("Conta corrente: " + atm.verSaldo(contaC1));
        atm.depositar(100, contaS1);
        System.out.println("Conta salario: " + atm.verSaldo(contaS1));
        atm.transferir(200, contaS1, contaC1);
        System.out.println("Conta salario: " + atm.verSaldo(contaS1));
        System.out.println("Conta corrente: " + atm.verSaldo(contaC1));

        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("_____________________________________________________________\nLotérica:\n\n");
        Loterica loterica = new Loterica(dias, LocalTime.of(7, 0), LocalTime.of(22, 0));
        
        loterica.sacar(250, contaC1);
        System.out.println("Conta corrente: " + loterica.verSaldo(contaC1));
        loterica.sacar(200, contaS1);
        System.out.println("Conta salario: " + loterica.verSaldo(contaS1));
        loterica.depositar(50, contaC1);
        System.out.println("Conta corrente: " + loterica.verSaldo(contaC1));
        loterica.depositar(100, contaS1);
        System.out.println("Conta salario: " + loterica.verSaldo(contaS1));
        loterica.transferir(200, contaS1, contaC1);
        System.out.println("Conta salario: " + loterica.verSaldo(contaS1));
        System.out.println("Conta corrente: " + loterica.verSaldo(contaC1));

        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("_____________________________________________________________\nCorreios:\n\n");
        Correios correios = new Correios(dias, LocalTime.of(8, 0),LocalTime.of(22, 0));
        correios.depositar(500, contaS1);
        System.out.println(correios.verSaldo(contaS1));
        correios.depositar(200, contaC1);
        System.out.println(correios.verSaldo(contaC1));
        correios.sacar(300, contaC1);
        correios.sacar(100, contaS1);
        System.out.println(correios.verSaldo(contaS1));
        System.out.println(correios.verSaldo(contaC1));
        correios.sacar(800, contaC1);
        correios.transferir(800, contaC1, contaS1);
        System.out.println("Conta corrente: " + correios.verSaldo(contaC1));
        System.err.println("Conta salario: " + correios.verSaldo(contaS1));
    }
}