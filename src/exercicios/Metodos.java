package exercicios;

public class Metodos {

    public boolean verificarPrimo(int valor){


        boolean valorPrimo = valor != 1 && valor != 0;

        for (int c = 2;c < valor;c++) {

            if ((valor%c)==0){
                valorPrimo = false;
                break;
            }

        }

        return valorPrimo;
    }
}
