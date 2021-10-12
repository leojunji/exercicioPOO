package conta_corrente;

public class Cliente {

    private String nome = "";
    private ContaCorrente conta;

    public Cliente(String nome, int numero) {
        this.nome = nome;
        this.conta = new ContaCorrente(numero);
        this.conta.setCliente(this);

    }

    public String getNome() {
        return nome;
    }

    public ContaCorrente getConta() {
        return conta;
    }

    public void opera(){

    }
}
