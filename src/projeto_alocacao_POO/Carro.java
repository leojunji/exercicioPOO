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
