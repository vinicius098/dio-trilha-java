import java.util.InputMismatchException;
import java.util.Scanner;

class ContaBancaria {
    private String nomeUsuario;
    private String numeroAgencia;
    private double saldo;

    public ContaBancaria(String nomeUsuario, String numeroAgencia) {
        this.nomeUsuario = nomeUsuario;
        this.numeroAgencia = numeroAgencia;
        this.saldo = 0.0;
    }

    public ContaBancaria(String nomeUsuario, String numeroAgencia, double saldoInicial) {
        this.nomeUsuario = nomeUsuario;
        this.numeroAgencia = numeroAgencia;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de " + valor + " realizado com sucesso.");

    }
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }


    public double getSaldo() {
        return saldo;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome de Usuario");
        String nomeUsuario = scanner.nextLine();

        System.out.println("Digite o número da agência:");
        String numeroAgencia = scanner.nextLine();

        System.out.println("\nSeja bem vindo! " + nomeUsuario + " Agencia " + numeroAgencia);

        System.out.println("\nPara continuar, pressione Enter...");
        scanner.nextLine(); // Aguarda a entrada do usuário

        ContaBancaria conta = new ContaBancaria(nomeUsuario, numeroAgencia);

        boolean executando = true;
        while (executando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Verificar Saldo");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                if (opcao == 1) {
                    System.out.println("Digite o valor a depositar:");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    conta.depositar(valorDeposito);
                } else if (opcao == 2) {
                    System.out.println("Digite o valor a sacar:");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    conta.sacar(valorSaque);
                } else if (opcao == 3) {
                    System.out.println("Saldo atual: " + conta.getSaldo());
                    executando = false;
                } else {
                    System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }

        scanner.close();
    }
}
