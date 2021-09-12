package listaExercicios01_pensamentoMat;

import java.util.Scanner;

/**
 * Faça um programa em Java que permita ao usuário escolher a tabuada que deseja
 * ver. Mostrar a tabuada escolhida. (Comando for)*/

public class Exercicio3 {

    public static void main(String[] args) {

        String opcaoTabuada = "";
        Scanner input = new Scanner(System.in);

        System.out.println("Informe a tabuada que deseja ver: ");
        System.out.println(" * = mutiplicação");
        System.out.println("/ = divisão");
        opcaoTabuada = input.nextLine();

        //mutiplicção
        if(opcaoTabuada.equalsIgnoreCase("*")){

            for(int x= 1; x<=10; x++){
                for (int y = 1; y<=10; y++) {
                    System.out.println(x + " * " + y + " = " + (x*y));
                }
                System.out.println("==================");
            }
        }

        //divisao
        if(opcaoTabuada.equalsIgnoreCase("/")){

            for(int x= 1; x<=10; x++){
                for (int y = 1; y<=10; y++) {
                    System.out.println(x + " / " + y + " = " + (x/y));
                }
                System.out.println("==================");
            }
        }
    }
}
