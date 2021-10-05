package TDE_pensamentoMat;

public class TabelaVerdade {


    public static int[] atribuicaoValoresTabela(int linhas, int colunas){


        int tab_tamanho = linhas*colunas;

        int[] tabela = new int[tab_tamanho];

        int valor = 0;

        int quebra_linha;
        int coluna_inicio = 0;

        for(int c = 0; c < colunas; c++){
            quebra_linha = coluna_inicio;
            for(int l = 0; l < linhas; l++){
                tabela[quebra_linha] = valor;
                quebra_linha += linhas;
                valor += 1;
            }
            coluna_inicio += 1;
        }

        return tabela;
    }


    public static boolean[] atribuicaoValoresVariavel(int quant_linhas, int passo){

        boolean[] tabela = new boolean[quant_linhas];
        int c = 0;
        int contador = 1;
        int auxiliar = passo;

        while (c < quant_linhas){
            tabela[c] = true;
            if(contador==passo){
                c += auxiliar;
                passo += auxiliar;
            }
            contador += 1;
            c += 1;


        }

        return tabela;
    }


    //compara com "ou"
    public static boolean[] compararTabelas(boolean[]primeira, boolean[]segunda, String comparacao){

        int linhas_tab = primeira.length;
        boolean[] resultado = new boolean[linhas_tab];

        for (int indice = 0; indice < linhas_tab; indice++) {

            if (comparacao.equals("^") | comparacao.equals("&")) {
                resultado[indice] = primeira[indice] & segunda[indice];
            }

            if (comparacao.equals("v") | comparacao.equals("or") | comparacao.equals("|")) {
                resultado[indice] = primeira[indice] | segunda[indice];
            }

            if (comparacao.equals("->")) {
                resultado[indice] = !primeira[indice] | segunda[indice];
            }

            if (comparacao.equals("<->")) {
                resultado[indice] = primeira[indice] == segunda[indice];
            }

        }
        return resultado;

    }
}
