package listaExercicios01_pensamentoMat;

import java.util.Scanner;

/**
 * Faça um programa que leia 10 números inteiros e exiba na tela a mensagem ‘Par’
 * se ele for um número par, ou ‘Ímpar’ se ele for um número ímpar. (Comando if).*/

public class Exercicio2 {

    public static void main(String[] args) {

        int contador = 0;
        int valor = 0;
        Scanner input = new Scanner(System.in);

        while (contador < 10){

            System.out.println("Informe o valor a ser verificado: ");
            valor = input.nextInt();

            if (valor%2==0){

                System.out.println("Valor " + valor + " é par");
            }else{

                System.out.println("valor " + valor + " é ímpar");
            }

            contador++;

        }

    }
}
