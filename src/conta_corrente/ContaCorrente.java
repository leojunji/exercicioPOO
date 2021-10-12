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
        assert  this.saldo >= 0;
        return this.saldo;
    }

    public void depositaValor(double deposito){
        this.saldo += deposito;
    }

    public void retiraSaldo(double saque){
        verificarSaldo();
        this.saldo -= saque;
    }

    public void imprimeConta(){

        System.out.println("Numero: " +this.numero);

        System.out.println("Cliente: " + this.cliente.getNome());

        System.out.println("Saldo: R$ " + this.saldo);
    }
}
