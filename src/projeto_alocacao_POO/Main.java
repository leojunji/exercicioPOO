package projeto_alocacao_POO;

import javax.swing.*;
import java.io.Serializable;
import java.text.DecimalFormat;

public class Main  implements Serializable {

    public static void main(String[] args) throws Exception {


        int opcao;
        String arquivo_clientes = "cliente.dados";

        String arquivo_veiculos = "veiculo.dados";

        DecimalFormat df = new DecimalFormat("#0.00");

        LocadoraVeiculos locadoraVeiculos = new LocadoraVeiculos("sbc");

        JOptionPane.showMessageDialog(null, "LOCADORA: " +  locadoraVeiculos.getNome_locadora());
        while(true) {

            opcao = Tela.menu();


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

                            if(tipo.equals("Carro")){

                                Carro carro = new Carro();

                                carro.setTipo(tipo);

                                carro.setPlaca(placa);

                                carro.formularioVeiculo();

                                locadoraVeiculos.cadastrarCarro(arquivo_veiculos, carro);


                            }else{

                                Moto moto = new Moto();

                                moto.setTipo(tipo);

                                moto.setPlaca(placa);

                                moto.formularioVeiculo();

                                locadoraVeiculos.cadastrarMoto(arquivo_veiculos, moto);

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

                        Cliente cliente = new Cliente();

                        cliente.formularioCliente();

                        if (locadoraVeiculos.clienteExistente(cliente.getNome(), cliente.getIdentificador(), arquivo_clientes)) {

                            JOptionPane.showMessageDialog(null, "Cliente ja existe");

                        } else {

                            locadoraVeiculos.cadastrarCliente(arquivo_clientes, cliente);

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

                    try {
                        String nome_cliente = VerificadoresTipo.verificarCampo("Nome do cliente: ");

                        String identificador_cliente = VerificadoresTipo.verificarCampo("Identificador do usuário: ");


                        if (locadoraVeiculos.clienteExistente(nome_cliente, identificador_cliente, arquivo_clientes)) {

                            int valor = VerificadoresTipo.verificarInteiro("Tipo de veículo: \n\n" +
                                    "1  --  carro \n" +
                                    "2  --  moto \n");

                            String tipo = (valor == 1 ? "Carro" : "Moto");

                            String placa = VerificadoresTipo.verificarCampo("Placa do veiculo: ").strip();

                            if (locadoraVeiculos.veiculoExistente(tipo, placa, arquivo_veiculos)) {

                                if (locadoraVeiculos.veiculoDisponivel(arquivo_veiculos, placa)) {

                                    if(tipo.equals("Carro")){

                                        Carro carro = ((Carro)locadoraVeiculos.pegarDadoVeiculo(arquivo_veiculos, placa));

                                        carro.setCliente(locadoraVeiculos.pegarDadoCliente(arquivo_clientes, nome_cliente,
                                                identificador_cliente));

                                        carro.formularioLocacaoVeiculo(nome_cliente, identificador_cliente);

                                        if (carro.getTempo_locacao() >= 1 &
                                                (carro.getPorcentagem_desconto() >= 0 & carro.getPorcentagem_desconto() <= 12)){

                                            carro.setDisponibilidade(false);

                                            double valor_seguro = 0;
                                            if (carro.isSeguro())
                                                valor_seguro = locadoraVeiculos.caucularSeguroCarro(carro.getValor_locacao(), carro.getQuant_passageiros());

                                            double valor_total = locadoraVeiculos.fazerCauculoLocacao(carro.getTempo_locacao(),
                                                    carro.getValor_locacao(), valor_seguro, carro.getPorcentagem_desconto());

                                            carro.setValor_total_locacao(Double.parseDouble(df.format(valor_total)));

                                            boolean resp = Tela.confirmarLocacao(carro, Double.parseDouble(df.format(valor_seguro)));

                                            if(resp)
                                                locadoraVeiculos.realizarLocacaoCarro(arquivo_veiculos, carro);

                                        }else{

                                            JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos corretamente");

                                        }


                                    }else{

                                        Moto moto = ((Moto)locadoraVeiculos.pegarDadoVeiculo(arquivo_veiculos, placa));

                                        moto.setCliente(locadoraVeiculos.pegarDadoCliente(arquivo_clientes, nome_cliente,
                                                identificador_cliente));

                                        moto.formularioLocacaoVeiculo(nome_cliente, identificador_cliente);

                                        if ( moto.getTempo_locacao() >= 1 &
                                                ( moto.getPorcentagem_desconto() >= 0 &  moto.getPorcentagem_desconto() <= 12)) {
                                            moto.setDisponibilidade(false);

                                            double valor_seguro = 0;
                                            if (moto.isSeguro())
                                                valor_seguro = locadoraVeiculos.caucularSeguroMoto(moto.getValor_locacao());

                                            double valor_total = locadoraVeiculos.fazerCauculoLocacao(moto.getTempo_locacao(),
                                                    moto.getValor_locacao(), valor_seguro, moto.getPorcentagem_desconto());

                                            moto.setValor_total_locacao(Double.parseDouble(df.format(valor_total)));

                                            boolean resp = Tela.confirmarLocacao(moto, Double.parseDouble(df.format(valor_seguro)));

                                            if(resp)
                                                locadoraVeiculos.realizarLocacaoMoto(arquivo_veiculos, moto);

                                        }else{

                                            JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos corretamente");

                                        }
                                    }
                                }
                            }else{
                                JOptionPane.showMessageDialog(null,
                                        "Este veículo não está cadastrado");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,
                                    "Este cliente não está cadastrado");
                        }



                }catch (Exception e){
                        JOptionPane.showMessageDialog(null, "A locação não foi realizada");
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
                    break;
                }
            }
        }

    }
}
