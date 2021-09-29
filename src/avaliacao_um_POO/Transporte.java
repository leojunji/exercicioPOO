package avaliacao_um_POO;

public class Transporte {

    private boolean movimentando = false;


    public boolean isMovimentando() {
        return this.movimentando;
    }

    public void setMovimentando(boolean movimentando) {
        this.movimentando = movimentando;
    }

    public void linha(){
        System.out.println("===========");
    }

    public void acelerar() {

        if (this.movimentando) {

            System.out.println("já está em movimento");

        } else {

            System.out.println("Acelerando ");
            this.movimentando = true;
            System.out.println("Acelerado!!!");
        }
        linha();
    }

    public void frear() {

        if (!this.movimentando){

            System.out.println("já esta parado(a)");

        }else {

            System.out.println("Freiando ");
            this.movimentando = false;
            System.out.println("freiado");
        }

        linha();
    }

    public void receberPassageiro() {

        System.out.println("Passageiro recebido");
        linha();

    }



}
