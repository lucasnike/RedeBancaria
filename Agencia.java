import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.time.LocalDate;

/**
 * Agencia
 */
public class Agencia extends CorrespondenteBancario implements Banco {

    Random random = new Random();

    ArrayList<ContaSalario> contas = new ArrayList<>();
    ArrayList<ContaCorrente> contasCorrente = new ArrayList<>();
    
    private ContaCorrente contaC = new ContaCorrente("Lucas", 0,0);
    private ContaSalario contaS = new ContaSalario("Lucas", 0);
    private int numeroAgencia;

    public Agencia(DayOfWeek[] diasDaSemana, LocalTime horaAbertura, LocalTime horaFechamento,int numeroAgencia) {
        super(diasDaSemana, horaAbertura, horaFechamento);
        this.numeroAgencia = numeroAgencia;
    }


    private int cont = 0;
    @Override
    public ContaSalario criarConta(String cliente) {
        int ran = random.nextInt(500);

        if (LocalTime.now().getHour() >= super.getHoraAbertura().getHour() && LocalTime.now().getHour() <= super.getHoraFechamento().getHour()) {
            if (this.cont == 0) {
                contas.add(new ContaSalario(cliente, ran));
                this.cont++;
                return contas.get(cont - 1);
            }else{
                while (!this.testarNumeros(ran)) {
                    ran = random.nextInt(500);
                }
                contas.add(new ContaSalario(cliente, ran));
                return contas.get(cont - 1);
            }
        }else{
            System.out.println("!!! VOCE ESTA FORA DO HORARIO DE FUNCIONAMENTO !!!");
            return contaS;
        }
    }


    private int cont2 = 0;
    public ContaCorrente criarConta(String cliente, double saldoExtra){
        int ran = random.nextInt(500);
        if (LocalTime.now().getHour() >= super.getHoraAbertura().getHour() && LocalTime.now().getHour() <= super.getHoraFechamento().getHour()) {
            if (this.cont2 == 0) {
                contasCorrente.add(new ContaCorrente(cliente, ran, saldoExtra));
                this.cont2++;
                return contasCorrente.get(cont2 - 1);
            }else{
                while (!this.testarNumeros(ran)) {
                ran = random.nextInt(500);
                }
                contasCorrente.add(new ContaCorrente(cliente, ran,saldoExtra));
                return contasCorrente.get(cont2 - 1);
            }
        }else{
            System.out.println("!!! VOCE ESTA FORA DO HORARIO DE FUNCIONAMENTO !!!");
            return contaC;
        }
    }

    @Override
    public void encerrarConta(ContaBancaria conta) {
        if (LocalTime.now().getHour() >= super.getHoraAbertura().getHour() && LocalTime.now().getHour() <= super.getHoraFechamento().getHour()) {
            contas.remove(conta);
            System.out.println("!!!CONTA ENCERRADA COM SUCESSO!!!");
        }else{
            System.out.println("!!! VOCE ESTA FORA DO HORARIO DE FUNCIONAMENTO !!!");
        }
    }

    

    private boolean testarNumeros(int num) {
		for (ContaBancaria contaBancaria : contas) {
			int[] contV = new int[contas.size()];
			int cont = 0;
			for (int i = 0; i < contV.length; i++) {
				contV[i] = contaBancaria.getNumero();
			}
			for (int a : contV) {
				if (a != num) {
					cont++;
				}
			}
			if (cont == contas.size()) {
				return true;
			}
		}
		return false;
	}

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }
}