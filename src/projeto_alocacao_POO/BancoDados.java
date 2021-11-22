package projeto_alocacao_POO;

import java.io.*;
import java.util.ArrayList;

public class BancoDados {

    //-----------------novos métodos


    public static void gravarArquivoBinario(ArrayList<Object> lista, String nomeArq) {
        File arq = new File(nomeArq);
        try {
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(lista); //vai ser 1 lista dentro do arquivo
            objOutput.close();

        } catch(IOException e) {
            System.out.printf("Erro gravar arquivosa: %s", e.getMessage());
        }
    }

    public static ArrayList<Object> lerArquivoBinario(String nomeArq) {
        ArrayList<Object> lista = new ArrayList();
        try {
            File arq = new File(nomeArq);
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                lista = (ArrayList<Object>)objInput.readObject();
                objInput.close();
            }
        } catch(IOException | ClassNotFoundException e) {
            System.out.print("Erro: " +  e.getMessage());
        }

        return(lista);
    }




}
