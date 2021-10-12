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

        Scanner ler = new Scanner(System.in);
        Cliente[] lst_clientes = new Cliente[3];
        ContaCorrente[] lst_contas = new ContaCorrente[3];

        Banco banco = new Banco("MeuBanco&Cia.");

        lst_clientes[0] = new Cliente("Maria", 123);
        lst_clientes[1] = new Cliente("Jose", 456);
        lst_clientes[2] = new Cliente("Joao", 789);

        banco.ligarCliente(lst_clientes[0]);
        banco.ligarCliente(lst_clientes[1]);
        banco.ligarCliente(lst_clientes[2]);

        lst_contas[0] = new ContaCorrente(123);
        lst_contas[1] = new ContaCorrente(456);
        lst_contas[2] = new ContaCorrente(789);

        lst_contas[0].setCliente(lst_clientes[0]);
        lst_contas[1].setCliente(lst_clientes[1]);
        lst_contas[2].setCliente(lst_clientes[2]);


        for(int c = 0;c < 3;c++){

            System.out.println("Banco " + banco.getNome());
            System.out.println("Cliente: " + lst_clientes[c].getNome());

            System.out.print("Digite o valor do deposito: ");
            double valorD = ler.nextDouble();

            lst_contas[c].depositaValor(valorD);

            System.out.print("Digite o valor do saque: ");
            double valorS = ler.nextDouble();

            lst_contas[c].retiraSaldo(valorS);

            System.out.println();


        }

        for(ContaCorrente dado : lst_contas){
            dado.imprimeConta();
            System.out.println();
        }









    }


}
