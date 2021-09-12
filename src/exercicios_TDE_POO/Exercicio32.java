package exercicios_TDE_POO;

import java.util.Scanner;


/**
 * Implemente um programa para calcular a área de um trapézio, onde:
 h = altura
 b = base menor
 B = base maior
 Área = (h . (b + B)) / 2*/


public class Exercicio32 {

    public static void main(String[] args) {



        Scanner input = new Scanner(System.in);


        System.out.println("Altura: ");
        float h = input.nextFloat();

        System.out.println("Base menor(b): ");
        float bMenor = input.nextFloat();

        System.out.println("Base maior(B): ");
        float bMaior = input.nextFloat();

        float area = ((h * (bMenor + bMaior)) / 2);

        System.out.printf("Um trapézio de altura %s, base Menor %s e base maior %s,\n", h, bMenor, bMaior);
        System.out.println("tem área de: " + area + " m^2");

    }
}
