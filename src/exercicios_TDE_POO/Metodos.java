package exercicios_TDE_POO;

public class Metodos {



    /**Verifica se o valor é primo ou não
     * @author Leonardo Junji Mukuno
     * @param valor --> essa variável irá receber um número para ser verificado se é primo ou não
     * @return se o número recebido for primo vai retornar true senão irá retornar false
     * Se o valor for 1, 0, ou 2 o for não irá iniciar, sendo que se o a variável valor for 1 ou 0
     * vai retornar false, mas se for 2 vai retornar true*/
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
