import java.util.Scanner;

abstract class Conta {
    private String titular;
    protected double saldo;

    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract void depositar(double valor);

    public abstract void sacar(double valor);
}

class ContaCorrente extends Conta {
    public ContaCorrente(String titular) {
        super(titular);
    }

    public void depositar(double valor) {
        super.setSaldo(getSaldo() + valor);
        System.out.println("Depósito de R$ " + valor + " na conta corrente realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (getSaldo() >= valor) {
            super.setSaldo(getSaldo() - valor);
            System.out.println("Saque de R$ " + valor + " na conta corrente realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para saque na conta corrente.");
        }
    }
}

class ContaPoupanca extends Conta {
    public ContaPoupanca(String titular) {
        super(titular);
    }

    public void depositar(double valor) {
        super.setSaldo(getSaldo() + valor - 0.02 * valor);
        System.out
                .println("Depósito de R$ " + valor + " na conta poupança realizado com sucesso. Bonificação aplicada.");
    }

    
    public void sacar(double valor) {
        if (getSaldo() >= valor) {
            super.setSaldo(getSaldo() - valor);
            System.out.println("Saque de R$ " + valor + " na conta poupança realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para saque na conta poupança.");
        }
    }
}

public class GerenciaBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao sistema bancário!");

        System.out.println("Digite o tipo de conta (1 para Corrente, 2 para Poupança):");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Qual o seu nome:");
        String nome = scanner.nextLine();

        Conta conta = null;
        if (tipo == 1) {
            conta = new ContaCorrente(nome);
        } else if (tipo == 2) {
            conta = new ContaPoupanca(nome);
        }

        if (conta != null) {
            int opcao;
            do {
                System.out.println("\n------ Menu ----");
                System.out.println("1. Consultar Saldo");
                System.out.println("2. Realizar Depósito");
                System.out.println("3. Realizar Saque");
                System.out.println("4. Encerrar");
                System.out.println("Escolha uma opção:");
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Saldo: R$ " + conta.getSaldo());
                        break;
                    case 2:
                        System.out.println("Digite o valor do depósito:");
                        double valorDeposito = scanner.nextDouble();
                        conta.depositar(valorDeposito);
                        break;
                    case 3:
                        System.out.println("Digite o valor do saque:");
                        double valorSaque = scanner.nextDouble();
                        conta.sacar(valorSaque);
                        break;
                    case 4:
                        System.out.println("Encerrando...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while (opcao != 4);
        } else {
            System.out.println("Tipo de conta inválido!");
        }
        scanner.close();
        System.out.println("Obrigado por usar nosso serviço bancário.");
    }
}
