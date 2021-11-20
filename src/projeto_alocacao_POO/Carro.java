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

    public Carro(double valor_locacao, String descricao, String placa, int quant_passageiros) {
        super(valor_locacao, descricao, placa);
        this.quant_passageiros = quant_passageiros;
        this.tipo = "Carro";
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
}
