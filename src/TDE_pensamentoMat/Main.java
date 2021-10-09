package TDE_pensamentoMat;

import TDE_pensamentoMat.TabelaVerdade;

public class Main {

    public static void main(String[] args){

        //comentario teste
        int linhas = 2;
        int colunas = linhas;

        boolean[] p = TabelaVerdade.atribuicaoValoresVariavel(4,2);
        boolean[] q = TabelaVerdade.atribuicaoValoresVariavel(4,1);


        System.out.println("p: ");
        for(int c = 0; c < p.length; c++){
            System.out.print("[" + p[c] + "]");
        }
        System.out.println();
        System.out.println("q: ");
        for(int c = 0; c < p.length; c++){
            System.out.print("[" + q[c] + "]");
        }

        boolean[] resultado = TabelaVerdade.compararTabelas(p,q, "<->");
        System.out.println();
        System.out.println("resultado: ");
        for(int c = 0; c < p.length; c++){
            System.out.print("[" + resultado[c] + "]");
        }




    }


}
