package exercicios_TDE_POO;

import java.util.Scanner;

/**.Faça um programa para ler um número do teclado e imprimir na tela se ele é
 par ou ímpar. Imprima também se ele é primo.*/

public class Exercicio27{


    public static void main(String[] args) {


        Metodos mtd = new Metodos();
        Scanner input = new Scanner(System.in);


        System.out.println("Digite um valor[int]: ");
        int valor = input.nextInt();


        System.out.print(valor);

        if (valor % 2 == 0) {

            System.out.print(" é par");

        } else {

            System.out.print(" é impar");

        }

        if (mtd.verificarPrimo(valor)){

            System.out.print(" e primo");

        }
    }
}

