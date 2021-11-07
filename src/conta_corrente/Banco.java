package conta_corrente;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco {

    private String nome = "";//nome do banco
    private ArrayList<Cliente> clientes;

    public Banco(String nome) {
        this.nome = nome;
        clientes = new ArrayList<Cliente>();
    }

    public void addCliente(Cliente c){
        this.clientes.add(c);
    }

    public String getNome() {
        return nome;
    }

    public void ligarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        int opcao = 5;

        String nome_banco = "MeuBanco&Cia.";

        Banco banco = new Banco(nome_banco);

        while(true){

            menuPrincipal();

            opcao = Integer.parseInt(leitor.nextLine());

            switch (opcao){

                case 1 : {

                    String nome;

                    int numeroConta;

                    System.out.println("Informe o nome ");

                    nome = leitor.nextLine();

                    System.out.println("Informe o número conta ");

                    numeroConta = Integer.parseInt(leitor.nextLine());

                    boolean adicionar = true;



                    for (Cliente dado : banco.clientes) {

                        if(dado.getNome().equals(nome) & dado.getConta().getNumero()==numeroConta){
                            adicionar = false;
                        }

                    }

                    if(adicionar) {
                        banco.addCliente(new Cliente(nome, numeroConta));
                    }else{
                        System.out.println("Usuario ja existe");
                    }

                    break;

                }

                case 2 : {

                    System.out.println("Informe o numero da conta corrente: ");
                    int conta = Integer.parseInt(leitor.nextLine());
                    Cliente clienteAchado = null;


                    for(Cliente clienteBusca : banco.clientes){

                        if(clienteBusca.getConta().getNumero() == conta){

                            clienteAchado = clienteBusca;
                            break;
                        }
                    }
                    if(clienteAchado!=null){

                        clienteAchado.getConta().imprimeConta();
                    }else{

                        System.out.println("Conta corrente não econtrada com o número: " + conta);
                    }

                    break;

                }


                case 3 : {

                    System.out.println("Informe o numero da conta corrente: ");
                    int conta = Integer.parseInt(leitor.nextLine());

                    boolean operacao_realizada = false;


                    for(Cliente cliente : banco.clientes) {

                        if(cliente.getConta().getNumero()==conta) {

                            operacao_realizada = true;

                            System.out.println("Digite o valor a ser sacado: ");

                            double valor = Double.parseDouble(leitor.nextLine());

                            if (valor > 0) {
                                cliente.getConta().retiraValor(valor);
                                break;
                            } else {
                                System.out.println("Não foi possível realizar o saque, digite um valor positivo");
                                break;
                            }
                        }
                    }

                    if(!operacao_realizada)
                        System.out.println("Usuário não encontrado");

                    break;

                }


                case 4 : {

                    System.out.println("Informe o numero da conta corrente: ");
                    int conta = Integer.parseInt(leitor.nextLine());

                    boolean operacao_realizada = false;


                    for(Cliente cliente : banco.clientes) {

                        if(cliente.getConta().getNumero()==conta) {

                            operacao_realizada = true;

                            System.out.println("Digite o valor a ser depositado: ");

                            double valor = Double.parseDouble(leitor.nextLine());

                            if (valor > 0) {
                                cliente.getConta().depositaValor(valor);
                                break;
                            } else {
                                System.out.println("Não foi possível realizar o deposito, digite um valor positivo");
                                break;
                            }
                        }
                    }

                    if(!operacao_realizada)
                        System.out.println("Usuário não encontrado");

                    break;
                }

                case 5 : {


                    for(Cliente cliente : banco.clientes){

                        cliente.getConta().imprimeConta();
                        System.out.println("=============");
                    }

                    break;

                }

                case 6 : {

                    System.out.println("Até mais volte sempre!!!");

                    System.exit(0);
                }

                default:{

                    System.out.println("Opção não existe");


                }

            }



        }


    }

    public static void menuPrincipal(){

        System.out.println("Menu de Opções :");

        System.out.println("1 : Cadastrar Cliente");

        System.out.println("2 : Consultar Cliente");

        System.out.println("3 : Sacar ");

        System.out.println("4 : Depositar ");

        System.out.println("5 : Listar ");

        System.out.println("6 : Sair ");

    }


    public static void fazerLogin(String nome_banco){

        Scanner leitor  = new Scanner(System.in);

        Banco banco = new Banco(nome_banco);

        System.out.println("Informe a conta corrente: ");
        int conta = Integer.parseInt(leitor.nextLine());
        Cliente clienteAchado = null;


        for(Cliente clienteBusca : banco.clientes){

            if(clienteBusca.getConta().getNumero() == conta){

                clienteAchado = clienteBusca;
                break;
            }
        }
        if(clienteAchado!=null){

            clienteAchado.getConta().imprimeConta();
        }else{

            System.out.println("Conta corrente não econtrada com o número: " + conta);
        }

    }




}
