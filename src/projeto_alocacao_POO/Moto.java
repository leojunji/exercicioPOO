package projeto_alocacao_POO;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
