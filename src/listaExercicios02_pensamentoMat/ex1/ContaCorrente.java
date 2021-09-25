package listaExercicios02_pensamentoMat.ex1;



public class ContaCorrente {

    private float saldoConta = 0.0f;
    //private float[] ultimoDeps = new float[2];
    //private float[] ultimoSaq = new float[2];



    public ContaCorrente() {
        this.saldoConta = 0;
    }

    public ContaCorrente(float saldoConta) {
        this.saldoConta = saldoConta;
    }





    public float getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(float saldoConta) {
        this.saldoConta = saldoConta;
    }


    private void imprimirOperacao(float saldoFinal, float valor, String mostrar) {



        if (mostrar.equals("saque")) {
            float saldoAnterior = this.saldoConta + valor;
            System.out.println("===ULTIMO SAQUE===");
            System.out.println("Saldo inicial: R$ " + saldoAnterior);
            System.out.println(" - " + valor);

        }else if (mostrar.equals("deposito")) {

            float saldoAnterior = this.saldoConta - valor;
            System.out.println("===ULTIMO DEPOSITO===");
            System.out.println("Saldo inicial: R$ " + saldoAnterior);
            System.out.println(" + " + valor);

        }

        System.out.println("Saldo final: R$ " + saldoFinal);
        System.out.println("===============");

    }





    public void depositar(float valorDeposito) {

        this.saldoConta += valorDeposito;

        imprimirOperacao(saldoConta, valorDeposito, "deposito");


    }


    public void sacar(float valorSaque) {


        if (valorSaque <= this.saldoConta) {

            this.saldoConta -= valorSaque;
            imprimirOperacao(this.saldoConta, valorSaque, "saque");

        } else {

            System.out.println("Saldo insuficiente!!!");
            System.out.println("===============");

        }


    }


}
