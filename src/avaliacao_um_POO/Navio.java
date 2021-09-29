package avaliacao_um_POO;

public class Navio extends Transporte{

    private boolean afundado = false;
    private boolean ancorado = false;

    public boolean isAfundado() {
        return afundado;
    }

    public void setAfundado(boolean afundado) {
        this.afundado = afundado;
    }

    public boolean isAncorado() {
        return ancorado;
    }

    public void setAncorado(boolean ancorado) {
        this.ancorado = ancorado;
    }

    public void afundar() {

        if (this.afundado) {

            System.out.println("navio ja esta afundado");
        }
        else {

            this.afundado = true;
            System.out.println("afundado");
        }
        linha();
    }

    public void ancorar() {

        if (this.ancorado) {

            System.out.println("navio ja esta ancorado");
        }
        else {

            this.ancorado = true;
            System.out.println("navio ancorado");
        }

        linha();

    }
}
