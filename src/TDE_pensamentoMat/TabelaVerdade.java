package TDE_pensamentoMat;


public class TabelaVerdade {



    /** vai pegar todas as variaveis e resultados e entao fazer uma tabela
     * @param linhas -> quantidade de linhas da tabela
     * @param colunas -> quantidade de colunas da tabela
     * @param lst_valores -> lista com as variaveis e resultados que irao compor a tabela
     * @return retorna uma tabela*/
    public static String[] atribuicaoValoresTabela(int linhas, int colunas, String[] lst_valores){



        int tab_tamanho = linhas*colunas;


        String[] tabela = new String[tab_tamanho];

        int i = 0;

        int quebra_linha;
        int coluna_inicio = 0;

        for(int c = 0; c < colunas; c++){
            quebra_linha = coluna_inicio;
            for(int l = 0; l < linhas; l++){
                tabela[quebra_linha] = lst_valores[i];
                quebra_linha += colunas;
                i += 1;
            }
            coluna_inicio += 1;
        }

        return tabela;
    }


    /**vai atribuir os valores a uma variavel
     * OBS:uma variavel compoe uma coluna dentro da tabela verdade
     * @param variavel -> qual e a variavel
     *@param quant_linhas -> quantidade de linhas
     * @param passo -> de quanto em quanto sera a atribuicao dos valores true.(ex:2 em 2)
     * @return uma lista com os valores da variavel*/
    public static String[] atribuicaoValoresVariavel(String variavel, int quant_linhas, int passo){

        boolean[] lst_valores = new boolean[quant_linhas-1];
        String[] tabela = new String[quant_linhas];
        int c = 0;
        int contador = 1;
        int auxiliar = passo;

        while (c < quant_linhas-1){
            lst_valores[c] = true;
            if(contador==passo){
                c += auxiliar;
                passo += auxiliar;
            }
            contador += 1;
            c += 1;


        }


        tabela[0] = variavel;

        int indice_lst = 0; //indice do lst_valores
        for(int indice = 1;indice < quant_linhas;indice++){
            tabela[indice] = String.valueOf(lst_valores[indice_lst]);
            indice_lst += 1;
        }

        return tabela;
    }


    /**vai comparar duas variaveis
     * @param comparacao -> qual tipo de comparacao sera feita
     * @return uma lista que correponde ao resultado da comparacao*/
    public static String[] compararVariaveis(String[]primeira, String[]segunda, String comparacao){

        int linhas_tab = primeira.length;
        String[] resultado = new String[linhas_tab];

        resultado[0] = primeira[0] + comparacao + segunda[0];

        for (int indice = 1; indice < linhas_tab; indice++) {

            if (comparacao.equals("^") | comparacao.equals("&")) {
                resultado[indice] = String.valueOf(Boolean.parseBoolean(primeira[indice]) & Boolean.parseBoolean(segunda[indice]));
            }

            if (comparacao.equals("v") | comparacao.equals("or") | comparacao.equals("|")) {
                resultado[indice] = String.valueOf(Boolean.parseBoolean(primeira[indice]) | Boolean.parseBoolean(segunda[indice]));
            }

            if (comparacao.equals("->")) {
                resultado[indice] = String.valueOf(!Boolean.parseBoolean(primeira[indice]) | Boolean.parseBoolean(segunda[indice]));
            }

            if (comparacao.equals("<->")) {
                resultado[indice] = String.valueOf(Boolean.parseBoolean(primeira[indice]) == Boolean.parseBoolean(segunda[indice]));
            }

        }
        return resultado;

    }

}
