package conta_corrente;

public class ContaCorrente {

    private int numero;
    private double saldo;
    private Cliente cliente;

    public ContaCorrente(int numero) {
        this.numero = numero;
        this.saldo = 0.0d;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double verificarSaldo(){

        //se for maior que zero ele continua, se for menor que zero ele mostra a mensagem
        assert  this.saldo > 0 : "Erro saldo negativo";
        return this.saldo;
    }

    public void depositaValor(double deposito){

        this.saldo += deposito;
        verificarSaldo();
    }

    public void retiraValor(double saque){

        this.saldo -= saque;
        verificarSaldo();
    }

    public void imprimeConta(){

        System.out.println("Numero: " +this.numero);

        System.out.println("Cliente: " + this.cliente.getNome());

        System.out.println("Saldo: R$ " + this.saldo);
    }
}
