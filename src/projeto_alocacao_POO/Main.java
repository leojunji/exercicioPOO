package projeto_alocacao_POO;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main  implements Serializable {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        String firstOp;
        int opcao;
        String arquivo_clientes = "cliente.dados";

        String arquivo_veiculos = "veiculo.dados";

        LocadoraVeiculos locadoraVeiculos = new LocadoraVeiculos("sbc");




        /**
         * leo 123
         * joao 321
         * claudio 111
         **/



        while(true) {

            firstOp = JOptionPane.showInputDialog("Selecione uma opção: \n\n" +
                    "1  --  Cadastrar veículo\n" +
                    "2  --  Cadastrar Cliente\n" +
                    "3  --  Locação de veículos\n" +
                    "4  --  Listagem de veículos cadastrados\n" +
                    "5  --  Listagem de clientes\n" +
                    "6  --  Listagem das locações\n" +
                    "7  --  Listagem de veículos disponíveis\n" +
                    "8  --  Sair\n");

            try
            {

                opcao = Integer.parseInt(firstOp);
            }
            catch (Exception e)
            {

                opcao = 0;
            }
            switch (opcao) {

                case 1: {

                    try {

                        ArrayList<String> lst_veiculo = new ArrayList<>();


                        int tipo = VerificadoresTipo.verificarInteiro("Tipo de veículo: \n\n" +
                                "1  --  carro \n" +
                                "2  --  moto \n");

                        lst_veiculo.add(tipo == 1 ? "Carro" : "Moto");

                        lst_veiculo.add(JOptionPane.showInputDialog("Placa do veiculo: ").strip());

                        if (lst_veiculo.contains("") | lst_veiculo.contains(null)) {

                            JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos corretamente");
                        } else {


                            if (!locadoraVeiculos.veiculoExistente(lst_veiculo.get(0), lst_veiculo.get(1), arquivo_veiculos)) {

                                try {

                                    lst_veiculo.add(Double.toString(VerificadoresTipo.verificarDouble("Digite o valor da locação: ")).strip());

                                    lst_veiculo.add(JOptionPane.showInputDialog("Digite uma descrição do veiculo: ").strip());

                                    lst_veiculo.add(lst_veiculo.get(0).equals("Carro") ?
                                            Integer.toString(VerificadoresTipo.verificarInteiro("Digite a quantidade de passageiros: ")).strip() :
                                            Boolean.toString(VerificadoresTipo.verificarBoolean("digite: \n" +
                                                    "true  --  com partida eletrica\n" +
                                                    "false -- sem partida eletrica")).strip());



                                    if (!lst_veiculo.get(3).equals("")) {

                                       if(lst_veiculo.get(0).equals("Carro")){

                                           //double valor_locacao, String descricao, String placa, int quant_passageiros
                                           //[tipo0, placa1, locacao2, descricao3, passageiros4]
                                           locadoraVeiculos.addCarro(new Carro(Double.parseDouble(lst_veiculo.get(2)), lst_veiculo.get(3),
                                                   lst_veiculo.get(1),
                                                   Integer.parseInt(lst_veiculo.get(4))));

                                           locadoraVeiculos.cadastrarCarro(arquivo_veiculos);


                                       }else {

                                           locadoraVeiculos.addMoto(new Moto(Double.parseDouble(lst_veiculo.get(2)), lst_veiculo.get(3),
                                                   lst_veiculo.get(1),
                                                   Boolean.parseBoolean(lst_veiculo.get(4))));


                                           locadoraVeiculos.cadastrarMoto(arquivo_veiculos);
                                       }

                                        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso:");
                                    } else {

                                        JOptionPane.showMessageDialog(null,
                                                "É necessário preencher todos os campos corretamente");
                                    }
                                }catch (Exception e){
                                    JOptionPane.showMessageDialog(null,
                                            "É necessário preencher todos os campos corretamente");
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "O veículo ja está cadastrado " +
                                        "\nTipo: " + lst_veiculo.get(0) + "\n Placa: " + lst_veiculo.get(1));
                            }

                        }
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null,
                                "É necessário preencher todos os campos corretamente");
                    }


                    break;

                } case 2: {

                    try {

                        ArrayList<String> lst_cliente = new ArrayList<>();

                        JOptionPane.showMessageDialog(null, "CADASTRAR CLIENTE");

                        lst_cliente.add(JOptionPane.showInputDialog("nome: ").strip());

                        lst_cliente.add(JOptionPane.showInputDialog("endereço: ").strip());

                        lst_cliente.add(JOptionPane.showInputDialog("Data de nascimento: ").strip());

                        lst_cliente.add(JOptionPane.showInputDialog("Coloque um identificador: ").strip());

                        if (lst_cliente.contains("") | lst_cliente.contains(null)) {

                            JOptionPane.showMessageDialog(null,
                                    "É necessário preencher todos os campos corretamente");
                        } else {

                            if (locadoraVeiculos.clienteExistente(lst_cliente.get(0), lst_cliente.get(3), arquivo_clientes)) {

                                JOptionPane.showMessageDialog(null, "Cliente ja existe");

                            } else {

                                locadoraVeiculos.addCliente(new Cliente(lst_cliente.get(0), lst_cliente.get(1), lst_cliente.get(2), lst_cliente.get(3)));

                                locadoraVeiculos.cadastrarCliente(arquivo_clientes);

                                JOptionPane.showMessageDialog(null, "Cadastro ralizado com sucesso");


                            }
                        }
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null,
                                "É necessário preencher todos os campos corretamente");
                    }

                    break;
                }

                case 3: {

                    int tempo_locacao = 0;
                    String data_locacao = "";
                    boolean seguro = false;
                    double porcentagem_desconto = 0.0d;

                    try {

                        JOptionPane.showMessageDialog(null, "LOCAÇÃO DE VEÍCULOS");

                       String nome_cliente = VerificadoresTipo.verificarCampo("Nome do cliente: ").strip();//0

                        String identificador_cliente = VerificadoresTipo.verificarCampo("Identificador do usuário: ").strip();//1


                        if (locadoraVeiculos.clienteExistente(nome_cliente, identificador_cliente, arquivo_clientes)) {

                            int valor = VerificadoresTipo.verificarInteiro("Tipo de veículo: \n\n" +
                                    "1  --  carro \n" +
                                    "2  --  moto \n");

                            String tipo = (valor == 1 ? "Carro" : "Moto");

                            String placa = VerificadoresTipo.verificarCampo("Placa do veiculo: ").strip();

                            if(locadoraVeiculos.veiculoExistente(tipo, placa, arquivo_veiculos)
                            & locadoraVeiculos.veiculoDisponivel(arquivo_veiculos, placa)) {

                                //2
                                tempo_locacao = VerificadoresTipo.verificarInteiro("Digitar o tempo de locação(MÍNIMO DE 1 DIA):\n" +
                                        "Deve ser uma valor positivo(+) maior ou igual a 1 ");
                                //3
                                data_locacao = VerificadoresTipo.verificarCampo("Digitar a data de locacao: ").strip();
                                //4
                                seguro = VerificadoresTipo.verificarBoolean("Digtar: \n" +
                                        "true -- com seguro\n" +
                                        "false -- sem seguro\n");
                                //5
                                porcentagem_desconto = VerificadoresTipo.verificarDouble("Digtar o valor do desconto(MÁXIMO 12%):\n" +
                                        "OBS: deve ser uma valor positivo(+) entre 0% e 12% ");

                            }else {

                                JOptionPane.showMessageDialog(null, "Esse veículo não está cadastrado");
                            }

                            if (tempo_locacao >= 1 & (porcentagem_desconto >=0 & porcentagem_desconto <= 12)) {

                                if(tipo.equals("Carro")){

                                    Carro carro = locadoraVeiculos.configurarCarro(arquivo_veiculos, placa);

                                    carro.setData_locacao(data_locacao);

                                    carro.setTempo_locacao(tempo_locacao);

                                    carro.setPorcentagem_desconto(porcentagem_desconto);

                                    carro.setSeguro(seguro);

                                    carro.setCliente(locadoraVeiculos.configurarCliente(arquivo_clientes,nome_cliente,
                                            identificador_cliente));

                                    double valor_seguro = locadoraVeiculos.caucularSeguroCarro(carro.getValor_locacao(),
                                            carro.getQuant_passageiros());


                                    double valor_total = locadoraVeiculos.fazerCauculoLocacao(carro.getTempo_locacao(),
                                                    carro.getValor_locacao(), valor_seguro, carro.getPorcentagem_desconto());

                                    int resp = VerificadoresTipo.verificarInteiro("LOCAÇÃO:\n" +
                                            "USUÁRIO: " + carro.getCliente().getNome() + "\n" +
                                            "IDENTIFICADOR: " + carro.getCliente().getIdentificador() + "\n" +
                                            "VALOR SEGURO: R$" + valor_seguro + "\n" +
                                            "PORCENTAGEM DESCONTO: " + carro.getPorcentagem_desconto() + "%\n" +
                                            "TEMPO DE LOCAÇÃO: " + carro.getTempo_locacao() + "\n" +
                                            "MOTO: " + carro.getDescricao() + "\n" +
                                            "VALOR DIÁRIA: R$" + carro.getValor_locacao() + "%\n" +
                                            "VALOR TOTAL: R$" + valor_total +
                                            "DIGITAR: \n" +
                                            "1 -- ACEITAR\n" +
                                            "2 -- RECUSAR");

                                    if(resp==1){

                                        carro.setDisponibilidade(false);
                                        locadoraVeiculos.realizarLocacaoCarro(arquivo_veiculos, carro);
                                        JOptionPane.showMessageDialog(null, "LOCAÇÃO FEITA");

                                    }else {

                                        JOptionPane.showMessageDialog(null, "A LOCAÇÃO NÃAO  FOI REALIZADA");

                                    }


                                }else {

                                    Moto moto = locadoraVeiculos.configurarMoto(arquivo_veiculos, placa);

                                    moto.setData_locacao(data_locacao);

                                    moto.setTempo_locacao(tempo_locacao);

                                    moto.setPorcentagem_desconto(porcentagem_desconto);

                                    moto.setSeguro(seguro);

                                    moto.setCliente(locadoraVeiculos.configurarCliente(arquivo_clientes,nome_cliente,
                                            identificador_cliente));

                                    double valor_seguro = locadoraVeiculos.caucularSeguroMoto(moto.getValor_locacao());


                                    double valor_total = locadoraVeiculos.fazerCauculoLocacao(moto.getTempo_locacao(),
                                            moto.getValor_locacao(), valor_seguro, moto.getPorcentagem_desconto());

                                    int resp = VerificadoresTipo.verificarInteiro("LOCAÇÃO:\n" +
                                            "USUÁRIO: " + moto.getCliente().getNome() + "\n" +
                                            "IDENTIFICADOR: " + moto.getCliente().getIdentificador() + "\n" +
                                            "VALOR SEGURO: R$" + valor_seguro + "\n" +
                                            "PORCENTAGEM DESCONTO: " + moto.getPorcentagem_desconto() + "%\n" +
                                            "TEMPO DE LOCAÇÃO: " + moto.getTempo_locacao() + "DIA(S)\n" +
                                            "MOTO: " + moto.getDescricao() + "\n" +
                                            "VALOR DIÁRIA: R$" + moto.getValor_locacao() + "%\n" +
                                            "VALOR TOTAL: R$" + valor_total + "\n" +
                                            "DIGITAR: \n" +
                                            "1 -- ACEITAR\n" +
                                            "2 -- RECUSAR");

                                    if(resp==1){

                                        moto.setDisponibilidade(false);
                                        JOptionPane.showMessageDialog(null, "LOCAÇÃO FEITA");
                                    }else {
                                        JOptionPane.showMessageDialog(null, "A LOCAÇÃO NÃAO  FOI REALIZADA");
                                    }

                                }

                            }else {


                                JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos corretamente");
                            }


                        } else {

                            JOptionPane.showMessageDialog(null, "Esse usuário não está cadastrado");

                        }
                    }catch (Exception e){

                        JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos corretamente");
                        e.printStackTrace();
                    }
                    break;
                }
                case 4: {

                    System.out.println("Listagem de veículos cadastrados\n");
                    break;
                }
                case 5: {

                    locadoraVeiculos.mostrarClientes(arquivo_clientes);
                    System.out.println("-----------------------------------------------");
                    break;
                }
                case 6: {

                    System.out.println("Listagem das locações\n");
                    break;
                }
                case 7: {

                    locadoraVeiculos.mostrarCarros(arquivo_veiculos, false);
                    break;
                }
                case 8: {
                    //JOptionPane.showMessageDialog(null,
                            //" Saindo...");
                    System.exit(0);
                }
                default: {

                    JOptionPane.showMessageDialog(null,
                            "Opção Inválida!", "ERRO",
                            JOptionPane.ERROR_MESSAGE );
                    //System.out.println(opcao + " é uma opcao inválida");
                    break;
                }
            }
        }

    }
}
