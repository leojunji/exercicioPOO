package projeto_alocacao_POO;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class BancoDados {

    public static boolean appendArquivo(String conteudo, String nomeArquivo){
        try {
            Writer bw;
            bw = new BufferedWriter(new FileWriter(nomeArquivo, true));
            bw.write(conteudo);
            bw.close();
            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao ler arquivo");
            e.printStackTrace();
            return false;
        }

    }

    public static ArrayList<String> readArquivo(String nome_arquivo) throws IOException {
        ArrayList<String> lista = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nome_arquivo), "UTF-8"));
        String line;
        while ((line = br.readLine()) != null) {
            lista.add(line);
        }
        br.close();
        return lista;
    }


    /**
     * retorna true se o usuario existir*/
    public static boolean usuarioExistente(String nome, String identificador, String arquivo)  {

        boolean usuario_existente = false;


        try {

            ArrayList<String> dados_usuarios = BancoDados.readArquivo(arquivo);
            for(String dados : dados_usuarios){


                String[] valor = dados.split(";");

                if(nome.equals(valor[0]) & identificador.equals(valor[1])){

                    usuario_existente = true;
                }

            }
        }
        catch (FileNotFoundException fio){
            JOptionPane.showMessageDialog(null, "O arquivo " + arquivo +
                    " não foi localizado");
            usuario_existente = true;
        }
        catch (Exception e){

            JOptionPane.showMessageDialog(null, "Erro ao acessar arquivo: " + arquivo);
            usuario_existente = true;
            e.printStackTrace();
        }

        return usuario_existente;
    }



    /**
     * retorna true se o veiculo existir*/
    public static boolean veiculoExistente(String tipo, String placa, String arquivo)  {

        boolean veiculo_existente = false;


        try {

            ArrayList<String> dados_veiculos = BancoDados.readArquivo(arquivo);
            for(String dados : dados_veiculos){


                String[] valor = dados.split("~");


                if(placa.equals(valor[1]) & tipo.equals(valor[2])){

                    veiculo_existente = true;
                }

            }
        }
        catch (FileNotFoundException fio){
            JOptionPane.showMessageDialog(null, "O arquivo " + arquivo +
                    " não foi localizado");
            veiculo_existente = true;
        }
        catch (Exception e){

            JOptionPane.showMessageDialog(null, "Erro ao acessar arquivo: " + arquivo);
            veiculo_existente = true;
            e.printStackTrace();
        }

        return veiculo_existente;
    }


    public static String[] retirarDadoCliente(String endereco_arquivo, String nome, String identificador) throws IOException{

        ArrayList<String> lst_dados;
        String valor_requerido = "";

        lst_dados = readArquivo(endereco_arquivo); //pega todos os dados do arquivo

        BufferedWriter bw = new BufferedWriter(new FileWriter(endereco_arquivo, false)); //zera o arquivo

        for(String dado : lst_dados){

            String[] lst_auxiliar = dado.split(";");
            if(lst_auxiliar[0].equals(nome) & lst_auxiliar[1].equals(identificador)) {

                valor_requerido = dado;
            }else{

                bw.write(dado + "\n");
            }

        }

        bw.close();

        return valor_requerido.split(";");
    }

    public static String[] retirarDadoVeiculo(String endereco_arquivo, String placa,String tipo) throws IOException{

        ArrayList<String> lst_dados;
        String valor_requerido = "";

        lst_dados = readArquivo(endereco_arquivo); //pega todos os dados do arquivo

        BufferedWriter bw = new BufferedWriter(new FileWriter(endereco_arquivo, false)); //zera o arquivo

        for(String dado : lst_dados){

            String[] lst_auxiliar = dado.split("~");
            if(lst_auxiliar[1].equals(placa) & lst_auxiliar[2].equals(tipo)) {

                valor_requerido = dado;
            }else{

                bw.write(dado + "\n");
            }

        }

        bw.close();

        return valor_requerido.split("~");
    }


    public static String[] getDadosVeiculo(String endereco_arquivo, String placa,String tipo) throws IOException{

        ArrayList<String> lst_dados;
        String valor_requerido = "";

        lst_dados = readArquivo(endereco_arquivo); //pega todos os dados do arquivo

        for(String dado : lst_dados){

            String[] lst_auxiliar = dado.split("~");
            if(lst_auxiliar[1].equals(placa) & lst_auxiliar[2].equals(tipo)) {

                valor_requerido = dado;

            }

        }

        return valor_requerido.split("~");

    }

    public static String[] getDadoCliente(String endereco_arquivo, String nome, String identificador) throws IOException{

        ArrayList<String> lst_dados;
        String valor_requerido = "";

        lst_dados = readArquivo(endereco_arquivo); //pega todos os dados do arquivo

        for(String dado : lst_dados){

            String[] lst_auxiliar = dado.split(";");
            if(lst_auxiliar[0].equals(nome) & lst_auxiliar[1].equals(identificador)) {

                valor_requerido = dado;
            }

        }

        return valor_requerido.split(";");
    }




}
