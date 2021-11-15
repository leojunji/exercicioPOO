package projeto_alocacao_POO;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        String firstOp;
        int opcao;
        String arquivo_clientes = "C:\\Users\\leoju\\IdeaProjects\\exercicioPOO\\src\\projeto_alocacao_POO\\dados_clientes.txt";

        String arquivo_veiculos = "C:\\Users\\leoju\\IdeaProjects\\exercicioPOO\\src\\projeto_alocacao_POO\\dados_veiculos.txt";

        Cliente cliente = new Cliente(arquivo_clientes);


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

                        double tipo = VerificadoresTipo.verificarDouble("Tipo de veículo: \n\n" +
                                "1  --  carro \n" +
                                "2  --  moto \n");

                        if (tipo == 1) {

                            Carro carro = new Carro(arquivo_veiculos);

                            if(carro.formularioCadastroCarro()) {

                                carro.cadastrarCarro();

                            }
                        } else if(tipo ==2 ){

                            Moto moto = new Moto(arquivo_veiculos);

                            if(moto.formularioCadastroMoto()) {

                                moto.cadastrarMoto();

                            }

                        }else {

                            JOptionPane.showMessageDialog(null, "Escolha um dos veículos!");
                        }


                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null, "O cadastro não foi realizado");
                    }

                    break;
                }

                case 2: {

                    try {

                        if(cliente.formularioCadastroCLiente()) {

                            //se usuario nao for existente
                            if (!BancoDados.usuarioExistente(cliente.getNome(), cliente.getIdentificador(), cliente.getArquivo_cliente())) {
                                cliente.cadastrarCliente();
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Usuario existente");
                            }

                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Voltando para o menu inicial");
                    }

                    break;
                }

                case 3: {

                    JOptionPane.showMessageDialog(null, "LOCAÇÃO DE VEICULO");

                    String nome = JOptionPane.showInputDialog("Digite o nome do usuário: ");

                    String identificador = JOptionPane.showInputDialog("Digite o identificador do usuario: ");

                    try {
                        if (!nome.equals("") & !identificador.equals("")) {

                            if (BancoDados.usuarioExistente(nome, identificador, arquivo_clientes)) {

                                double tipo = VerificadoresTipo.verificarDouble("Tipo de veículo: \n\n" +
                                        "1  --  Carro \n" +
                                        "2  --  Moto \n");

                                if(tipo==1 | tipo==2) {

                                    String tipo_veiculo = tipo==1?"Carro":"Moto";

                                    String placa = JOptionPane.showInputDialog("Digite a placa do veículo: ");

                                    if(placa.equals("")){

                                        JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
                                    }else {

                                        if (BancoDados.veiculoExistente(tipo_veiculo, placa, arquivo_veiculos)) {

                                            if(Veiculo.isVeiculoDiponivel(tipo_veiculo, placa, arquivo_veiculos)){

                                                String[] dados_veiculo = BancoDados.getDadosVeiculo(arquivo_veiculos, placa, tipo_veiculo);

                                                String[] dados_cliente = BancoDados.getDadoCliente(arquivo_clientes, nome, identificador);

                                                JOptionPane.showMessageDialog(null, "Descrição: " + dados_veiculo[4]);

                                                LocadoraVeiculos locadoraVeiculos = new LocadoraVeiculos(dados_veiculo, dados_cliente);

                                                if(locadoraVeiculos.formularioLocao()){


                                                    if(locadoraVeiculos.confirmarLocacao()) {

                                                        System.out.println("Atualizando dados");

                                                    }else {

                                                        JOptionPane.showMessageDialog(null,
                                                                "A Locação não foi realizada \n" +
                                                                "Descrição do veículo: " + dados_veiculo[4] + "\n" +
                                                                "Nome do Cliente: " + dados_cliente[0]);
                                                    }

                                                }

                                            }else{
                                                JOptionPane.showMessageDialog(null, "Este veiculo ja foi alocado");
                                            }
                                        } else {

                                            JOptionPane.showMessageDialog(null, "Este veículo não esta cadastrado");
                                        }
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Escolha um dos veículos!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Este usuário não existe");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "É necessário preeencher todos os campos");
                        }
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Não foi possível realizar a locação(main)");
                        e.printStackTrace();
                    }
                    break;
                }
                case 4: {

                    System.out.println("Listagem de veículos cadastrados\n");
                    break;
                }
                case 5: {

                    System.out.println("Listagem de clientes\n");
                    break;
                }
                case 6: {

                    System.out.println("Listagem das locações\n");
                    break;
                }
                case 7: {

                    System.out.println("Listagem de veículos disponíveis\n");
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
