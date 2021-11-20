package projeto_alocacao_POO;

import java.io.Serializable;

public class Veiculo implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;
    protected String tipo;
    protected double valor_locacao;
    protected String descricao;
    protected String placa;
    protected String arquivo_veiculo;
    protected boolean disponibilidade;
    protected boolean seguro;
    protected String data_locacao;
    protected int tempo_locacao;
    protected double porcentagem_desconto;
    protected double valor_total_locacao;

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

    public Veiculo(double valor_locacao, String descricao, String placa) {
        this.valor_locacao = valor_locacao;
        this.descricao = descricao;
        this.placa = placa;
        this.disponibilidade = true;
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

    public boolean isDisponibilidade() {
        return disponibilidade;
    }
}
