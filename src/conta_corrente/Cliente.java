package conta_corrente;

import java.util.Scanner;

public class Cliente {

    private String nome = "";
    private ContaCorrente conta;

    public Cliente(String nome, int numeroContaCorrente) {
        this.nome = nome;
        this.conta = new ContaCorrente(numeroContaCorrente);
        //setCliente(Cliente cliente) --> this e do Cliente
        this.conta.setCliente(this);

    }

    public String getNome() {
        return nome;
    }

    public ContaCorrente getConta() {
        return conta;
    }

    public void opera (){

        Scanner ler = new Scanner(System.in);

        double valor;

        //Leitura do teclado

        System.out.print ("** Entre um valor de deposito: R$ ");

        valor = ler.nextDouble();

        conta.depositaValor(valor);



        System.out.print  ("** Entre um valor de saque:    R$ ");

        valor = ler.nextDouble();

        conta.retiraValor(valor);

    }
}
