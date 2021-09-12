package exercicios_TDE_POO;

import java.util.Scanner;


/**
 * Declare três variáveis com tipos diferentes,sem atribuir valor.
 * Depois atribua  um valor qualquer a elas com dados digitados pelo usuário. */

public class Exercicio13 {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int valorUm;
        float valorDois;
        String valorTres;



        System.out.println("Valor 1(int): ");
        valorUm = input.nextInt();

        System.out.println("Valor 2(float): ");
        valorDois = input.nextFloat();

        System.out.println("Valor 3(string): ");
        valorTres = input.next();
    }
}
