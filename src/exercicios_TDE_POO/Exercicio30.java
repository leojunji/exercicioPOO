package exercicios_TDE_POO;

import java.util.Scanner;

/**Modifique o programa anterior para que o sistema imprima uma mensagem
 de alerta quando o valor a ser pago ao funcionário seja inferior a R$ 50,00:
 "Atenção, dirija- se à direção do Hotel!".*/

public class Exercicio30 {

    public static void main(String[] args) {



        Scanner input = new Scanner(System.in);


        System.out.print("Quantas horas você trabalhou: ");
        int horasTrabalhadas = input.nextInt();

        float pagamento = horasTrabalhadas*10.25f;

        System.out.println("Por " + horasTrabalhadas +  " horas trabalhadas, você receberá R$" + pagamento);

        if (pagamento<50){
            System.out.println("Atenção, dirija- se à direção do Hotel!");
        }

    }
}
