package exercicios;

import java.util.Scanner;

/**
 Implemente um programa que receba dados
 digitados pelo usuário e atribua  a uma variável do tipo String
 e imprima a frase inserida no console.  */


public class Exercicio15_16 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String textoUser;

        System.out.println("Digite o texto: ");
        textoUser = input.nextLine();

        System.out.println("Texto digitado pelo usuário --> " + textoUser);
    }
}
