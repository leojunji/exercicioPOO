package exercicios;

import java.util.Scanner;

/**Determine a quantidade de homens e mulheres (separadamente) que são
 maiores de idade, baseado na leitura de dados de 10 pessoas.*/


public class Exercicio28 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        int[] dadosMasc = new int[2];
        int[] dadosFem = new int[2];
        int genero, idade;

        for (int c = 1;c <= 10;c++){

            System.out.println("[" + c + "]");

            System.out.println("Homem[1]\nMulher[2]");
            System.out.print("Digite seu genêro[1/2]: ");

            genero = input.nextInt();

            System.out.print("Digite sua idade: ");

            idade = input.nextInt();

            System.out.println("========");

            if (genero==1){

                dadosMasc[0] += 1;

                if (idade>=18){

                    dadosMasc[1] += 1;

                }
            } else if (genero==2) {

                dadosFem[0] += 1;

                if (idade>=18){

                    dadosFem[1] += 1;

                }
            }

        }



        System.out.printf("Quantidade de mulher: %s, quantidade de mulheres +18: %s\n", dadosFem[0], dadosFem[1]);

        System.out.printf("Quantidade de homem: %s, quantidade de homem +18: %s\n",dadosMasc[0], dadosMasc[1]);



    }

}
