package listaExercicios01_pensamentoMat;

import java.util.Scanner;

/**
 * Faça um programa que receba o valor do salário de um funcionário e o percentual
 * de aumento, calcule e mostre o valor do aumento e o novo salário.*/

public class Exercicio1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        float valorSalario = 0;
        float percentualAumento = 0;
        float valorAulmento = 0;
        float novoSalario = 0;

        System.out.println("Informe o valor do salário: ");
        valorSalario = input.nextFloat();

        System.out.println("Informe o percentual de aumento: ");
        percentualAumento = input.nextFloat();

        valorAulmento  = (valorSalario * percentualAumento)/100;
        novoSalario = valorSalario + valorAulmento;


        System.out.println("Valor salário: " + valorSalario);
        System.out.println("% aumento " + percentualAumento);
        System.out.println("Valor aumento: " + valorAulmento);
        System.out.println("Novo salário: " + novoSalario);






    }
}
