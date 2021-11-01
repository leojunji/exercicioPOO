package conta_corrente;

import java.util.ArrayList;

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

        Banco banco = new Banco("MeuBanco&Cia.");



        banco.addCliente  (new Cliente ("Maria", 123));

        banco.addCliente  (new Cliente ("Jose",  456));

        banco.addCliente  (new Cliente ("Joao",  789));



        System.out.println("*** BANCO " + banco.nome + " - OPERACOES ***");

        for (Cliente cliente : banco.clientes) {//Iterador

            System.out.println("\nCliente " + cliente.getNome() + " - operacoes");

            cliente.opera();

        }



        System.out.println("\n*** BANCO " + banco.nome + "- CLIENTES ***");

        for (Cliente cliente: banco.clientes) { //Iterador

            cliente.getConta().imprimeConta();

        }

    }





}
