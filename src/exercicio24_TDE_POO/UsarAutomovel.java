package exercicio24_TDE_POO;

public class UsarAutomovel {

    public static void main(String[] args) {

        Carro carro = new Carro();
        Moto moto = new Moto();
        Ferrari ferrari = new Ferrari();
        Fusca fusca = new Fusca();

        //automovel.nomearAutomovel("Fit");
        carro.abastecer();

        moto.nomearAutomovel("Kawazaki");
        moto.acelerar();

        ferrari.nomearAutomovel("Ferrari");
        ferrari.acelerar();
        ferrari.acelerar();


        fusca.nomearAutomovel("Fusca");
        fusca.frear();


    }
}
