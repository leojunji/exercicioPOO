package listaExercicios01_pensamentoMat;

import java.util.Scanner;

/**
 * Um motorista parou no posto de gasolina, comprou dois refrigerantes e abasteceu o
 * seu carro com gasolina. Leia a quantidade de litros de gasolina foram necessários
 * para abastecer o veículo e informe o valor total da conta desse cliente, sabendo-se
 * que cada refrigerante custou R$3,00 e o litro de gasolina está custando R$2,50.
 * (Estrutura Sequencial).*/

public class Exercicio5 {

    public static void main(String[] args) {

        float precoGasolina = 2.5f;
        float precoRefrigerante = 3.0f;
        float litrosGasolina = 0.0f;
        int quantRefrigerantes = 0;
        Scanner input = new Scanner(System.in);
        float subtotalGasolina = 0.0f;
        float subtotalRefrigerante = 0.0f;

        System.out.println("Informe a quantidade de listros de gasolina: ");
        litrosGasolina = input.nextFloat();
        System.out.println("Informe a quantidade de refrigerantes: ");
        quantRefrigerantes = input.nextInt();

        subtotalGasolina = litrosGasolina  * precoGasolina;
        subtotalRefrigerante = quantRefrigerantes  * precoRefrigerante;

        float valorTotal =  (subtotalGasolina+subtotalRefrigerante);

        System.out.println("Subtotal gasolina: " + subtotalGasolina);
        System.out.println("Subtotal refrigerante: " + subtotalRefrigerante);
        System.out.println("Valor total: " + valorTotal);



    }
}
