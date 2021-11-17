package projeto_alocacao_POO;

import javax.swing.*;
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

    public Carro(double valor_locacao, String descricao, String placa, int quant_passageiros) {
        super(valor_locacao, descricao, placa);
        this.quant_passageiros = quant_passageiros;
        this.tipo = "Carro";
    }


    public int getQuant_passageiros() {
        return quant_passageiros;
    }

    public void setQuant_passageiros(int quant_passageiros) {
        this.quant_passageiros = quant_passageiros;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void cadastrarCarro(){

        String dados_veiculo  = this.isDisponibilidade() + "~" +
                this.getPlaca() + "~" +
                this.tipo + "~" +
                this.getValor_locacao() + "~" +
                this.getDescricao() + "~" +
                this.quant_passageiros + ";\n";

        if(BancoDados.appendArquivo(dados_veiculo, this.arquivo_veiculo)) {

            JOptionPane.showMessageDialog(null,
                    "Cadastro do carro realizado com sucesso");
        }else{
            JOptionPane.showMessageDialog(null,
                    "Não foi possível realizar o cadastro");
        }

    }

    public boolean formularioCadastroCarro(){

        try{

            this.valor_locacao = VerificadoresTipo.verificarDouble("Digite o valor da locação: ");
            this.descricao = JOptionPane.showInputDialog("Digite uma descrição do carro: ");
            this.placa = JOptionPane.showInputDialog("Placa do carro: ");
            this.quant_passageiros = VerificadoresTipo.verificarInteiro("Digite a quantidade de passageiros: ");

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

    public static double caucularSeguroCarro(double valor_diaria, int numero_passageiros){

        return 0.05 * valor_diaria * (1 + (float)numero_passageiros/20);

    }
}
