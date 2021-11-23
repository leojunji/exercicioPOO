package projeto_alocacao_POO;

import java.io.Serializable;

public class Carro extends Veiculo implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;
    private int quant_passageiros;
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



    public int getQuant_passageiros() {
        return quant_passageiros;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void formularioVeiculo() {
        super.formularioVeiculo();

        this.quant_passageiros = VerificadoresTipo.verificarInteiro("Digite a quantidade de passageiros: ");
    }
}

/**
 * if(tipo.equals("Carro")){
 *
 *
 *
 *                         locadoraVeiculos.cadastrarCarro(arquivo_veiculos,
 *                                 new Carro(valor_locacao, descriçao, placa, quant_passageiros));
 *
 *
 *                     }else {
 *
 *                         boolean partida_eletrica = VerificadoresTipo.verificarBoolean("digite: \n" +
 *                                 "true  --  com partida eletrica\n" +
 *                                 "false -- sem partida eletrica");
 *
 *
 *                         locadoraVeiculos.cadastrarMoto(arquivo_veiculos, new Moto(valor_locacao, descriçao, placa, partida_eletrica));
 *                     }
 *
 *                 }catch (Exception e){
 *                     JOptionPane.showMessageDialog(null,
 *                             "Não foi possível realizar o cadastro do veículo");
 *                 }
 *
 *             } else {
 *                 JOptionPane.showMessageDialog(null, "O veículo ja está cadastrado " +
 *                         "\nTipo: " + tipo + "\n Placa: " + placa);
 *             }
 *
 *
 *         }catch (Exception e){
 *
 *             JOptionPane.showMessageDialog(null,
 *                     "É necessário preencher todos os campos corretamente");
 *         }
 *
 * */
