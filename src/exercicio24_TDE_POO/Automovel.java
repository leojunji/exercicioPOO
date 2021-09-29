package exercicio24_TDE_POO;

public class Automovel {

    protected boolean tanqueCheio = false;
    protected boolean carroMovimentando = false;
    protected boolean carroFreiado = false;
    protected String automovel = "automovel";

    public boolean isTanqueCheio() {
        return tanqueCheio;
    }

    public void setTanqueCheio(boolean tanqueCheio) {
        this.tanqueCheio = tanqueCheio;
    }

    public boolean isCarroMovimentando() {
        return carroMovimentando;
    }

    public void setCarroMovimentando(boolean carroMovimentando) {
        this.carroMovimentando = carroMovimentando;
    }

    public boolean isCarroFreiado() {
        return carroFreiado;
    }

    public void setCarroFreiado(boolean carroFreiado) {
        this.carroFreiado = carroFreiado;
    }

    public String getAutomovel() {
        return automovel;
    }

    public void setAutomovel(String automovel) {
        this.automovel = automovel;
    }

    public void nomearAutomovel(String nome){
        this.automovel = nome;
    }

    public static void linha(){
        System.out.println("===========");
    }
    public void abastecer() {

        if (this.tanqueCheio) {

            System.out.println("tanque do(a) " + this.automovel + " cheio");

        } else {

            System.out.println("Tanque vazio, abastecendo...");
            this.tanqueCheio = true;
            System.out.println("Tanque cheio!!!");

        }
        linha();
    }


    public void acelerar() {

        if (this.carroMovimentando) {

            System.out.println(this.automovel + " já está em movimento");

        } else {

            System.out.println("Acelerando " + this.automovel + "...");
            this.carroMovimentando = true;
            System.out.println(this.automovel +  " acelerando!!!");
        }
        linha();
    }

    public void frear() {

        if (this.carroFreiado){

            System.out.println(this.automovel + " já esta parado(a)");

        }else {

            System.out.println("Freiando " + this.automovel);
            this.carroFreiado = true;
            System.out.println(this.automovel + " freiado");
        }

        linha();
    }

}