package listaExercicios01_pensamentoMat;

import java.util.Scanner;

/**
 * Uma empresa decidiu dar 20% de aumento aos funcionários cujos salários são
 * inferiores a 500 reais. Escreva um programa que leia o salário de vários funcionários
 * se mostre o valor do salário reajustado ou uma mensagem caso o funcionário não
 * tenha direito ao aumento. O programa será encerrado quando se digitar “fim” para o
 * nome do funcionário. (Comando while)*/

public class Exercicio4 {

    public static void main(String[] args) {

        float salario = 0;
        float novoSalario = 0;
        float percentualAumento = 0.2f;
        String nomeFuncionario = "";
        Scanner input = new Scanner(System.in);

        while (true){

            System.out.println("Informe o nome do funcionário: ");
            nomeFuncionario = input.nextLine();

            if (nomeFuncionario.equalsIgnoreCase("Fim")) {
                System.out.println("Programa encerrado, até mais!!!!!");
                System.exit(0);
            }

            System.out.println("Informe o valor do salário: ");
            salario = Float.parseFloat(input.nextLine());

            if (salario <= 500){

                salario = salario + (salario*percentualAumento);

                System.out.println("Nome funcionário: " + nomeFuncionario);
                System.out.println("Salário antigo: " + salario);
                System.out.println("Novo salário: " + novoSalario);

            }else {

                System.out.println("O valor não foi comteplado para aumento, deve ser inferior a 500,00");

            }

        }

    }

}
