package listaExercicios02_POO.ex3;



public class Main {

    public static void main(String[] args) {

        Relogio relogio = new Relogio("12:00");

        relogio.proximoMinuto();
        relogio.proximoMinuto();
        relogio.imprimirHora();

        System.out.println("=========");

        relogio.imprimirUmDia();


    }
}
