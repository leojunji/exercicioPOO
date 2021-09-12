package exercicios_TDE_POO;

import java.util.ArrayList;

/*Faça um programa para imprimir os números primos de 1 a 123*/

public class Exercicio26 {

    /**se o valor for primo vair retornar true
     * se o valor não for primo vai retornar false*/


    public static void main(String[] args) {

        Metodos mtd = new Metodos();


        ArrayList <Integer> lstNumPrimos = new ArrayList<>();

        for (int c = 1;c <= 123;c++) {

            if(mtd.verificarPrimo(c)){

                lstNumPrimos.add(c);

            }

        }


        System.out.println("Lista de números primos(1-123): ");
        System.out.println(lstNumPrimos);
    }
}
