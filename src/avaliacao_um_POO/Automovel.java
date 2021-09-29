package avaliacao_um_POO;

public class Automovel extends Transporte{

    private boolean tanqueCheio = false;

    public boolean isTanqueCheio() {
        return tanqueCheio;
    }

    public void setTanqueCheio(boolean tanqueCheio) {
        this.tanqueCheio = tanqueCheio;
    }


    public void abastecer() {

        if (this.tanqueCheio) {

            System.out.println("o tanque ja esta cheio");

        } else {

            System.out.println("Tanque vazio, abastecendo...");
            this.tanqueCheio = true;
            System.out.println("Tanque cheio!!!");

        }
        linha();
    }

    public void passarMarcha() {

        System.out.println("Passando marcha");
        linha();

    }

}
