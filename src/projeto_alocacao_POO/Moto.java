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



    public boolean isPartida_eletrica() {
        return partida_eletrica;
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

        this.partida_eletrica = VerificadoresTipo.verificarBoolean("digite: \n" +
                                                 "true  --  com partida eletrica\n" +
                                  "false -- sem partida eletrica");
    }
}
