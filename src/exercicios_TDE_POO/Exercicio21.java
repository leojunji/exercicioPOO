package exercicios_TDE_POO;


/**Crie uma variável com valor de ponto flutuante com um valor
 *qualquer e  verifique se o valor desta variável está entre 1.99 e 5.99. */

public class Exercicio21 {

    public static void main(String[] args) {



        float valorUm = 3f;

        System.out.println("valorUm = " + valorUm);

        if (valorUm >= 1.99f & 5.99f >= valorUm) {

            System.out.println("1.99 <= valorUm <= 5.99");

        }
    }
}
