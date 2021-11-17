package projeto_alocacao_POO;


import javax.swing.*;
import java.util.ArrayList;

public class Tela {


    /**
     * se mostrar for true, ele mostra os veiculos dispoiniveis
     * se for false ele mostra os veiculos indisponiveis ou alocados*/
    public static void mostrarCarros(String arquivo_veiculos, boolean disponibilidade, boolean mostrar){

        ArrayList<Object> dados_banco = BancoDados.lerArquivoBinario(arquivo_veiculos);


        for(Object dado : dados_banco) {

            if(((Veiculo)dado).isDisponibilidade()==disponibilidade & ((Veiculo)dado).getTipo().equals("Carro")) {

                JOptionPane.showMessageDialog(null,
                        "Tipo: " + ((Carro) dado).getTipo() + "\n" +

                                "Locação: " + ((Carro) dado).getValor_locacao() + "\n" +

                                "Tempo da Locação: " + ((Carro) dado).getTempo_locacao() + "\n" +

                                "Tem seguro: " + ((Carro) dado).isSeguro() + "\n" +

                                "Desconto: " + ((Carro) dado).getPorcentagem_desconto() + "%\n" +

                                "Placa: " + ((Carro) dado).getPlaca() + "\n" +

                                "Descrição: " + ((Carro) dado).getDescricao() + "\n" +

                                "Disponibilidade: " + ((Carro) dado).isDisponibilidade() + "\n" +

                                "quantidade passageiros: " + ((Carro) dado).getQuant_passageiros() + "\n" +
                                (mostrar ?
                                        ( "Valor total da locaçãao: " + ((Carro) dado).getValor_total_locacao() + "\n"  +
                                                "Nome do cliente: " + ((Carro) dado).getCliente().getNome()) + "\n" +
                                                "Identificador do cliente:" + ((Carro) dado).getCliente().getIdentificador(): ""));



            }
        }

    }


    public static void mostrarMotos(String arquivo_veiculos , boolean disponibilidade, boolean mostrar){

        ArrayList<Object> dados_banco = BancoDados.lerArquivoBinario(arquivo_veiculos);


        for(Object dado : dados_banco) {

            if(((Veiculo)dado).isDisponibilidade()==disponibilidade & ((Veiculo)dado).getTipo().equals("Moto")) {

                JOptionPane.showMessageDialog(null,
                        "Tipo: " + ((Moto) dado).getTipo() + "\n" +

                                "Locação: " + ((Moto) dado).getValor_locacao() + "\n" +

                                "Tempo da Locação: " + ((Moto) dado).getTempo_locacao() + "\n" +

                                "Tem seguro: " + ((Moto) dado).isSeguro() + "\n" +

                                "Desconto: " + ((Moto) dado).getPorcentagem_desconto() + "%\n" +

                                "Placa: " + ((Moto) dado).getPlaca() + "\n" +

                                "Descrição: " + ((Moto) dado).getDescricao() + "\n" +

                                "Disponibilidade: " + ((Moto) dado).isDisponibilidade() + "\n" +

                                "partida eletrica: " + ((Moto) dado).isPartida_eletrica() + "\n" +

                                (mostrar ?
                                        ("Valor total da locaçãao: " + ((Moto) dado).getValor_total_locacao() + "\n"
                                                + "Nome do cliente: " + ((Moto)dado).getCliente().getNome() + "\n" +
                                                "Identificador do cliente:" + ((Moto)dado).getCliente().getIdentificador()) : ""));



            }
        }

    }

}
