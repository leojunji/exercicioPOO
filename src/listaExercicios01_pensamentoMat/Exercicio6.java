package listaExercicios01_pensamentoMat;

import java.util.Scanner;

/**
 * A prefeitura de Curitiba abriu uma linha de crédito para os funcionários municipais.
 * O valor máximo da prestação não poderá ultrapassar 30% do salário bruto. Fazer
 * um algoritmo que permita entrar com o salário bruto e o valor da prestação e informar
 * se o empréstimo pode ou não ser concedido. (comando if)*/

public class Exercicio6 {

    public static void main(String[] args) {

        float percentualMaximo = 0.3f;
        float valorPrestacao = 0.0f;
        float valorSalario = 0.0f;
        Scanner input = new Scanner(System.in);

        System.out.println("Informe o valor do salário :");
        valorSalario = input.nextFloat();

        System.out.println("Informe o valor da prestação: ");
        valorPrestacao = input.nextFloat();

        if (valorPrestacao<=(valorSalario*percentualMaximo)){

            System.out.println("Empréstimo aceito!!!!");

        }else{

            System.out.println("Empréstismo negado.");

        }

    }
}
