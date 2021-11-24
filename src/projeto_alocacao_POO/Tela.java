package projeto_alocacao_POO;


import javax.swing.*;
import java.util.ArrayList;

public class Tela {

    public static int menu(){

        return VerificadoresTipo.verificarInteiro("Selecione uma opção: \n\n" +
                "1  --  Cadastrar veículo\n" +
                "2  --  Cadastrar Cliente\n" +
                "3  --  Locação de veículos\n" +
                "4  --  Listagem de veículos cadastrados\n" +
                "5  --  Listagem de clientes\n" +
                "6  --  Listagem das locações\n" +
                "7  --  Listagem de veículos disponíveis\n" +
                "8  --  Sair\n");

    }



    public static void mostrarCarros(String arquivo_veiculos, boolean disponibilidade, boolean mostrar_alocadores){

        ArrayList<Object> dados_banco = BancoDados.lerArquivo(arquivo_veiculos);


        for(Object dado : dados_banco) {

            if(((Veiculo)dado).isDisponibilidade()==disponibilidade & ((Veiculo)dado).getTipo().equals("Carro")) {

                JOptionPane.showMessageDialog(null,
                        "Tipo: " + ((Carro) dado).getTipo() + "\n" +

                                "Locação: " + ((Carro) dado).getValor_locacao() + "\n" +

                                "Placa: " + ((Carro) dado).getPlaca() + "\n" +

                                "Descrição: " + ((Carro) dado).getDescricao() + "\n" +

                                "Disponibilidade: " + ((Carro) dado).isDisponibilidade() + "\n" +

                                "quantidade passageiros: " + ((Carro) dado).getQuant_passageiros() + "\n" +

                                "=================================================================" + "\n" +
                                (mostrar_alocadores ?
                                        ( "Valor total da locação: R$" + ((Carro) dado).getValor_total_locacao() + "\n"  +

                                                "Tempo da Locação: " + ((Carro) dado).getTempo_locacao() + " dia(s)\n" +

                                                "Tem seguro: " + ((Carro) dado).isSeguro() + "\n" +

                                                "Desconto: " + ((Carro) dado).getPorcentagem_desconto() + "%\n" +

                                                "Nome do cliente: " + ((Carro) dado).getCliente().getNome()) + "\n" +

                                                "Identificador do cliente:" + ((Carro) dado).getCliente().getIdentificador(): ""));



            }
        }

    }


    public static void mostrarMotos(String arquivo_veiculos , boolean disponibilidade, boolean mostrar_alocadores){

        ArrayList<Object> dados_banco = BancoDados.lerArquivo(arquivo_veiculos);


        for(Object dado : dados_banco) {

            if(((Veiculo)dado).isDisponibilidade()==disponibilidade & ((Veiculo)dado).getTipo().equals("Moto")) {

                JOptionPane.showMessageDialog(null,
                        "Tipo: " + ((Moto) dado).getTipo() + "\n" +

                                "Locação: " + ((Moto) dado).getValor_locacao() + "\n" +

                                "Placa: " + ((Moto) dado).getPlaca() + "\n" +

                                "Descrição: " + ((Moto) dado).getDescricao() + "\n" +

                                "Disponibilidade: " + ((Moto) dado).isDisponibilidade() + "\n" +

                                "partida eletrica: " + ((Moto) dado).isPartida_eletrica() + "\n" +

                                "=================================================================" + "\n" +
                                (mostrar_alocadores ?
                                        ("Valor total da locação: R$" + ((Moto) dado).getValor_total_locacao() + "\n"+

                                                "Tempo da Locação: " + ((Moto) dado).getTempo_locacao() + " dia(s)\n" +

                                                "Tem seguro: " + ((Moto) dado).isSeguro() + "\n" +

                                                "Desconto: " + ((Moto) dado).getPorcentagem_desconto() + "%\n" +

                                                "Nome do cliente: " + ((Moto)dado).getCliente().getNome() + "\n" +

                                                "Identificador do cliente:" + ((Moto)dado).getCliente().getIdentificador()) : ""));



            }
        }

    }


    public static void mostrarClientes(String arquivo_clientes){

        ArrayList<Object> dados_cliente = BancoDados.lerArquivo(arquivo_clientes);


        for(Object dado : dados_cliente){

            JOptionPane.showMessageDialog(null,"nome: " + ((Cliente)dado).getNome() + "\n" +

                    "Data nascimento: " + ((Cliente)dado).getData_nascimento() + "\n" +

                    "Identificador: " + ((Cliente)dado).getIdentificador() + "\n" +

                    "Endereço: " + ((Cliente)dado).getEndereço() + "\n" );

        }


    }


    /**
     * retorna true se o usuario confirmar a locacao*/
    public static boolean confirmarLocacao(Object veiculo, double valor_seguro){

        return VerificadoresTipo.verificarBoolean("DESCONTO: " + ((Veiculo)veiculo).getPorcentagem_desconto() + "%\n\n" +
                "SEGURO: R$" + valor_seguro + "\n\n" +
                "DIÁRIA: R$" + ((Veiculo)veiculo).getValor_locacao() + "\n\n" +
                "VALOR TOTAL: R$" + ((Veiculo)veiculo).valor_total_locacao + "\n" +
                "================================================================\n" +
                        "DIGITAR: \n" +
                        "true -- ACEITAR\n" +
                        "false --recusar");

    }

}
