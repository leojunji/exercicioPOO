package exercicios;

/**Crie uma variável inteira com um valor qualquer e verifique se
 o valor desta  variável é menor que 15 ou maior que 100.*/

public class Exercicio20 {

    public static void main(String[] args) {



        int valorUm = 3;

        System.out.println("valorUm = " + valorUm);

        if (valorUm < 15) {

            System.out.println(valorUm + " é menor que 15");

        } else if (valorUm > 100) {

            System.out.println(valorUm + " é maior que 100");

        } else {

            System.out.printf("15 <= valorUm <= 100");
        }
    }
}
