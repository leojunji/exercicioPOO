package exercicios_TDE_POO;

import java.util.Scanner;

/**Concatene na variável criada acima a frase “ – Exemplo String”.   */


public class Exercicio16 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String textoUser;

        System.out.println("Digite o texto: ");
        textoUser = input.nextLine();

        textoUser += "-Exemplo String";

        System.out.println("Texto digitado pelo usuário --> " + textoUser);

    }
}
