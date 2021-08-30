package exercicios;


/**Escreva um programa que imprima na tela a soma dos números ímpares
 entre 0 e 30 e a multiplicação dos números pares entre 0 e 30.*/


public class Exercicio25 {

    public static void main(String[] args) {



        int numPar = 1;
        int numImpar = 0;



        for (int c = 1;c <= 30;c++){
            if ((c%2)==0) {
                numPar = numPar * c;
            }else{
                numImpar += c;
            }
        }

        System.out.println(numPar);
        System.out.println(numImpar);

    }
}
