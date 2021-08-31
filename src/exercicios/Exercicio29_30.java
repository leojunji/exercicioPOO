package exercicios;

import java.util.Scanner;

/**
 * O valor pago por um Hotel da Praia de Iracema para seus porteiros é de R$ 10,25
 * por hora de trabalho. Faça um programa que pergunte ao usuário
 * quantas horas ele trabalhou e imprima na tela o valor do salário a ser recebido
 * por ele. */


public class Exercicio29_30 {

    public static void main(String[] args) {



        Scanner input = new Scanner(System.in);


        System.out.print("Quantas horas você trabalhou: ");
        int horasTrabalhadas = input.nextInt();

        float pagamento = horasTrabalhadas*10.25f;

        System.out.println("Por " + horasTrabalhadas +  " horas trabalhadas, você receberá R$" + pagamento);

    }
}
