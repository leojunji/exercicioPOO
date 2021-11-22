package projeto_alocacao_POO;

import javax.swing.*;
import java.io.Serializable;
import java.text.DecimalFormat;

public class Main  implements Serializable {

    public static void main(String[] args) throws Exception {

        String firstOp;
        int opcao;
        String arquivo_clientes = "cliente.dados";

        String arquivo_veiculos = "veiculo.dados";

        DecimalFormat df = new DecimalFormat("#0.00");

        LocadoraVeiculos locadoraVeiculos = new LocadoraVeiculos("sbc");

        JOptionPane.showMessageDialog(null, "LOCADORA: " +  locadoraVeiculos.getNome_locadora());
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

                            JOptionPane.showMessageDialog(null, "CADASTRAR VEÍCULO");

                        int resp = VerificadoresTipo.verificarInteiro("Tipo de veículo: \n\n" +
                                "1  --  carro \n" +
                                "2  --  moto \n");

                        String tipo = resp == 1 ? "Carro" : "Moto";

                        String placa = VerificadoresTipo.verificarCampo("Placa do veiculo: ");




                        if (!locadoraVeiculos.veiculoExistente(tipo, placa, arquivo_veiculos)) {

                            try { //tem por causa da opcao cancel do JOptionPane

                                double valor_locacao = VerificadoresTipo.verificarDouble("Digite o valor da locação: ");

                                String descriçao = VerificadoresTipo.verificarCampo("Digite uma descrição do veiculo: ");




                               if(tipo.equals("Carro")){

                                   int quant_passageiros = VerificadoresTipo.verificarInteiro("Digite a quantidade de passageiros: ");

                                   locadoraVeiculos.cadastrarCarro(arquivo_veiculos,
                                           new Carro(valor_locacao, descriçao, placa, quant_passageiros));


                               }else {

                                   boolean partida_eletrica = VerificadoresTipo.verificarBoolean("digite: \n" +
                                           "true  --  com partida eletrica\n" +
                                           "false -- sem partida eletrica");


                                   locadoraVeiculos.cadastrarMoto(arquivo_veiculos, new Moto(valor_locacao, descriçao, placa, partida_eletrica));
                               }

                            }catch (Exception e){
                                JOptionPane.showMessageDialog(null,
                                        "Não foi possível realizar o cadastro do veículo");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "O veículo ja está cadastrado " +
                                    "\nTipo: " + tipo + "\n Placa: " + placa);
                        }


                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null,
                                "É necessário preencher todos os campos corretamente");
                    }


                    break;

                } case 2: {

                    try {

                        JOptionPane.showMessageDialog(null, "CADASTRAR CLIENTE");

                        String nome = VerificadoresTipo.verificarCampo("nome: ");

                        String endereco = VerificadoresTipo.verificarCampo("endereço: ");

                        String data_nascimento = VerificadoresTipo.verificarData("Data de nascimento: ");

                        String identificador = VerificadoresTipo.verificarCampo("Coloque um identificador: ");


                        if (locadoraVeiculos.clienteExistente(nome, identificador, arquivo_clientes)) {

                            JOptionPane.showMessageDialog(null, "Cliente ja existe");

                        } else {

                            locadoraVeiculos.cadastrarCliente(arquivo_clientes,
                                    new Cliente(nome, endereco, data_nascimento, identificador));

                            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");


                        }

                    }catch (Exception e){

                        JOptionPane.showMessageDialog(null,
                                "O cadastro não foi realizado");
                        e.printStackTrace();
                    }

                    break;
                }

                case 3: {

                    int tempo_locacao = 0;
                    String data_locacao = "";
                    boolean seguro = false;
                    double porcentagem_desconto = 0.0d;
                    double valor_seguro = 0;

                    try {

                        JOptionPane.showMessageDialog(null, "LOCAÇÃO DE VEÍCULOS");

                        String nome_cliente = VerificadoresTipo.verificarCampo("Nome do cliente: ");

                        String identificador_cliente = VerificadoresTipo.verificarCampo("Identificador do usuário: ");


                        if (locadoraVeiculos.clienteExistente(nome_cliente, identificador_cliente, arquivo_clientes)) {

                            int valor = VerificadoresTipo.verificarInteiro("Tipo de veículo: \n\n" +
                                    "1  --  carro \n" +
                                    "2  --  moto \n");

                            String tipo = (valor == 1 ? "Carro" : "Moto");

                            String placa = VerificadoresTipo.verificarCampo("Placa do veiculo: ").strip();

                            if(locadoraVeiculos.veiculoExistente(tipo, placa, arquivo_veiculos)) {

                                System.out.println("Verificar disponibilidade: " + locadoraVeiculos.veiculoDisponivel(arquivo_veiculos, placa));

                                if(locadoraVeiculos.veiculoDisponivel(arquivo_veiculos, placa)) {


                                    tempo_locacao = VerificadoresTipo.verificarInteiro("Digitar o tempo de locação(MÍNIMO DE 1 DIA):\n" +
                                            "Deve ser uma valor positivo(+) maior ou igual a 1 ");

                                    data_locacao = VerificadoresTipo.verificarData("Digitar a data de locacao: ").strip();

                                    seguro = VerificadoresTipo.verificarBoolean("Digtar: \n" +
                                            "true -- com seguro\n" +
                                            "false -- sem seguro\n");

                                    porcentagem_desconto = VerificadoresTipo.verificarDouble("Digtar o valor do desconto(MÁXIMO 12%):\n" +
                                            "OBS: deve ser uma valor positivo(+) entre 0% e 12% ");

                                    if (tempo_locacao >= 1 & (porcentagem_desconto >= 0 & porcentagem_desconto <= 12)) {

                                        if (tipo.equals("Carro")) {

                                            Carro carro = ((Carro)locadoraVeiculos.pegarDadoVeiculo(arquivo_veiculos, placa));

                                            carro.setData_locacao(data_locacao);

                                            carro.setTempo_locacao(tempo_locacao);

                                            carro.setPorcentagem_desconto(porcentagem_desconto);

                                            carro.setSeguro(seguro);

                                            carro.setCliente(locadoraVeiculos.pegarDadoCliente(arquivo_clientes, nome_cliente,
                                                    identificador_cliente));

                                            if (carro.isSeguro())
                                                valor_seguro = locadoraVeiculos.caucularSeguroCarro(carro.getValor_locacao(), carro.getQuant_passageiros());

                                            double valor_total = locadoraVeiculos.fazerCauculoLocacao(carro.getTempo_locacao(),
                                                    carro.getValor_locacao(), valor_seguro, carro.getPorcentagem_desconto());

                                            int resp = VerificadoresTipo.verificarInteiro("LOCAÇÃO:\n" +
                                                    "USUÁRIO: " + carro.getCliente().getNome() + "\n" +
                                                    "IDENTIFICADOR: " + carro.getCliente().getIdentificador() + "\n" +
                                                    "VALOR SEGURO: R$" + df.format(valor_seguro) + "\n" +
                                                    "PORCENTAGEM DESCONTO: " + carro.getPorcentagem_desconto() + "%\n" +
                                                    "TEMPO DE LOCAÇÃO: " + carro.getTempo_locacao() + "\n" +
                                                    "CARRO: " + carro.getDescricao() + "\n" +
                                                    "QUANTIDADE DE PASSAGEIROS: " + carro.getQuant_passageiros() + "\n" +
                                                    "VALOR DIÁRIA: R$" + carro.getValor_locacao() + "\n" +
                                                    "VALOR TOTAL: R$" + df.format(valor_total) + "\n" +
                                                    "DIGITAR: \n" +
                                                    "1 -- ACEITAR\n" +
                                                    "2 -- RECUSAR");

                                            if (resp == 1) {

                                                carro.setDisponibilidade(false);
                                                carro.setValor_total_locacao(Double.parseDouble(df.format(valor_total)));
                                                locadoraVeiculos.realizarLocacaoCarro(arquivo_veiculos, carro);
                                                JOptionPane.showMessageDialog(null, "LOCAÇÃO FEITA");

                                            } else {

                                                JOptionPane.showMessageDialog(null, "A LOCAÇÃO NÃO  FOI REALIZADA");

                                            }


                                        } else {

                                            Moto moto = ((Moto)locadoraVeiculos.pegarDadoVeiculo(arquivo_veiculos, placa));

                                            moto.setData_locacao(data_locacao);

                                            moto.setTempo_locacao(tempo_locacao);

                                            moto.setPorcentagem_desconto(porcentagem_desconto);

                                            moto.setSeguro(seguro);

                                            moto.setCliente(locadoraVeiculos.pegarDadoCliente(arquivo_clientes, nome_cliente,
                                                    identificador_cliente));

                                            if (moto.isSeguro())
                                                valor_seguro = locadoraVeiculos.caucularSeguroMoto(moto.getValor_locacao());


                                            double valor_total = locadoraVeiculos.fazerCauculoLocacao(moto.getTempo_locacao(),
                                                    moto.getValor_locacao(), valor_seguro, moto.getPorcentagem_desconto());



                                            int resp = VerificadoresTipo.verificarInteiro("LOCAÇÃO:\n" +
                                                    "USUÁRIO: " + moto.getCliente().getNome() + "\n" +
                                                    "IDENTIFICADOR: " + moto.getCliente().getIdentificador() + "\n" +
                                                    "VALOR SEGURO: R$" + df.format(valor_seguro) + "\n" +
                                                    "PORCENTAGEM DESCONTO: " + moto.getPorcentagem_desconto() + "%\n" +
                                                    "TEMPO DE LOCAÇÃO: " + moto.getTempo_locacao() + "DIA(S)\n" +
                                                    "MOTO: " + moto.getDescricao() + "\n" +
                                                    "PARTIDA ELÉTRICA: " + moto.isPartida_eletrica() + "\n" +
                                                    "VALOR DIÁRIA: R$" + moto.getValor_locacao() + "\n" +
                                                    "VALOR TOTAL: R$" + df.format(valor_total) + "\n" +
                                                    "DIGITAR: \n" +
                                                    "1 -- ACEITAR\n" +
                                                    "2 -- RECUSAR");

                                            if (resp == 1) {

                                                moto.setDisponibilidade(false);
                                                moto.setValor_total_locacao(Double.parseDouble(df.format(valor_total)));
                                                locadoraVeiculos.realizarLocacaoMoto(arquivo_veiculos, moto);
                                                JOptionPane.showMessageDialog(null, "LOCAÇÃO FEITA");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "A LOCAÇÃO NÃO  FOI REALIZADA");
                                            }

                                        }

                                    }else {
                                        JOptionPane.showMessageDialog(null, "A ALOCAÇÃO NÃO FOI REALIZADA:\n" +
                                                "Digite os valores corretamente");
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Esse veículo não está está disponivel para alocação");
                                }
                            }else {

                                JOptionPane.showMessageDialog(null, "Esse veículo não está cadastrado");
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
                    JOptionPane.showMessageDialog(null, "Listagem de veículos cadastrados");
                    Tela.mostrarCarros(arquivo_veiculos, true, false);
                    Tela.mostrarCarros(arquivo_veiculos, false, false);
                    Tela.mostrarMotos(arquivo_veiculos, true, false);
                    Tela.mostrarMotos(arquivo_veiculos, false, false);
                    break;
                }
                case 5: {
                    JOptionPane.showMessageDialog(null, "Listagem de clientes\n");
                    Tela.mostrarClientes(arquivo_clientes);
                    break;
                }
                case 6: {
                    JOptionPane.showMessageDialog(null, "Listagem das locações\n");
                    Tela.mostrarCarros(arquivo_veiculos, false, true);
                    Tela.mostrarMotos(arquivo_veiculos, false, true);
                    break;
                }
                case 7: {

                    JOptionPane.showMessageDialog(null, "Listagem de veículos diponíveis\n");
                    Tela.mostrarCarros(arquivo_veiculos, true, false);
                    Tela.mostrarMotos(arquivo_veiculos, true, false);
                    break;
                }
                case 8: {
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
