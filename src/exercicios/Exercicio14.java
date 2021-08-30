package exercicios;

import java.util.Scanner;

/**
 Crie uma variável do tipo int, atribuindo um valor a ela.
 Depois crie uma  variável do tipo double, atribuindo a ela o valor da primeira variável criada. */

public class Exercicio14 {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        int valorUm = 10;
        double valorDois = valorUm;


        System.out.printf("valorUm(int) %s valorDois(double) %s", valorUm, valorDois);
    }
}
