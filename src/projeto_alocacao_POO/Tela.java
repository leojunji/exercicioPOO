package projeto_alocacao_POO;


import javax.swing.*;
import java.util.ArrayList;

public class Tela {

    /**
     * apresenta um input com o menu*/
    public static int menu(){

        return VerificadoresTipo.verificarInteiro("Selecione uma opção: \n\n" +
                "1  --  Cadastrar veículo\n\n" +
                "2  --  Cadastrar Cliente\n\n" +
                "3  --  Locação de veículos\n\n" +
                "4  --  Listagem de veículos cadastrados\n\n" +
                "5  --  Listagem de clientes\n\n" +
                "6  --  Listagem das locações\n\n" +
                "7  --  Listagem de veículos disponíveis\n\n" +
                "8  --  Sair\n");

    }


    /**
     * output mostrando os carros
     * @param arquivo_veiculos --> arquivo que contem os dados dos carros
     * @param disponibilidade --> true==mostrar os carros disponiveis
     * @param mostrar_alocadores --> true==ira mostrar os alocadores de carro(obs: disponibilidade deve ser false)*/
    public static void mostrarCarros(String arquivo_veiculos, boolean disponibilidade, boolean mostrar_alocadores){

        ArrayList<Object> dados_banco = BancoDados.lerArquivo(arquivo_veiculos);


        for(Object dado : dados_banco) {

            if(((Veiculo)dado).isDisponibilidade()==disponibilidade & ((Veiculo)dado).getTipo().equals("Carro")) {

                JOptionPane.showMessageDialog(null,
                        "Tipo: " + ((Carro) dado).getTipo() + "\n\n" +

                                "Locação: " + ((Carro) dado).getValor_locacao() + "\n\n" +

                                "Placa: " + ((Carro) dado).getPlaca() + "\n\n" +

                                "Descrição: " + ((Carro) dado).getDescricao() + "\n\n" +

                                "Disponibilidade: " + ((Carro) dado).isDisponibilidade() + "\n\n" +

                                "quantidade passageiros: " + ((Carro) dado).getQuant_passageiros() + "\n\n" +

                                "=================================================================" + "\n" +
                                (mostrar_alocadores ?
                                        ( "Valor total da locação: R$" + ((Carro) dado).getValor_total_locacao() + "\n\n"  +

                                                "Tempo da Locação: " + ((Carro) dado).getTempo_locacao() + " dia(s)\n\n" +

                                                "Tem seguro: " + ((Carro) dado).isSeguro() + "\n\n" +

                                                "Desconto: " + ((Carro) dado).getPorcentagem_desconto() + "%\n\n" +

                                                "Nome do cliente: " + ((Carro) dado).getCliente().getNome()) + "\n\n" +

                                                "Identificador do cliente: " + ((Carro) dado).getCliente().getIdentificador(): ""));



            }
        }

    }



    /**
     * o mesmo comportamento do mostrarCarros(), porem para motos*/
    public static void mostrarMotos(String arquivo_veiculos , boolean disponibilidade, boolean mostrar_alocadores){

        ArrayList<Object> dados_banco = BancoDados.lerArquivo(arquivo_veiculos);


        for(Object dado : dados_banco) {

            if(((Veiculo)dado).isDisponibilidade()==disponibilidade & ((Veiculo)dado).getTipo().equals("Moto")) {

                JOptionPane.showMessageDialog(null,
                        "Tipo: " + ((Moto) dado).getTipo() + "\n\n" +

                                "Locação: " + ((Moto) dado).getValor_locacao() + "\n\n" +

                                "Placa: " + ((Moto) dado).getPlaca() + "\n\n" +

                                "Descrição: " + ((Moto) dado).getDescricao() + "\n\n" +

                                "Disponibilidade: " + ((Moto) dado).isDisponibilidade() + "\n\n" +

                                "partida eletrica: " + ((Moto) dado).isPartida_eletrica() + "\n\n" +

                                "=================================================================" + "\n" +
                                (mostrar_alocadores ?
                                        ("Valor total da locação: R$" + ((Moto) dado).getValor_total_locacao() + "\n\n"+

                                                "Tempo da Locação: " + ((Moto) dado).getTempo_locacao() + " dia(s)\n\n" +

                                                "Tem seguro: " + ((Moto) dado).isSeguro() + "\n\n" +

                                                "Desconto: " + ((Moto) dado).getPorcentagem_desconto() + "%\n\n" +

                                                "Nome do cliente: " + ((Moto)dado).getCliente().getNome() + "\n\n" +

                                                "Identificador do cliente: " + ((Moto)dado).getCliente().getIdentificador()) : ""));



            }
        }

    }



    public static void mostrarClientes(String arquivo_clientes){

        ArrayList<Object> dados_cliente = BancoDados.lerArquivo(arquivo_clientes);


        for(Object dado : dados_cliente){

            JOptionPane.showMessageDialog(null,"nome: " + ((Cliente)dado).getNome() + "\n\n" +

                    "Data nascimento: " + ((Cliente)dado).getData_nascimento() + "\n\n" +

                    "Identificador: " + ((Cliente)dado).getIdentificador() + "\n\n" +

                    "Endereço: " + ((Cliente)dado).getEndereço() + "\n\n" );

        }


    }


    /**
     * @return true==usuario confirmou locacao ou false*/
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
