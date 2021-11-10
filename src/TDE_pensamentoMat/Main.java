package TDE_pensamentoMat;

//import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){



        Scanner input = new Scanner(System.in);

        int linhas = 5;
        int colunas = 8;



        String[] p = TabelaVerdade.atribuicaoValoresVariavel("p", linhas,2);
        String[] q = TabelaVerdade.atribuicaoValoresVariavel("q", linhas,1);
        String[] lst_aux1 = ArrayUtils.addAll(p,q); //esta unindo a lista p com a q


        String[] p_invertido = TabelaVerdade.inverterValoresVariavel(p);
        p_invertido[0] = "~p";
        String[] q_invertido = TabelaVerdade.inverterValoresVariavel(q);
        q_invertido[0] = "~q";
        String[] lst_aux2 = ArrayUtils.addAll(p_invertido,q_invertido);

        String[] implicacao = TabelaVerdade.compararVariaveis(p,q, "->");
        String[] conjuncao = TabelaVerdade.compararVariaveis(p,q, "^");
        String[] lst_aux3 = ArrayUtils.addAll(implicacao,conjuncao);

        String[] disjuncao = TabelaVerdade.compararVariaveis(p,q, "|");
        String[] bicondicional = TabelaVerdade.compararVariaveis(p,q, "<->");
        String[] lst_aux4 = ArrayUtils.addAll(disjuncao,bicondicional);

        String[] lst_aux5 = ArrayUtils.addAll(lst_aux1,lst_aux2);
        String[] lst_aux6 = ArrayUtils.addAll(lst_aux3, lst_aux4);
        String[] lst_valores = ArrayUtils.addAll(lst_aux5, lst_aux6);


        String[] lst_tabela = TabelaVerdade.atribuicaoValoresTabela(linhas, colunas, lst_valores);


        int i = 0;
        for(int l = 0; l < linhas;l++){
            for(int c = 0; c < colunas; c++){
                if(l==0) {
                    System.out.printf("[%s]\t  ", lst_tabela[i]);
                }else{
                    System.out.printf("[%s]  ", lst_tabela[i]);
                }
                i += 1;
            }
            System.out.println();
        }


        //---------------------------------------------------
        System.out.println("Digite a expressao(ex: p -> q): ");
        String expr = input.nextLine();

        String[] lst_expr = expr.strip().split(" ");

        if(lst_expr.length==3) {
            p = TabelaVerdade.atribuicaoValoresVariavel(lst_expr[0], linhas, 2);
            q = TabelaVerdade.atribuicaoValoresVariavel(lst_expr[2], linhas, 1);

            if(lst_expr[0].contains("~"))
                p = TabelaVerdade.inverterValoresVariavel(p);

            if(lst_expr[2].contains("~"))
                q = TabelaVerdade.inverterValoresVariavel(q);

            lst_aux1 = ArrayUtils.addAll(p, q);


            String[] resultado = TabelaVerdade.compararVariaveis(p, q, lst_expr[1]);

            lst_aux2 = ArrayUtils.addAll(lst_aux1, resultado);

            String[] tabela = TabelaVerdade.atribuicaoValoresTabela(linhas, 3, lst_aux2);



            i = 0;
            for (int l = 0; l < linhas; l++) {
                for (int c = 0; c < 3; c++) {
                    if (l == 0) { //l = 0 indica toda a primeira linha
                        System.out.printf(" %s  \t  ", tabela[i]);
                    } else {
                        System.out.printf("[%s]  ", tabela[i]);
                    }
                    i += 1;
                }
                System.out.println();
            }
        }else{

            String[] valores_variavel = TabelaVerdade.atribuicaoValoresVariavel(lst_expr[0], linhas,2);

            for (int l = 0; l < valores_variavel.length; l++) {
                System.out.println("["+valores_variavel[l]+"]");
            }

        }






        }


}
