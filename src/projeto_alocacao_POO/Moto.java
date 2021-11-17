package projeto_alocacao_POO;

import javax.swing.*;
import java.io.Serializable;

public class Moto extends Veiculo implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;
    private boolean partida_eletrica;
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Moto( double valor_locacao, String descricao, String placa, boolean partida_eletrica) {
        super(valor_locacao, descricao, placa);
        this.partida_eletrica = partida_eletrica;
        this.tipo = "Moto";
    }


    public boolean isPartida_eletrica() {
        return partida_eletrica;
    }

    public void setPartida_eletrica(boolean partida_eletrica) {
        this.partida_eletrica = partida_eletrica;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public void cadastrarMoto(){

        String dados_veiculo  = this.isDisponibilidade() + "~" +
                this.getPlaca() + "~" +
                this.tipo + "~" +
                this.getValor_locacao() + "~" +
                this.getDescricao() + "~" +
                this.isPartida_eletrica() + ";\n";

        if(BancoDados.appendArquivo(dados_veiculo, this.arquivo_veiculo)) {

            JOptionPane.showMessageDialog(null,
                    "Cadastro da moto realizado com sucesso");
        }else{
            JOptionPane.showMessageDialog(null,
                    "Não foi possível realizar o cadastro");
        }

    }

    public boolean formularioCadastroMoto(){


        try{

            this.valor_locacao = VerificadoresTipo.verificarDouble("Digite o valor da locação: ");
            this.descricao = JOptionPane.showInputDialog("Digite uma descrição da moto: ");
            this.placa = JOptionPane.showInputDialog("Placa da moto: ");
            this.partida_eletrica = VerificadoresTipo.verificarBoolean("digite: \n" +
            "true  --  com partida eletrica\n" +
            "false -- sem partida eletrica");

            if (this.descricao.equals("") | this.placa.equals("")) {

                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
                return false;
            }

            return true;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "O cadastro não foi realizado");
            return false;
        }

    }

    public static double caucularSeguroMoto(double valor_diaria){

        return 0.09 * valor_diaria;
    }
}
