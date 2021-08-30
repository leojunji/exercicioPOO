package exercicios;

import java.util.Scanner;


/**Imprima na tela (console) o número de caracteres da String. */


public class Exercicio17 {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        String textoUser;

        System.out.println("Digite o texto: ");
        textoUser = input.nextLine();


        System.out.println("Texto digitado pelo usuário --> " + textoUser);
        textoUser = textoUser.replace(" ", "");
        System.out.println(textoUser.strip().length());
    }
}

