package avaliacao_um_POO;


/*exercicio 2*/
public class usarTransporte {

    public static void main(String[] args) {

        Aviao aviao = new Aviao();

        aviao.levantarVoo();
        aviao.levantarVoo();
        aviao.pousar();
        aviao.pousar();
        aviao.receberPassageiro();


        Automovel automovel = new Automovel();

        automovel.abastecer();
        automovel.abastecer();
        automovel.passarMarcha();
        automovel.frear();

        Navio navio = new Navio();

        navio.afundar();
        navio.afundar();
        navio.ancorar();
        navio.ancorar();

        Ferrari ferrari = new Ferrari();

        ferrari.acelerar();
        ferrari.acelerar();

    }
}
