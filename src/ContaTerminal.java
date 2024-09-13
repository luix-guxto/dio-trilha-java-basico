import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaTerminal{
    public static void main(String[] args){
        Conta conta;

        System.out.println("Qual seu nome completo?");
        boolean confirmedName = false, confirmedSaldo = false, confirmedNumero = false, confirmedAgencia = false;

        String nome = "";
        while(!confirmedName){
            nome = new Scanner(System.in).nextLine();

            System.out.println("Seu nome é '"+nome+"' correto?\n1 - Confirmar\n2 - Recusar");
            
            confirmedName = correto();
            if(!confirmedName)
                System.out.println("Qual seu nome completo?");
        }

        System.out.println("Qual o numero da sua conta?");
        int numero = 0;
        while(!confirmedNumero){
            try{
                numero = new Scanner(System.in).nextInt();
            }catch(InputMismatchException e){
                System.out.println("Formato invalido, informar um numero!\ntente novamente!");
                System.out.println("\nQual o numero da sua conta?");
                numero =0;
                continue;
            }

            System.out.println("O numero da sua conta é: '"+numero+"' correto?\n1 - Confirmar\n2 - Recusar");
            
            confirmedNumero = correto();
            if(!confirmedNumero)
            System.out.println("Qual o numero da sua conta?");
        }

        System.out.println("Qual o numero da sua agencia?");
        int agencia = 0;
        while(!confirmedAgencia){
            try{
                agencia = new Scanner(System.in).nextInt();
            }catch(InputMismatchException e){
                System.out.println("Formato invalido, informar um numero!\ntente novamente!");
                System.out.println("\nQual o numero da sua agencia?");
                agencia =0;
                continue;
            }

            System.out.println("O numero da sua agencia é: '"+agencia+"' correto?\n1 - Confirmar\n2 - Recusar");
            
            confirmedAgencia = correto();
            if(!confirmedAgencia)
            System.out.println("Qual o numero da sua agencia?");
        }

        System.out.println("Qual seu saldo atual na conta?");
        double saldo = 0.0;
        while(!confirmedSaldo){
            try{
                saldo = new Scanner(System.in).nextInt();
            }catch(InputMismatchException e){
                System.out.println("Formato invalido, informar um numero!\ntente novamente!");
                System.out.println("\nQual seu saldo atual na conta?");
                saldo =0;
                continue;
            }

            System.out.println("O seu saldo atual é: R$ "+saldo+" correto?\n1 - Confirmar\n2 - Recusar");
            
            confirmedSaldo = correto();
            if(!confirmedSaldo)
            System.out.println("Qual seu saldo atual na conta?");
        }
        conta = new Conta(numero, agencia, saldo, nome);

        System.out.println("Obrigado por realizar o cadastro no ContaTerminal!");
        System.out.println(conta.dados());

        System.out.println("Deseja realizar alguma operação?\n1 - Confirmar\n2 - Recusar");
        if(correto()){
            boolean operacaoOcorrendo = true;
            while(operacaoOcorrendo){
                System.out.println("Qual operação deseja fazer?\n1 - Sacar\n2 - Depositar\n3 - Ver Saldo\n4 - Ver dados bancarios\n5 - Finalizar");
                int opt = 0;
                boolean continuar = true;
                while(continuar){
                    try {
                        opt = new Scanner(System.in).nextInt();
                    } catch (InputMismatchException e) {
                        opt = -1;
                    }
                    switch (opt) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            continuar = false;
                            break;
                        default:
                            System.out.println("Opção invalida!");
                            System.out.println("1 - Sacar\n2 - Depositar\n3 - Ver Saldo\n4 - Ver dados bancarios\n5 - Finalizar");
                    }
                }
                switch (opt) {
                    case 1://sacar
                        boolean confirmedSaque = false;
                        double saque = 0;
                        System.out.println("Quanto deseja sacar?");
                        while(!confirmedSaque){
                            try{
                                saque = new Scanner(System.in).nextInt();
                            }catch(InputMismatchException e){
                                System.out.println("Formato invalido, informar um numero!\ntente novamente!");
                                System.out.println("\nQuanto deseja sacar?");
                                saque =0;
                                continue;
                            }
                
                            System.out.println("Você deseja sacar R$ "+saque+" correto?\n1 - Confirmar\n2 - Recusar");
                            
                            confirmedSaque = correto();
                            if(!confirmedSaque)
                            System.out.println("Quanto deseja sacar?");
                        }
                        conta.sacar(saque);
                    break;
                    case 2://depositar
                        boolean confirmedDeposito = false;
                        double deposito = 0;
                        System.out.println("Quanto deseja depositar?");
                        while(!confirmedDeposito){
                            try{
                                deposito = new Scanner(System.in).nextInt();
                            }catch(InputMismatchException e){
                                System.out.println("Formato invalido, informar um numero!\ntente novamente!");
                                System.out.println("\nQuanto deseja depositar?");
                                deposito =0;
                                continue;
                            }
                
                            System.out.println("Você deseja depositar R$ "+deposito+" correto?\n1 - Confirmar\n2 - Recusar");
                            
                            confirmedDeposito = correto();
                            if(!confirmedDeposito)
                            System.out.println("Quanto deseja depositar?");
                        }
                        conta.depositar(deposito);
                    break;
                    case 3://Saldo
                        conta.saldo();
                    break;
                    case 4:
                        conta.dadosConta();
                        break;
                    case 5://Sair
                        System.out.println("Obrigado por usar o ContaTerminal");
                        System.exit(0); 
                    break;
                }
                System.out.println("Deseja realizar outra operação?\n1 - Sim\n2 - Não");
                int ope = -1;
                boolean oper = false;
                while(!oper){
                    try{
                        ope = new Scanner(System.in).nextInt();
                    }catch(InputMismatchException e){
                        System.out.println("Opção invalida!");
                        System.out.println("Deseja realizar outra operação?\n1 - Sim\n2 - Não");
                        ope =0;
                        continue;
                    }
                    switch (ope) {
                        case 1:
                            oper = true;
                            break;
                        case 2:
                            System.out.println("Obrigado por usar o ContaTerminal");
                            System.exit(0);
                        break;
                        default:
                        System.out.println("Opção invalida!");
                        System.out.println("Deseja realizar outra operação?\n1 - Sim\n2 - Não");
                    }
                    
                }
            }
            
        }
    }

    private static boolean correto(){
        while(true){
            int opt;
            try {
                opt = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                opt = 3;
            }
            switch (opt) {
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    System.out.println("Opção invalida!");
                    System.out.println("1 - Confirmar\n2 - Recusar");
            }
        }
    }


}

class Conta{
    private final int numero, agencia;
    private double saldo;
    private final String nome;

    public Conta(int numero, int agencia, double saldo, String nome){
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.nome = nome;
    }

    public void sacar(double valor){
        if(valor > this.saldo){
            System.out.println("Saldo insuficiente");
        }else{
            this.saldo -= valor;
            System.out.println("valor sacado com sucesso!");
        }
        this.saldo();
    }

    public void depositar(double valor){
        this.saldo +=valor;
        System.out.println("valor depositado com Sucesso!");
        this.saldo();
    }

    public void saldo(){
        System.out.println("Seu saldo atual é de R$ "+this.saldo);
    }

    public String dados(){
        return "Olá "+this.nome+", obrigado por criar uma conta em nosso banco, sua agência é "+this.agencia+", conta "+this.numero+" e seu saldo R$ "+this.saldo+" já está disponível para saque.";
    }

    public void dadosConta(){
        System.out.println("Esses são seus dados bancarios!");
        System.out.println("Nome: "+this.nome);
        System.out.println("Conta: "+this.numero+"-"+this.agencia);
    }

}