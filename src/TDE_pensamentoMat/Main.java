package TDE_pensamentoMat;

import TDE_pensamentoMat.TabelaVerdade;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int linhas = 4;

        boolean[] p = TabelaVerdade.atribuicaoValoresVariavel(linhas,2);
        boolean[] q = TabelaVerdade.atribuicaoValoresVariavel(linhas,1);
        boolean[] implicacao = TabelaVerdade.compararTabelas(p,q, "->");
        boolean[] conjuncao = TabelaVerdade.compararTabelas(p,q, "&");
        boolean[] disjuncao = TabelaVerdade.compararTabelas(p,q, "or");
        boolean[] bicondicional = TabelaVerdade.compararTabelas(p,q, "<->");

        System.out.println("Tabela verdade: ");
        System.out.println("p\t\tq\t\t~p\t\t~q\t\tp->q\tp^q\t\tpvq\t\tp<->q");
        for(int i = 0; i < linhas; i++){
            System.out.print(p[i] +"\t");
            System.out.print(q[i] +"\t");
            System.out.print(!p[i] +"\t");
            System.out.print(!q[i] +"\t");
            System.out.print(implicacao[i] +"\t");
            System.out.print(conjuncao[i] +"\t");
            System.out.print(disjuncao[i] +"\t");
            System.out.print(bicondicional[i] +"\n");

        }

        System.out.println("Digite a expressao: ");
        String expr = input.nextLine();

        String[] lst_expr = expr.strip().split(" ");


        p = TabelaVerdade.atribuicaoValoresVariavel(linhas, 2);
        q = TabelaVerdade.atribuicaoValoresVariavel(linhas, 1);
        boolean[] resultado = TabelaVerdade.compararTabelas(p, q, lst_expr[1]);

        System.out.println("Resultado de : " + lst_expr[0] + lst_expr[1] + lst_expr[2]);
        System.out.println(lst_expr[0] + "\t\t" + lst_expr[2] +  "\t\t" + lst_expr[0] + lst_expr[1] + lst_expr[2]);
        for(int i = 0; i < linhas; i++){
            System.out.print(p[i] +"\t");
            System.out.print(q[i] +"\t");
            System.out.print(resultado[i] +"\n");
        }






    }


}
