package avaliacao_um_POO;

public class Aviao extends Transporte{

    private boolean voando = false;

    public boolean isVoando() {
        return voando;
    }

    public void setVoando(boolean voando) {
        this.voando = voando;
    }

    public void levantarVoo() {

        if (this.voando) {

            System.out.println("aviao ja esta voando");
        }
        else {

            System.out.println("Levantando voo");
            this.voando = true;
            System.out.println("Voando");
        }

        linha();
    }

    public void pousar(){

        if (!this.voando) {

            System.out.println("aviao ja esta pousado");
        }
        else {

            System.out.println("Pousando");
            this.voando = false;
            System.out.println("Pousado!!!");
        }

        linha();
    }
}
