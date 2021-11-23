package projeto_alocacao_POO;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Veiculo implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;
    protected String tipo;
    protected double valor_locacao;
    protected String descricao;
    protected String placa;
    protected boolean disponibilidade;
    protected boolean seguro;
    protected String data_locacao;
    protected int tempo_locacao;
    protected double porcentagem_desconto;
    protected double valor_total_locacao;
    private Cliente cliente;

    public double getValor_total_locacao() {
        return valor_total_locacao;
    }

    public void setValor_total_locacao(double valor_total_locacao) {
        this.valor_total_locacao = valor_total_locacao;
    }

    public double getPorcentagem_desconto() {
        return porcentagem_desconto;
    }

    public void setPorcentagem_desconto(double porcentagem_desconto) {
        this.porcentagem_desconto = porcentagem_desconto;
    }

    public void setData_locacao(String data_locacao) {
        this.data_locacao = data_locacao;
    }

    public int getTempo_locacao() {
        return tempo_locacao;
    }

    public void setTempo_locacao(int tempo_locacao) {
        this.tempo_locacao = tempo_locacao;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public double getValor_locacao() {
        return valor_locacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }


    public void formularioVeiculo(){

        DecimalFormat df = new DecimalFormat("#0.00");

        this.valor_locacao = VerificadoresTipo.verificarDouble("Digite o valor da locação: ");

        this.valor_locacao = Double.parseDouble(df.format(this.valor_locacao));

        this.descricao = VerificadoresTipo.verificarCampo("Digite uma descrição do veiculo: ");

        this.disponibilidade = true;

    }


    public void formularioLocacaoVeiculo(String nome, String identificador){


        this.tempo_locacao = VerificadoresTipo.verificarInteiro("Digitar o tempo de locação(MÍNIMO DE 1 DIA):\n" +
                "Deve ser uma valor positivo(+) maior ou igual a 1 ");

        this.data_locacao = VerificadoresTipo.verificarData("Digitar a data de locacao: ").strip();

        this.seguro = VerificadoresTipo.verificarBoolean("Digtar: \n" +
                "true -- com seguro\n" +
                "false -- sem seguro\n");

        this.porcentagem_desconto = VerificadoresTipo.verificarDouble("Digtar o valor do desconto(MÁXIMO 12%):\n" +
                "OBS: deve ser uma valor positivo(+) entre 0% e 12% ");

    }
}
